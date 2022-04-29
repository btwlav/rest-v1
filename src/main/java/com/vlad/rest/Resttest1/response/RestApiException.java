package com.vlad.rest.Resttest1.response;

import jdk.jshell.spi.ExecutionControl;

public class RestApiException extends ExecutionControl.InternalException {
    public RestApiException(String message) {
        super(message);
    }
}
