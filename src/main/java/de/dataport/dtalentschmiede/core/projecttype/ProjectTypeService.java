package de.dataport.dtalentschmiede.core.projecttype;

import de.dataport.dtalentschmiede.persistence.projecttype.ProjectTypeEntity;
import de.dataport.dtalentschmiede.persistence.projecttype.ProjectTypePersistenceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Class "ProjectTypeService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class ProjectTypeService {

    private final ProjectTypePersistenceService projectTypePersistenceService;

    public ProjectTypeService(ProjectTypePersistenceService projectTypePersistenceService) {
        this.projectTypePersistenceService = projectTypePersistenceService;
    }

    public ProjectType createProjectType() {
        return new ProjectTypeImpl(projectTypePersistenceService.createProjectTypeEntity());
    }

    public ProjectType persistProjectType(@NonNull ProjectType projectType) {
        ProjectTypeEntity persistedProjectTypeEntity = projectTypePersistenceService.persistProjectType((( ProjectTypeImpl) projectType).getProjectTypeEntity());
        return new ProjectTypeImpl(persistedProjectTypeEntity);
    }

    public List<ProjectType> findAllProjectTypes() {
        return projectTypePersistenceService.findAllProjectTypes()
                .stream()
                .map(ProjectTypeImpl::new)
                .collect(Collectors.toList());
    }

    public ProjectType findProjectTypeById(long projectTypeId) {
        try {
            return new ProjectTypeImpl(projectTypePersistenceService.findProjectTypeById(projectTypeId));
        } catch (Exception exception) {
            throw new NoSuchElementException("projecttype with id: " + projectTypeId + " could not be found.");
        }
    }

    public ProjectType updateProjectType(long projectTypeId, @NonNull ProjectType projectType) {
        final ProjectTypeEntity updatedProjectTypeEntity;
        try {
            updatedProjectTypeEntity = projectTypePersistenceService.updateProjectType(projectTypeId, (( ProjectTypeImpl) projectType).getProjectTypeEntity());
        } catch (Exception exception) {
            throw new RuntimeException("projecttype with id: " + projectTypeId + " could not be updated.");
        }
        return new ProjectTypeImpl(updatedProjectTypeEntity);
    }

    public void deleteProjectType(@NonNull ProjectType projectType) {
        projectTypePersistenceService.deleteProjectType((( ProjectTypeImpl) projectType).getProjectTypeEntity());
    }

    public void deleteProjectTypeById(long projectTypeId) {
        projectTypePersistenceService.deleteProjectTypeById(projectTypeId);
    }
}
