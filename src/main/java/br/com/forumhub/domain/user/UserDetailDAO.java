package br.com.forumhub.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDetailDAO(@JsonProperty("nome") String name, String email) {
}
