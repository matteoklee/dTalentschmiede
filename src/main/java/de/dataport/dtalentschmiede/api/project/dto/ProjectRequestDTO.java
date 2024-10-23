package de.dataport.dtalentschmiede.api.project.dto;

import de.dataport.dtalentschmiede.core.project.enums.*;

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
    private ProjectStatus projectStatus; // Optional, falls benötigt
    private List<ProjectType> projectTypes;
    private List<Technology> projectTechnologies;
    private List<SoftSkill> projectSoftSkills;
    private List<HardSkill> projectHardSkills;
    private String projectRepresentative;
    private String projectRepresentativeEmail;

    public ProjectRequestDTO() {}

    public ProjectRequestDTO(String projectTitle, String projectDescription, ProjectStatus projectStatus, List<ProjectType> projectTypes, List<Technology> projectTechnologies, List<SoftSkill> projectSoftSkills, List<HardSkill> projectHardSkills, String projectRepresentative, String projectRepresentativeEmail) {
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

    public List<ProjectType> getProjectTypes() {
        return projectTypes;
    }

    public void setProjectTypes(List<ProjectType> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public List<Technology> getProjectTechnologies() {
        return projectTechnologies;
    }

    public void setProjectTechnologies(List<Technology> projectTechnologies) {
        this.projectTechnologies = projectTechnologies;
    }

    public List<SoftSkill> getProjectSoftSkills() {
        return projectSoftSkills;
    }

    public void setProjectSoftSkills(List<SoftSkill> projectSoftSkills) {
        this.projectSoftSkills = projectSoftSkills;
    }

    public List<HardSkill> getProjectHardSkills() {
        return projectHardSkills;
    }

    public void setProjectHardSkills(List<HardSkill> projectHardSkills) {
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
