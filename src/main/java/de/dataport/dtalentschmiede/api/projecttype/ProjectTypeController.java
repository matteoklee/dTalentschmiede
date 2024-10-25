package de.dataport.dtalentschmiede.api.projecttype;

import de.dataport.dtalentschmiede.api.projecttype.dto.ProjectTypeDTO;
import de.dataport.dtalentschmiede.api.projecttype.dto.ProjectTypeRequestDTO;
import de.dataport.dtalentschmiede.core.projecttype.ProjectType;
import de.dataport.dtalentschmiede.core.projecttype.ProjectTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class "ProjectTypeController" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@RestController
@RequestMapping("/api/v1/project-type")
public class ProjectTypeController {

    private final ProjectTypeService projectTypeService;

    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectTypeDTO>> getAllProjectTypes() {
        return ResponseEntity.ok(
                projectTypeService.findAllProjectTypes()
                        .stream()
                        .map(ProjectTypeDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectTypeDTO> getProjectTypeById(@PathVariable(value = "id") long projectTypeId) {
        return ResponseEntity.ok(new ProjectTypeDTO(projectTypeService.findProjectTypeById(projectTypeId)));
    }

    @PostMapping
    public ResponseEntity<ProjectTypeDTO> createProjectType(@RequestBody ProjectTypeRequestDTO projectTypeRequestDTO) {
        ProjectType newProjectType = mapToProjectType(projectTypeRequestDTO);
        ProjectType persistedProjectType = projectTypeService.persistProjectType(newProjectType);
        return new ResponseEntity<>(new ProjectTypeDTO(persistedProjectType), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectTypeDTO> updateProjectType(@PathVariable(value = "id") long projectTypeId, @RequestBody ProjectTypeRequestDTO projectTypeRequestDTO) {
        ProjectType updatedProjectType = mapToProjectType(projectTypeRequestDTO);
        updatedProjectType.setProjectTypeId(projectTypeId);
        ProjectType persistedProjectType = projectTypeService.updateProjectType(projectTypeId, updatedProjectType);
        return ResponseEntity.ok(new ProjectTypeDTO(persistedProjectType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectType(@PathVariable(value = "id") long projectTypeId) {
        projectTypeService.deleteProjectTypeById(projectTypeId);
        return ResponseEntity.noContent().build();
    }

    private ProjectType mapToProjectType(ProjectTypeRequestDTO dto) {
        ProjectType projectType = projectTypeService.createProjectType();
        projectType.setProjectTypeName(dto.getProjectTypeName());
        projectType.setProjectTypeValue(dto.getProjectTypeValue());
        return projectType;
    }
}

