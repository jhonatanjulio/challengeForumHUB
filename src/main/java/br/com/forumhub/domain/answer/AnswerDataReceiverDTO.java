package br.com.forumhub.domain.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AnswerDataReceiverDTO(
        @JsonProperty("mensagem")
        @NotBlank
        String message,
        @JsonProperty("data_criacao")
        @NotNull
        @FutureOrPresent
        LocalDateTime creationDate,
        @JsonProperty("topico")
        @NotNull
        Long topic
) {
}
