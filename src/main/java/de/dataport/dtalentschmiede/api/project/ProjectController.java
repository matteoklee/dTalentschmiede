package de.dataport.dtalentschmiede.api.project;

import de.dataport.dtalentschmiede.api.project.dto.ProjectRequestDTO;
import de.dataport.dtalentschmiede.api.project.dto.ProjectResponseDTO;
import de.dataport.dtalentschmiede.core.project.Project;
import de.dataport.dtalentschmiede.core.project.ProjectImpl;
import de.dataport.dtalentschmiede.core.project.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class "ProjectController" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(new ArrayList<>(projectService.findAllProjects()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") long projectId) {
        return ResponseEntity.ok(projectService.findProjectById(projectId));
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        Project newProject = mapRequestToProject(projectRequestDTO);
        Project persistedProject = projectService.persistProject(newProject);
        return new ResponseEntity<>(persistedProject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") long projectId, @RequestBody ProjectRequestDTO projectRequestDTO) {
        Project updatedProject = mapRequestToProject(projectRequestDTO);
        updatedProject.setProjectId(projectId);
        Project persistedProject = projectService.updateProject(projectId, updatedProject);
        return ResponseEntity.ok(persistedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable(value = "id") long projectId) {
        projectService.deleteProjectById(projectId);
        return ResponseEntity.noContent().build();
    }

    //TODO:finishProject

    private Project mapRequestToProject(ProjectRequestDTO dto) {
        Project project = projectService.createProject();
        project.setProjectTitle(dto.getProjectTitle());
        project.setProjectDescription(dto.getProjectDescription());
        project.setProjectStatus(dto.getProjectStatus());
        project.setProjectTypes(dto.getProjectTypes());
        project.setProjectTechnologies(dto.getProjectTechnologies());
        project.setProjectSoftSkills(dto.getProjectSoftSkills());
        project.setProjectHardSkills(dto.getProjectHardSkills());
        project.setProjectRepresentative(dto.getProjectRepresentative());
        project.setProjectRepresentativeEmail(dto.getProjectRepresentativeEmail());
        return project;
    }

}
