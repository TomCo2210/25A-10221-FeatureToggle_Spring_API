package dev.tomco.feature_toggle_spring_api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeatureToggleCRUD extends MongoRepository<FeatureToggleEntity, String> {
    
}
