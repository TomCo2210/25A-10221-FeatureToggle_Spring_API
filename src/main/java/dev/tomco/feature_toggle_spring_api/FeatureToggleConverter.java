package dev.tomco.feature_toggle_spring_api;

public class FeatureToggleConverter {

    public FeatureToggleBoundary convertPostBoundaryToBoundary(FeatureTogglePostBoundary postBoundary) {
        FeatureToggleBoundary boundary = new FeatureToggleBoundary();
        boundary.setName(postBoundary.getName());
        boundary.setDescription(postBoundary.getDescription());
        boundary.setBeginningDate(postBoundary.getBeginning_date());
        boundary.setExpirationDate(postBoundary.getExpiration_date());
        return boundary;
    }

    public FeatureToggleBoundary convertEntityToBoundary(FeatureToggleEntity entity) {
        FeatureToggleBoundary boundary = new FeatureToggleBoundary();
        boundary.setId(entity.getId());
        boundary.setName(entity.getName());
        boundary.setDescription(entity.getDescription());
        boundary.setBeginningDate(entity.getBeginning_date());
        boundary.setExpirationDate(entity.getExpiration_date());
        boundary.setCreatedAt(entity.getCreated_at());
        boundary.setUpdatedAt(entity.getUpdated_at());
        return boundary;
    }

    public FeatureToggleEntity convertBoundaryToEntity(FeatureToggleBoundary boundary) {
        FeatureToggleEntity entity = new FeatureToggleEntity();
        entity.setId(boundary.getId());
        entity.setName(boundary.getName());
        entity.setDescription(boundary.getDescription());
        entity.setBeginning_date(boundary.getBeginningDate());
        entity.setExpiration_date(boundary.getExpirationDate());
        entity.setCreated_at(boundary.getCreatedAt());
        entity.setUpdated_at(boundary.getUpdatedAt());
        return entity;
    }
}
