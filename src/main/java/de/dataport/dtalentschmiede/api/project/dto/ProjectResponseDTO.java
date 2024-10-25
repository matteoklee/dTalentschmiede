package de.dataport.dtalentschmiede.api.project.dto;

import de.dataport.dtalentschmiede.core.hardskill.HardSkill;
import de.dataport.dtalentschmiede.core.project.Project;
import de.dataport.dtalentschmiede.core.project.enums.ProjectStatus;
import de.dataport.dtalentschmiede.core.project.enums.SoftSkill;
import de.dataport.dtalentschmiede.core.projecttype.ProjectType;
import de.dataport.dtalentschmiede.core.technology.Technology;

import java.util.Date;
import java.util.List;

/**
 * Class "ProjectResponseDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
public class ProjectResponseDTO {

    private Long projectId;
    private String projectTitle;
    private String projectDescription;
    private ProjectStatus projectStatus;
    private Date projectCreatedAt;
    private Date projectUpdatedAt;
    private Date projectFinishedAt;
    private List<ProjectType> projectTypes;
    private List<Technology> projectTechnologies;
    private List<SoftSkill> projectSoftSkills;
    private List<HardSkill> projectHardSkills;
    private String projectRepresentative;
    private String projectRepresentativeEmail;

    public ProjectResponseDTO() {

    }

    public ProjectResponseDTO(Long projectId, String projectTitle, String projectDescription, ProjectStatus projectStatus, Date projectCreatedAt, Date projectUpdatedAt, Date projectFinishedAt, List<ProjectType> projectTypes, List<Technology> projectTechnologies, List<SoftSkill> projectSoftSkills, List<HardSkill> projectHardSkills, String projectRepresentative, String projectRepresentativeEmail) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectStatus = projectStatus;
        this.projectCreatedAt = projectCreatedAt;
        this.projectUpdatedAt = projectUpdatedAt;
        this.projectFinishedAt = projectFinishedAt;
        this.projectTypes = projectTypes;
        this.projectTechnologies = projectTechnologies;
        this.projectSoftSkills = projectSoftSkills;
        this.projectHardSkills = projectHardSkills;
        this.projectRepresentative = projectRepresentative;
        this.projectRepresentativeEmail = projectRepresentativeEmail;
    }

    public ProjectResponseDTO(Project project) {
        this.setProjectId(project.getProjectId());
        this.setProjectTitle(project.getProjectTitle());
        this.setProjectDescription(project.getProjectDescription());
        this.setProjectStatus(project.getProjectStatus());
        this.setProjectCreatedAt(project.getProjectCreatedAt());
        this.setProjectUpdatedAt(project.getProjectUpdatedAt());
        this.setProjectFinishedAt(project.getProjectFinishedAt());
        this.setProjectTypes(project.getProjectTypes());
        this.setProjectTechnologies(project.getProjectTechnologies());
        this.setProjectSoftSkills(project.getProjectSoftSkills());
        this.setProjectHardSkills(project.getProjectHardSkills());
        this.setProjectRepresentative(project.getProjectRepresentative());
        this.setProjectRepresentativeEmail(project.getProjectRepresentativeEmail());
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public Date getProjectCreatedAt() {
        return projectCreatedAt;
    }

    public void setProjectCreatedAt(Date projectCreatedAt) {
        this.projectCreatedAt = projectCreatedAt;
    }

    public Date getProjectUpdatedAt() {
        return projectUpdatedAt;
    }

    public void setProjectUpdatedAt(Date projectUpdatedAt) {
        this.projectUpdatedAt = projectUpdatedAt;
    }

    public Date getProjectFinishedAt() {
        return projectFinishedAt;
    }

    public void setProjectFinishedAt(Date projectFinishedAt) {
        this.projectFinishedAt = projectFinishedAt;
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
