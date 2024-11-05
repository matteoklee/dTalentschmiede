package de.dataport.dtalentschmiede.persistence.project;

import de.dataport.dtalentschmiede.core.project.ProjectStatus;
import jakarta.persistence.EntityExistsException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.*;

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
        //return new ArrayList<>(projectRepository.findAll());
        List<ProjectEntity> projects = new ArrayList<>(projectRepository.findAll());
        int days = 1;
        Date archiveThreshold = calculateThresholdDate(days);
        projects.forEach(projectEntity -> {
            if((projectEntity.getProjectStatus() == ProjectStatus.COMPLETED || projectEntity.getProjectStatus() == ProjectStatus.CANCELLED)) {
                if(projectEntity.getProjectFinishedAt() != null && projectEntity.getProjectFinishedAt().before(archiveThreshold)) {
                    projectEntity.setProjectStatus(ProjectStatus.ARCHIVED);
                    projectRepository.save(projectEntity);
                }
            }
        });
        return projects;
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
        if(projectEntity.getProjectStatus() == ProjectStatus.COMPLETED || projectEntity.getProjectStatus() == ProjectStatus.CANCELLED) {
            updatedProjectEntity.setProjectFinishedAt(new Date());
        }

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

    public void deleteProjectById(long projectId) {
        projectRepository.deleteById(projectId);
    }

    private Date calculateThresholdDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTime();
    }

}
