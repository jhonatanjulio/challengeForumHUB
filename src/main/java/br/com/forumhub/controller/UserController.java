package br.com.forumhub.controller;

import br.com.forumhub.domain.user.*;
import br.com.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity signUpUser(@RequestBody @Valid UserDataReceiverDTO data, UriComponentsBuilder uriBuilder) {
        var user = new User(data);
        repository.save(user);
        var location = uriBuilder.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(new UserDetailDAO(user.getName(), user.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity signIn(@RequestBody @Valid UserLoginDataReceiverDTO loginData) {
        var tokenSecurity = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
        var auth = manager.authenticate(tokenSecurity);
        var tokenJWT = tokenService.createToken((User) auth.getPrincipal());
        return ResponseEntity.ok(tokenJWT);
    }

}
