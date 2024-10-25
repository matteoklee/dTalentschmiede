package de.dataport.dtalentschmiede.persistence.technology;

import jakarta.persistence.EntityExistsException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class "TechnologyPersistenceService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class TechnologyPersistenceService {

    private final TechnologyRepository technologyRepository;

    public TechnologyPersistenceService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public TechnologyEntity createTechnologyEntity() {
        return new TechnologyEntity();
    }

    public List<TechnologyEntity> findAllTechnologys() {
        return new ArrayList<>(technologyRepository.findAll());
    }

    public TechnologyEntity findTechnologyById(long technologyId) {
        return technologyRepository.findById(technologyId)
                .orElseThrow(() -> new NoSuchElementException("unknown technology entity with id: " + technologyId));
    }

    public TechnologyEntity updateTechnology(long technologyId, @NonNull TechnologyEntity technologyEntity) {
        TechnologyEntity updatedTechnologyEntity = findTechnologyById(technologyId);
        updatedTechnologyEntity.setTechnologyId(technologyEntity.getTechnologyId());
        updatedTechnologyEntity.setTechnologyName(technologyEntity.getTechnologyName());
        updatedTechnologyEntity.setTechnologyValue(technologyEntity.getTechnologyValue());
        return persistTechnology(updatedTechnologyEntity);
    }

    public TechnologyEntity persistTechnology(@NonNull final TechnologyEntity technologyEntity) {
        try {
            return technologyRepository.save(technologyEntity);
        } catch (EntityExistsException exception) {
            throw new EntityExistsException("technologyentity with id:" + technologyEntity.getTechnologyId() + " already exists.");
        }
    }

    public void deleteTechnology(@NonNull final TechnologyEntity technologyEntity) {
        technologyRepository.deleteById(technologyEntity.getTechnologyId());
    }

    public void deleteTechnologyById(long technologyId) {
        technologyRepository.deleteById(technologyId);
    }
}

