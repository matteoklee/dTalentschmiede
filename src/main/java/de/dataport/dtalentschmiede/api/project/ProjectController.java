package de.dataport.dtalentschmiede.api.project;

import de.dataport.dtalentschmiede.api.project.dto.ProjectRequestDTO;
import de.dataport.dtalentschmiede.api.project.dto.ProjectResponseDTO;
import de.dataport.dtalentschmiede.api.technology.dto.TechnologyDTO;
import de.dataport.dtalentschmiede.api.technology.dto.TechnologyRequestDTO;
import de.dataport.dtalentschmiede.core.project.Project;
import de.dataport.dtalentschmiede.core.project.ProjectService;
import de.dataport.dtalentschmiede.core.technology.Technology;
import de.dataport.dtalentschmiede.core.technology.TechnologyImpl;
import de.dataport.dtalentschmiede.core.technology.TechnologyService;
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
    private final TechnologyService technologyService;

    public ProjectController(ProjectService projectService, TechnologyService technologyService) {
        this.projectService = projectService;
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        return ResponseEntity.ok(new ArrayList<>(projectService.findAllProjects().stream().map(ProjectResponseDTO::new).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable(value = "id") long projectId) {
        return ResponseEntity.ok(new ProjectResponseDTO(projectService.findProjectById(projectId)));
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
        Project newProject = mapToProject(projectRequestDTO);
        Project persistedProject = projectService.persistProject(newProject);
        return new ResponseEntity<>(new ProjectResponseDTO(persistedProject), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable(value = "id") long projectId, @RequestBody ProjectRequestDTO projectRequestDTO) {
        Project updatedProject = mapToProject(projectRequestDTO);
        updatedProject.setProjectId(projectId);
        Project persistedProject = projectService.updateProject(projectId, updatedProject);
        return ResponseEntity.ok(new ProjectResponseDTO(persistedProject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable(value = "id") long projectId) {
        projectService.deleteProjectById(projectId);
        return ResponseEntity.noContent().build();
    }

    //TODO:finishProject

    private Project mapToProject(ProjectRequestDTO dto) {
        Project project = projectService.createProject();
        project.setProjectTitle(dto.getProjectTitle());
        project.setProjectDescription(dto.getProjectDescription());
        project.setProjectStatus(dto.getProjectStatus());
        project.setProjectTypes(dto.getProjectTypes());
        /*List<TechnologyImpl> technologyImpls = dto.getProjectTechnologies()
                .stream()
                .map(TechnologyImpl::new)
                .collect(Collectors.toList());*/
        List<Technology> technologies = new ArrayList<>();
        for(TechnologyDTO technologyDTO : dto.getProjectTechnologies()) {
            Technology technology = technologyService.findTechnologyById(technologyDTO.getTechnologyId());
            if(technology == null) {
                break;
            }
            technologies.add(technology);
        }
        if(technologies != null) {
            project.setProjectTechnologies(technologies.stream().map(TechnologyImpl::new).collect(Collectors.toList()));

        }
        project.setProjectSoftSkills(dto.getProjectSoftSkills());
        project.setProjectHardSkills(dto.getProjectHardSkills());
        project.setProjectRepresentative(dto.getProjectRepresentative());
        project.setProjectRepresentativeEmail(dto.getProjectRepresentativeEmail());
        return project;
    }

}
