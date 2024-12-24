package br.com.forumhub.domain.answer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record AnswerDisplayDAO(
        Long id,
        @JsonProperty("mensagem")
        String message,
        @JsonProperty("data_criacao")
        LocalDateTime creationDate,
        @JsonProperty("topico")
        Long topic
) {
    public AnswerDisplayDAO(Answer a) {
        this(a.getId(), a.getMessage(), a.getCreationDate(), a.getTopic().getId());
    }
}
