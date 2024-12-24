package br.com.forumhub.infra.exception;

public class UnauthorizedModificationException extends RuntimeException {
    public UnauthorizedModificationException(String message) {
        super(message);
    }
}
