package br.com.bspicinini.forum.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException() {
        super("Erro de negócio");
    }

    public BusinessException(String message) {
        super(message);
    }
}
