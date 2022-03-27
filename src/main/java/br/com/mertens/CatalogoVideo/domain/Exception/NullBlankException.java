package br.com.mertens.CatalogoVideo.domain.Exception;

public class NullBlankException extends DomainException {
    public NullBlankException() {
        super();
    }
    
    public NullBlankException(String message) {
        super(message);
    }
}
