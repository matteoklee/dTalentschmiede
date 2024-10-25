package de.dataport.dtalentschmiede.api.project.dto;

import de.dataport.dtalentschmiede.api.hardskill.dto.HardSkillDTO;
import de.dataport.dtalentschmiede.api.projecttype.dto.ProjectTypeDTO;
import de.dataport.dtalentschmiede.api.softskill.dto.SoftSkillDTO;
import de.dataport.dtalentschmiede.api.technology.dto.TechnologyDTO;
import de.dataport.dtalentschmiede.core.project.enums.ProjectStatus;

import java.util.List;

/**
 * Class "ProjectRequestDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
public class ProjectRequestDTO {

    private String projectTitle;
    private String projectDescription;
    private ProjectStatus projectStatus;
    private List<ProjectTypeDTO> projectTypes;
    private List<TechnologyDTO> projectTechnologies;
    private List<SoftSkillDTO> projectSoftSkills;
    private List<HardSkillDTO> projectHardSkills;
    private String projectRepresentative;
    private String projectRepresentativeEmail;

    public ProjectRequestDTO() {}

    public ProjectRequestDTO(String projectTitle, String projectDescription, ProjectStatus projectStatus, List<ProjectTypeDTO> projectTypes, List<TechnologyDTO> projectTechnologies, List<SoftSkillDTO> projectSoftSkills, List<HardSkillDTO> projectHardSkills, String projectRepresentative, String projectRepresentativeEmail) {
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectStatus = projectStatus;
        this.projectTypes = projectTypes;
        this.projectTechnologies = projectTechnologies;
        this.projectSoftSkills = projectSoftSkills;
        this.projectHardSkills = projectHardSkills;
        this.projectRepresentative = projectRepresentative;
        this.projectRepresentativeEmail = projectRepresentativeEmail;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public List<ProjectTypeDTO> getProjectTypes() {
        return projectTypes;
    }

    public void setProjectTypes(List<ProjectTypeDTO> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public List<TechnologyDTO> getProjectTechnologies() {
        return projectTechnologies;
    }

    public void setProjectTechnologies(List<TechnologyDTO> projectTechnologies) {
        this.projectTechnologies = projectTechnologies;
    }

    public List<SoftSkillDTO> getProjectSoftSkills() {
        return projectSoftSkills;
    }

    public void setProjectSoftSkills(List<SoftSkillDTO> projectSoftSkills) {
        this.projectSoftSkills = projectSoftSkills;
    }

    public List<HardSkillDTO> getProjectHardSkills() {
        return projectHardSkills;
    }

    public void setProjectHardSkills(List<HardSkillDTO> projectHardSkills) {
        this.projectHardSkills = projectHardSkills;
    }

    public String getProjectRepresentative() {
        return projectRepresentative;
    }

    public void setProjectRepresentative(String projectRepresentative) {
        this.projectRepresentative = projectRepresentative;
    }

    public String getProjectRepresentativeEmail() {
        return projectRepresentativeEmail;
    }

    public void setProjectRepresentativeEmail(String projectRepresentativeEmail) {
        this.projectRepresentativeEmail = projectRepresentativeEmail;
    }
}
