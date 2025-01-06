package dev.tomco.feature_toggle_spring_api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FeatureToggleService {

    FeatureToggleBoundary createFeatureToggle(String packageName, FeatureTogglePostBoundary Boundary);

    List<FeatureToggleBoundary> getAllByPackageName(String packageName);

    Optional<FeatureToggleBoundary> getFeatureToggleById(String packageName, String id);

    List<FeatureToggleBoundary> getAllActiveFeatureTogglesByPackageName(String packageName);

    List<FeatureToggleBoundary> getAllFeatureTogglesByPackageNameAndDate(String packageName, LocalDateTime date);

    void updateFeatureToggleDates(String packageName, String id, LocalDateTime beginningDate,
            LocalDateTime expirationDate);

    void deleteAll();

}
