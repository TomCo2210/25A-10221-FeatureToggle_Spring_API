package dev.tomco.feature_toggle_spring_api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeatureToggleServiceImpl implements FeatureToggleService {

    private FeatureToggleCRUD featureToggleCRUD;
    private MongoTemplate mongoTemplate;
    private FeatureToggleConverter featureToggleConverter;

    public FeatureToggleServiceImpl(FeatureToggleCRUD featureToggleCRUD, MongoTemplate mongoTemplate,
            FeatureToggleConverter featureToggleConverter) {
        this.featureToggleCRUD = featureToggleCRUD;
        this.mongoTemplate = mongoTemplate;
        this.featureToggleConverter = featureToggleConverter;
    }

    @Override
    @Transactional(readOnly = false)
    public FeatureToggleBoundary createFeatureToggle(String packageName, FeatureTogglePostBoundary Boundary) {
        FeatureToggleBoundary featureToggleBoundary = this.featureToggleConverter
                .convertPostBoundaryToBoundary(Boundary);

        featureToggleBoundary.setId(UUID.randomUUID().toString());

        FeatureToggleEntity entity = this.featureToggleConverter.convertBoundaryToEntity(featureToggleBoundary);
        entity.setCreated_at(LocalDateTime.now());
        entity.setUpdated_at(LocalDateTime.now());

        entity = mongoTemplate
                .insert(FeatureToggleEntity.class)
                .inCollection(packageName)
                .one(entity);

        return this.featureToggleConverter.convertEntityToBoundary(entity);
    }

    @Override
    public List<FeatureToggleBoundary> getAllByPackageName(String packageName) {
        List<FeatureToggleBoundary> all = this.mongoTemplate
                .query(FeatureToggleEntity.class)
                .inCollection(packageName)
                .as(FeatureToggleEntity.class)
                .all()
                .stream()
                .map(this.featureToggleConverter::convertEntityToBoundary)
                .toList();

        return all;
    }

    @Override
    public Optional<FeatureToggleBoundary> getFeatureToggleById(String packageName, String id) {
        Optional<FeatureToggleBoundary> optional = this.mongoTemplate
                .query(FeatureToggleEntity.class)
                .inCollection(packageName)
                .as(FeatureToggleEntity.class)
                .matching(query(where("id").is(id)))
                .one()
                .map(this.featureToggleConverter::convertEntityToBoundary);

        return optional;
    }

    @Override
    public List<FeatureToggleBoundary> getAllActiveFeatureTogglesByPackageName(String packageName) {
        LocalDateTime now = LocalDateTime.now();

        List<FeatureToggleBoundary> all = this.mongoTemplate
                .query(FeatureToggleEntity.class)
                .inCollection(packageName)
                .as(FeatureToggleEntity.class)
                .matching(query(where("expiration_date").gt(now).and("beginning_date").lt(now)))
                .all()
                .stream()
                .map(this.featureToggleConverter::convertEntityToBoundary)
                .toList();

        return all;
    }

    @Override
    public List<FeatureToggleBoundary> getAllFeatureTogglesByPackageNameAndDate(String packageName,
            LocalDateTime date) {

        List<FeatureToggleBoundary> all = this.mongoTemplate
                .query(FeatureToggleEntity.class)
                .inCollection(packageName)
                .as(FeatureToggleEntity.class)
                .matching(query(where("expiration_date").gt(date).and("beginning_date").lt(date)))
                .all()
                .stream()
                .map(this.featureToggleConverter::convertEntityToBoundary)
                .toList();

        return all;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateFeatureToggleDates(String packageName, String id, LocalDateTime beginningDate,
            LocalDateTime expirationDate) {
        FeatureToggleEntity entity = this.mongoTemplate
                .query(FeatureToggleEntity.class)
                .inCollection(packageName)
                .as(FeatureToggleEntity.class)
                .matching(query(where("id").is(id)))
                .oneValue();

        if (entity == null) {
            throw new RuntimeException("Feature Toggle not found");
        }

        if (beginningDate.isAfter(expirationDate))
            throw new RuntimeException("Beginning date must be before expiration date");

        if (expirationDate.isBefore(entity.getBeginning_date())) {
            throw new RuntimeException("Beginning date must be before expiration date");
        }

        if (beginningDate.isAfter(entity.getExpiration_date())) {
            throw new RuntimeException("Beginning date must be before expiration date");
        }

        entity.setBeginning_date(beginningDate);
        entity.setExpiration_date(expirationDate);
        entity.setUpdated_at(LocalDateTime.now());

        this.mongoTemplate
                .update(FeatureToggleEntity.class)
                .inCollection(packageName)
                .matching(query(where("id").is(id)))
                .replaceWith(entity);
    }

    @Override
    public void deleteAll() {
        this.featureToggleCRUD.deleteAll();
    }

}
