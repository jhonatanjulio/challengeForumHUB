package br.com.forumhub.domain.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record AnswerDisplayDetailDAO(
        @JsonProperty("mensagem")
        String message,
        @JsonProperty("data_criacao")
        LocalDateTime creationDate,
        @JsonProperty("topico")
        Long topic,
        @JsonProperty("autor")
        Long author,
        @JsonProperty("titulo_topico")
        String topicTitle,
        @JsonProperty("nome_autor")
        String authorName,
        @JsonProperty("solucao")
        boolean solution
) {
    public AnswerDisplayDetailDAO(Answer answer) {
        this(answer.getMessage(), answer.getCreationDate(), answer.getTopic().getId(), answer.getAuthor().getId(),
                answer.getTopic().getTitle(), answer.getAuthor().getName(), answer.isSolution());
    }
}
