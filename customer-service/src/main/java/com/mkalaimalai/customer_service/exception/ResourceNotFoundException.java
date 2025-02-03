package com.mkalaimalai.customer_service.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    private Resource resource;


    public ResourceNotFoundException(Resource resource, String message) {
        super(message);
        this.resource = resource;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(UUID id, String userNotFound) {
    }

    public enum Resource {
        Customer;
    }
}
