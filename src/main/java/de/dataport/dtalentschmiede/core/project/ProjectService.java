package de.dataport.dtalentschmiede.core.project;

import de.dataport.dtalentschmiede.persistence.project.ProjectEntity;
import de.dataport.dtalentschmiede.persistence.project.ProjectPersistenceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Class "ProjectService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
@Service
public class ProjectService {
    private final ProjectPersistenceService projectPersistenceService;

    public ProjectService(ProjectPersistenceService projectPersistenceService) {
        this.projectPersistenceService = projectPersistenceService;
    }

    public Project createProject() {
        return new ProjectImpl(projectPersistenceService.createProjectEntity());
    }

    public Project persistProject(@NonNull Project project) {
        ProjectEntity persistedProjectEntity = projectPersistenceService.persistProject(((ProjectImpl) project).getProjectEntity());
        return new ProjectImpl(persistedProjectEntity);
    }

    public List<Project> findAllProjects() {
        return projectPersistenceService.findAllProjects()
                .stream()
                .map(ProjectImpl::new)
                .collect(Collectors.toList());
    }

    public Project findProjectById(long projectId) {
        try {
            return new ProjectImpl(projectPersistenceService.findProjectById(projectId));
        } catch (Exception exception) {
            throw new NoSuchElementException("project with id: " + projectId + " could not be found.");
        }
    }

    public Project updateProject(long projectId, @NonNull Project project) {
        final ProjectEntity updatedProjectEntity;
        try {
            updatedProjectEntity = projectPersistenceService.updateProject(projectId, ((ProjectImpl)project).getProjectEntity());
        } catch (Exception exception) {
            throw new RuntimeException("project with id: " + projectId + " could not be updated.");
        }
        return new ProjectImpl(updatedProjectEntity);
    }

    public void deleteProject(@NonNull Project project) {
        projectPersistenceService.deleteProject(((ProjectImpl)project).getProjectEntity());
    }

    public void deleteProjectById(long projectId) {
        projectPersistenceService.deleteProjectById(projectId);
    }


}
