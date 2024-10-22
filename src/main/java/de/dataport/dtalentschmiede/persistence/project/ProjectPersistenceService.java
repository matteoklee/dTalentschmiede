package de.dataport.dtalentschmiede.persistence.project;

import jakarta.persistence.EntityExistsException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class "ProjectPersistenceService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
@Service
public class ProjectPersistenceService {

    private final ProjectRepository projectRepository;

    public ProjectPersistenceService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectEntity createProjectEntity() {
        return new ProjectEntity();
    }

    public List<ProjectEntity> findAllProjects() {
        return new ArrayList<>(projectRepository.findAll());
    }

    public ProjectEntity findProjectById(long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("unknown project entity with id: " + projectId));
    }

    public ProjectEntity updateProject(long projectId, @NonNull ProjectEntity projectEntity) {
        ProjectEntity updatedProjectEntity = findProjectById(projectId);
        updatedProjectEntity.setProjectTitle(projectEntity.getProjectTitle());
        updatedProjectEntity.setProjectDescription(projectEntity.getProjectDescription());
        updatedProjectEntity.setProjectRepresentative(projectEntity.getProjectRepresentative());
        updatedProjectEntity.setProjectStatus(projectEntity.getProjectStatus());
        updatedProjectEntity.setProjectTypes(projectEntity.getProjectTypes());
        updatedProjectEntity.setProjectTechnologies(projectEntity.getProjectTechnologies());
        updatedProjectEntity.setProjectSoftSkills(projectEntity.getProjectSoftSkills());
        updatedProjectEntity.setProjectHardSkills(projectEntity.getProjectHardSkills());
        updatedProjectEntity.setProjectUpdatedAt(new Date());

        return persistProject(updatedProjectEntity);
    }

    public ProjectEntity persistProject(@NonNull final ProjectEntity projectEntity) {
        try {
            return projectRepository.save(projectEntity);
        } catch (EntityExistsException exception) {
            throw new EntityExistsException("projectEntity with id:" + projectEntity.getProjectId() + " already exists.");
        }
    }

    public void deleteProject(@NonNull final ProjectEntity projectEntity) {
        projectRepository.deleteById(projectEntity.getProjectId());
    }

}
