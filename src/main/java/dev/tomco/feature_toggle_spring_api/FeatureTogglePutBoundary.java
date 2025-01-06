package dev.tomco.feature_toggle_spring_api;

import java.time.LocalDateTime;

public class FeatureTogglePutBoundary {
    private LocalDateTime beginningDate;
    private LocalDateTime expirationDate;

    public FeatureTogglePutBoundary() {
    }

    // Getters and setters

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

    // toString
    @Override
    public String toString() {
        return "FeatureTogglePutBoundary{" +
                "beginningDate=" + beginningDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
