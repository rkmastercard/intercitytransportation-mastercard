package org.mann.connectedcities.exception;

public class InterCityMappingFileException extends RuntimeException{

    public InterCityMappingFileException(String exceptionMessage){
        super(exceptionMessage);
    }

    public InterCityMappingFileException(String exceptionMessage, Throwable exp){
        super(exceptionMessage, exp);
    }
}
