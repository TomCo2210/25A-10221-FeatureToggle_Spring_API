package dev.tomco.feature_toggle_spring_api;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FeatureToggleEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime beginning_date;
    private LocalDateTime expiration_date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public FeatureToggleEntity() {
    }

    // getters and setters
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    // toString
    @Override
    public String toString() {
        return "FeatureToggle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", beginning_date=" + beginning_date +
                ", expiration_date=" + expiration_date +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
