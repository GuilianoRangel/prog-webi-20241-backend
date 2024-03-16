package br.ueg.progweb1.aula01.exceptions;

public class BusinessLogicException extends RuntimeException{
    public BusinessLogicException(String message, Throwable e){
        super(message, e);
    }
    public BusinessLogicException(String message){
        super(message);
    }
}
