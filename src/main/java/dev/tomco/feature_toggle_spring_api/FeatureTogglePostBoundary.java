package dev.tomco.feature_toggle_spring_api;

import java.time.LocalDateTime;

public class FeatureTogglePostBoundary {

    private String name;
    private String description;
    private LocalDateTime beginning_date;
    private LocalDateTime expiration_date;
    private String packageName;

    public FeatureTogglePostBoundary() {
    }

    // getters and setters
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getBeginning_date() {
        return beginning_date;
    }

    public void setBeginning_date(LocalDateTime beginning_date) {
        this.beginning_date = beginning_date;
    }

    public LocalDateTime getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDateTime expiration_date) {
        this.expiration_date = expiration_date;
    }

    // toString
    @Override
    public String toString() {
        return "FeatureToggle{" +
                "packageName='" + packageName + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", beginning_date=" + beginning_date +
                ", expiration_date=" + expiration_date +
                '}';
    }
}
