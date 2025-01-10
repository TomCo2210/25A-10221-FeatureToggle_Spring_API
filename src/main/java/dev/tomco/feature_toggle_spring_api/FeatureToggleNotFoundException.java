package dev.tomco.feature_toggle_spring_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeatureToggleNotFoundException extends RuntimeException {

    

    public FeatureToggleNotFoundException(String message) {
        super(message);
    }

    public FeatureToggleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
