package com.mkalaimalai.payment_service.exception;

public class ResourceNotFoundException extends RuntimeException {

    private Resource resource;


    public ResourceNotFoundException(Resource resource, String message) {
        super(message);
        this.resource = resource;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public enum Resource {
        Customer;
    }
}
