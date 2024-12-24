package br.com.forumhub.domain.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AnswerUpdatingDataReceiverDTO(
        @NotNull
        Long id,
        @JsonProperty("mensagem")
        @NotBlank
        String message
) {
}
