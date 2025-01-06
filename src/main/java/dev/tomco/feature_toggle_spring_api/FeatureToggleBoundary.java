package dev.tomco.feature_toggle_spring_api;

import java.time.LocalDateTime;

public class FeatureToggleBoundary {
    private String id;
    private String name;
    private String description;
    private LocalDateTime beginningDate;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDateTime beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // toString
    @Override
    public String toString() {
        return "FeatureToggle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", beginning_date=" + beginningDate +
                ", expiration_date=" + expirationDate +
                ", created_at=" + createdAt +
                ", updated_at=" + updatedAt +
                '}';
    }
}
