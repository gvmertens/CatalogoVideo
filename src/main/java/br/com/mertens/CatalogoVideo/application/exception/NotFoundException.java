package br.com.mertens.CatalogoVideo.application.exception;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(){
        super();
    }

    public NotFoundException(String message, Object... args){
        super(String.format(message, args));
    }
}
