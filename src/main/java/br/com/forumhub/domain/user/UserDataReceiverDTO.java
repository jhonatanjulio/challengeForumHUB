package br.com.forumhub.domain.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record UserDataReceiverDTO(
        @NotBlank
        @JsonAlias("nome")
        String name,
        @NotBlank
        String email,
        @NotBlank
        @JsonAlias("senha")
        String password) {
}
