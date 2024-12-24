package br.com.forumhub.infra.exception;

public class TopicAlreadyAnsweredException extends RuntimeException {
    public TopicAlreadyAnsweredException(String message) {
        super(message);
    }
}
