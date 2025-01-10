package dev.tomco.feature_toggle_spring_api;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FeatureToggleController {
    private FeatureToggleService featureToggleService;

    public FeatureToggleController(FeatureToggleService featureToggleService) {
        this.featureToggleService = featureToggleService;
    }

    @PostMapping("/feature-toggle")
    public FeatureToggleBoundary postFeatureToggle(@RequestBody FeatureTogglePostBoundary dto) {
        System.err.println("*************" + dto);
        return featureToggleService.createFeatureToggle(dto.getPackageName(), dto);
    }

    @GetMapping("/feature-toggles/{package_name}")
    public List<FeatureToggleBoundary> getAllFeatureToggleByPackageName(
            @PathVariable("package_name") String packageName) {
        System.err.println("*************" + packageName);
        return featureToggleService
                .getAllByPackageName(packageName);

    }

    // GET /feature-toggle/{package_name}/{feature_id}
    @GetMapping("/feature-toggles/{packageName}/{featureId}")
    public FeatureToggleBoundary getFeatureToggle(@PathVariable("packageName") String packageName,
            @PathVariable("featureId") String featureId) {
        System.err.println("*************" + packageName);
        return featureToggleService
                .getFeatureToggleById(packageName, featureId)
                .orElseThrow(() -> new FeatureToggleNotFoundException(
                        "No feature toggles found for package: " + packageName));
    }

    // GET /feature-toggles/{package_name}/active
    @GetMapping("/feature-toggles/{packageName}/active")
    public List<FeatureToggleBoundary> getActiveFeatureToggles(@PathVariable("packageName") String packageName) {
        System.err.println("*************" + packageName);
        return featureToggleService
                .getAllActiveFeatureTogglesByPackageName(packageName);
    }

    // GET /feature-toggles/{package_name}/by-date
    @GetMapping("/feature-toggles/{packageName}/by-date")
    public List<FeatureToggleBoundary> getFeatureTogglesByDate(
            @PathVariable("packageName") String packageName,
            @RequestParam String date) {
        System.err.println("*************" + packageName);
        return featureToggleService
                .getAllFeatureTogglesByPackageNameAndDate(packageName, LocalDateTime.parse(date));
    }

    // PUT /feature-toggle/{package_name}/{feature_id}/update-dates
    @PutMapping("/feature-toggle/{packageName}/{featureId}/update-dates")
    public void updateFeatureToggleDates(
            @PathVariable("packageName") String packageName,
            @PathVariable("featureId") String featureId,
            @RequestBody FeatureTogglePutBoundary request) {
        featureToggleService.updateFeatureToggleDates(
            packageName,
             featureId,
              request.getBeginningDate(),
               request.getExpirationDate());
    }

    // DELETE /feature-toggles
    @DeleteMapping("/feature-toggles")
    public String deleteAllFeatureToggles() {
        // Logic to delete all feature toggles
        return "All feature toggles deleted";
    }
}
