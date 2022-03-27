package br.com.mertens.CatalogoVideo.domain.Exception;

public class DomainException extends RuntimeException {

    public DomainException() {
        super();
    }
    
    public DomainException(String message) {
        super(message);
    }
}
