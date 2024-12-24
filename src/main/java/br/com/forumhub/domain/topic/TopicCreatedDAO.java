package br.com.forumhub.domain.topic;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record TopicCreatedDAO(
        @JsonProperty("titulo") String title,
        @JsonProperty("mensagem") String message,
        @JsonProperty("data_criacao") LocalDateTime creationDate,
        Status status,
        @JsonProperty("autor") Long author) {
    public TopicCreatedDAO(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(), topic.getAuthor().getId());
    }
}
