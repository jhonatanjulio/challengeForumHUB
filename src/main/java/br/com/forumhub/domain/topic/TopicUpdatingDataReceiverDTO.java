package br.com.forumhub.domain.topic;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicUpdatingDataReceiverDTO(
        @NotNull
        Long id,
        @JsonAlias("titulo")
        @NotBlank
        String title,
        @JsonAlias("mensagem")
        @NotBlank
        String message
        ) {
}
