package de.dataport.dtalentschmiede.api.project;

import de.dataport.dtalentschmiede.api.hardskill.dto.HardSkillDTO;
import de.dataport.dtalentschmiede.api.project.dto.ProjectRequestDTO;
import de.dataport.dtalentschmiede.api.project.dto.ProjectResponseDTO;
import de.dataport.dtalentschmiede.api.projecttype.dto.ProjectTypeDTO;
import de.dataport.dtalentschmiede.api.softskill.dto.SoftSkillDTO;
import de.dataport.dtalentschmiede.api.technology.dto.TechnologyDTO;
import de.dataport.dtalentschmiede.core.hardskill.HardSkill;
import de.dataport.dtalentschmiede.core.hardskill.HardSkillImpl;
import de.dataport.dtalentschmiede.core.hardskill.HardSkillService;
import de.dataport.dtalentschmiede.core.project.Project;
import de.dataport.dtalentschmiede.core.project.ProjectService;
import de.dataport.dtalentschmiede.core.projecttype.ProjectType;
import de.dataport.dtalentschmiede.core.projecttype.ProjectTypeImpl;
import de.dataport.dtalentschmiede.core.projecttype.ProjectTypeService;
import de.dataport.dtalentschmiede.core.softskill.SoftSkill;
import de.dataport.dtalentschmiede.core.softskill.SoftSkillImpl;
import de.dataport.dtalentschmiede.core.softskill.SoftSkillService;
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
    private final ProjectTypeService projectTypeService;
    private final HardSkillService hardSkillService;
    private final SoftSkillService softSkillService;

    public ProjectController(ProjectService projectService, TechnologyService technologyService, ProjectTypeService projectTypeService, HardSkillService hardSkillService, SoftSkillService softSkillService) {
        this.projectService = projectService;
        this.technologyService = technologyService;
        this.projectTypeService = projectTypeService;
        this.hardSkillService = hardSkillService;
        this.softSkillService = softSkillService;
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

        //project.setProjectTypes(dto.getProjectTypes());
        List<ProjectType> projectTypes = new ArrayList<>();
        for(ProjectTypeDTO projectTypeDTO : dto.getProjectTypes()) {
            ProjectType projectType = projectTypeService.findProjectTypeById(projectTypeDTO.getProjectTypeId());
            if(projectType == null) {
                break;
            }
            projectTypes.add(projectType);
        }
        if(projectTypes != null) {
            project.setProjectTypes(projectTypes.stream().map(ProjectTypeImpl::new).collect(Collectors.toList()));
        }

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

        //project.setProjectSoftSkills(dto.getProjectSoftSkills());
        List<SoftSkill> softSkills = new ArrayList<>();
        for(SoftSkillDTO softSkillDTO : dto.getProjectSoftSkills()) {
            SoftSkill softSkill = softSkillService.findSoftSkillById(softSkillDTO.getSoftSkillId());
            if(softSkill == null) {
                break;
            }
            softSkills.add(softSkill);
        }
        if(softSkills != null) {
            project.setProjectSoftSkills(softSkills.stream().map(SoftSkillImpl::new).collect(Collectors.toList()));
        }

        //project.setProjectHardSkills(dto.getProjectHardSkills());
        List<HardSkill> hardSkills = new ArrayList<>();
        for(HardSkillDTO hardSkillDTO : dto.getProjectHardSkills()) {
            HardSkill hardSkill = hardSkillService.findHardSkillById(hardSkillDTO.getHardSkillId());
            if(hardSkill == null) {
                break;
            }
            hardSkills.add(hardSkill);
        }
        if(hardSkills != null) {
            project.setProjectHardSkills(hardSkills.stream().map(HardSkillImpl::new).collect(Collectors.toList()));
        }

        project.setProjectRepresentative(dto.getProjectRepresentative());
        project.setProjectRepresentativeEmail(dto.getProjectRepresentativeEmail());
        return project;
    }

}
