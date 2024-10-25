package de.dataport.dtalentschmiede.core.technology;

import de.dataport.dtalentschmiede.persistence.technology.TechnologyEntity;
import de.dataport.dtalentschmiede.persistence.technology.TechnologyPersistenceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Class "TechnologyService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class TechnologyService {

    private final TechnologyPersistenceService technologyPersistenceService;

    public TechnologyService(TechnologyPersistenceService technologyPersistenceService) {
        this.technologyPersistenceService = technologyPersistenceService;
    }

    public Technology createTechnology() {
        return new TechnologyImpl(technologyPersistenceService.createTechnologyEntity());
    }

    public Technology persistTechnology(@NonNull Technology technology) {
        TechnologyEntity persistedTechnologyEntity = technologyPersistenceService.persistTechnology((( TechnologyImpl) technology).getTechnologyEntity());
        return new TechnologyImpl(persistedTechnologyEntity);
    }

    public List<Technology> findAllTechnologys() {
        return technologyPersistenceService.findAllTechnologys()
                .stream()
                .map(TechnologyImpl::new)
                .collect(Collectors.toList());
    }

    public Technology findTechnologyById(long technologyId) {
        try {
            return new TechnologyImpl(technologyPersistenceService.findTechnologyById(technologyId));
        } catch (Exception exception) {
            throw new NoSuchElementException("technology with id: " + technologyId + " could not be found.");
        }
    }

    public Technology updateTechnology(long technologyId, @NonNull Technology technology) {
        final TechnologyEntity updatedTechnologyEntity;
        try {
            updatedTechnologyEntity = technologyPersistenceService.updateTechnology(technologyId, (( TechnologyImpl) technology).getTechnologyEntity());
        } catch (Exception exception) {
            throw new RuntimeException("technology with id: " + technologyId + " could not be updated.");
        }
        return new TechnologyImpl(updatedTechnologyEntity);
    }

    public void deleteTechnology(@NonNull Technology technology) {
        technologyPersistenceService.deleteTechnology((( TechnologyImpl) technology).getTechnologyEntity());
    }

    public void deleteTechnologyById(long technologyId) {
        technologyPersistenceService.deleteTechnologyById(technologyId);
    }
}

