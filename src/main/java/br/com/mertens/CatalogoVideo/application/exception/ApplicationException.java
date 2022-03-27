package br.com.mertens.CatalogoVideo.application.exception;

public class ApplicationException extends RuntimeException {
    
    public ApplicationException(String message){
        super(message);
    }

    public ApplicationException(){
        super();
    }
}
