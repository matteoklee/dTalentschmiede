package de.dataport.dtalentschmiede.persistence.project;

import de.dataport.dtalentschmiede.core.project.ProjectStatus;
import de.dataport.dtalentschmiede.persistence.hardskill.HardSkillEntity;
import de.dataport.dtalentschmiede.persistence.projecttype.ProjectTypeEntity;
import de.dataport.dtalentschmiede.persistence.softskill.SoftSkillEntity;
import de.dataport.dtalentschmiede.persistence.technology.TechnologyEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Class "Project" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectTitle;
    private String projectDescription;
    private ProjectStatus projectStatus;
    private Date projectCreatedAt;
    private Date projectUpdatedAt;
    private Date projectFinishedAt;
    @ManyToMany
    private List<ProjectTypeEntity> projectTypes;
    @ManyToMany
    private List<TechnologyEntity> projectTechnologies;
    @ManyToMany
    private List<SoftSkillEntity> projectSoftSkills;
    @ManyToMany
    private List<HardSkillEntity> projectHardSkills;
    private String projectRepresentative;
    private String projectRepresentativeEmail;
    //private Integer requiredTalents;
    //private Date projectDeadline


    public ProjectEntity() {
    }

    public ProjectEntity(Long projectId, String projectTitle, String projectDescription, ProjectStatus projectStatus, Date projectCreatedAt, Date projectUpdatedAt, Date projectFinishedAt, List<ProjectTypeEntity> projectTypes, List<TechnologyEntity> projectTechnologies, List<SoftSkillEntity> projectSoftSkills, List<HardSkillEntity> projectHardSkills, String projectRepresentative, String projectRepresentativeEmail) {
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

    @PrePersist
    public void setProjectCreatedAt() {
        this.projectCreatedAt = new Date();
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

    public List<ProjectTypeEntity> getProjectTypes() {
        return projectTypes;
    }

    public void setProjectTypes(List<ProjectTypeEntity> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public List<TechnologyEntity> getProjectTechnologies() {
        return projectTechnologies;
    }

    public void setProjectTechnologies(List<TechnologyEntity> projectTechnologies) {
        this.projectTechnologies = projectTechnologies;
    }

    public List<SoftSkillEntity> getProjectSoftSkills() {
        return projectSoftSkills;
    }

    public void setProjectSoftSkills(List<SoftSkillEntity> projectSoftSkills) {
        this.projectSoftSkills = projectSoftSkills;
    }

    public List<HardSkillEntity> getProjectHardSkills() {
        return projectHardSkills;
    }

    public void setProjectHardSkills(List<HardSkillEntity> projectHardSkills) {
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
