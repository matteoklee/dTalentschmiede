package de.dataport.dtalentschmiede.api.project;

import de.dataport.dtalentschmiede.api.project.dto.ProjectRequestDTO;
import de.dataport.dtalentschmiede.api.project.dto.ProjectResponseDTO;
import de.dataport.dtalentschmiede.core.project.Project;
import de.dataport.dtalentschmiede.core.project.ProjectImpl;
import de.dataport.dtalentschmiede.core.project.ProjectService;
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
        try {
            return ResponseEntity.ok(projectService.findProjectById(projectId));
        } catch (Exception exception) {
            return (ResponseEntity<Project>) ResponseEntity.noContent();
        }

    }

}
