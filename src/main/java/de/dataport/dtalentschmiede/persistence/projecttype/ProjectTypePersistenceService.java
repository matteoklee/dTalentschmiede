package de.dataport.dtalentschmiede.persistence.projecttype;

import jakarta.persistence.EntityExistsException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class "ProjectTypePersistenceService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class ProjectTypePersistenceService {

    private final ProjectTypeRepository projectTypeRepository;

    public ProjectTypePersistenceService(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    public ProjectTypeEntity createProjectTypeEntity() {
        return new ProjectTypeEntity();
    }

    public List<ProjectTypeEntity> findAllProjectTypes() {
        return new ArrayList<>(projectTypeRepository.findAll());
    }

    public ProjectTypeEntity findProjectTypeById(long projectTypeId) {
        return projectTypeRepository.findById(projectTypeId)
                .orElseThrow(() -> new NoSuchElementException("unknown projecttype entity with id: " + projectTypeId));
    }

    public ProjectTypeEntity updateProjectType(long projectTypeId, @NonNull ProjectTypeEntity projectTypeEntity) {
        ProjectTypeEntity updatedProjectTypeEntity = findProjectTypeById(projectTypeId);
        updatedProjectTypeEntity.setProjectTypeId(projectTypeEntity.getProjectTypeId());
        updatedProjectTypeEntity.setProjectTypeName(projectTypeEntity.getProjectTypeName());
        updatedProjectTypeEntity.setProjectTypeValue(projectTypeEntity.getProjectTypeValue());
        return persistProjectType(updatedProjectTypeEntity);
    }

    public ProjectTypeEntity persistProjectType(@NonNull final ProjectTypeEntity projectTypeEntity) {
        try {
            return projectTypeRepository.save(projectTypeEntity);
        } catch (EntityExistsException exception) {
            throw new EntityExistsException("projecttypeentity with id:" + projectTypeEntity.getProjectTypeId() + " already exists.");
        }
    }

    public void deleteProjectType(@NonNull final ProjectTypeEntity projectTypeEntity) {
        projectTypeRepository.deleteById(projectTypeEntity.getProjectTypeId());
    }

    public void deleteProjectTypeById(long projectTypeId) {
        projectTypeRepository.deleteById(projectTypeId);
    }
}
