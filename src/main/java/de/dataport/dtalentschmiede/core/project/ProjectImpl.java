package de.dataport.dtalentschmiede.core.project;

import de.dataport.dtalentschmiede.core.project.enums.HardSkill;
import de.dataport.dtalentschmiede.core.project.enums.ProjectStatus;
import de.dataport.dtalentschmiede.core.project.enums.SoftSkill;
import de.dataport.dtalentschmiede.core.projecttype.ProjectType;
import de.dataport.dtalentschmiede.core.projecttype.ProjectTypeImpl;
import de.dataport.dtalentschmiede.core.technology.Technology;
import de.dataport.dtalentschmiede.core.technology.TechnologyImpl;
import de.dataport.dtalentschmiede.persistence.project.ProjectEntity;
import de.dataport.dtalentschmiede.persistence.projecttype.ProjectTypeEntity;
import de.dataport.dtalentschmiede.persistence.technology.TechnologyEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class "ProjectImpl" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
public class ProjectImpl implements Project {

    private final ProjectEntity projectEntity;

    public ProjectImpl(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    @Override
    public Long getProjectId() {
        return projectEntity.getProjectId();
    }

    @Override
    public void setProjectId(Long projectId) {
        projectEntity.setProjectId(projectId);
    }

    @Override
    public String getProjectTitle() {
        return projectEntity.getProjectTitle();
    }

    @Override
    public void setProjectTitle(String projectTitle) {
        projectEntity.setProjectTitle(projectTitle);
    }

    @Override
    public String getProjectDescription() {
        return projectEntity.getProjectDescription();
    }

    @Override
    public void setProjectDescription(String projectDescription) {
        projectEntity.setProjectDescription(projectDescription);
    }

    @Override
    public ProjectStatus getProjectStatus() {
        return projectEntity.getProjectStatus();
    }

    @Override
    public void setProjectStatus(ProjectStatus projectStatus) {
        projectEntity.setProjectStatus(projectStatus);
    }

    @Override
    public Date getProjectCreatedAt() {
        return projectEntity.getProjectCreatedAt();
    }

    @Override
    public void setProjectCreatedAt(Date projectCreatedAt) {
        projectEntity.setProjectCreatedAt(projectCreatedAt);
    }

    @Override
    public Date getProjectUpdatedAt() {
        return projectEntity.getProjectUpdatedAt();
    }

    @Override
    public void setProjectUpdatedAt(Date projectUpdatedAt) {
        projectEntity.setProjectUpdatedAt(projectUpdatedAt);
    }

    @Override
    public Date getProjectFinishedAt() {
        return projectEntity.getProjectFinishedAt();
    }

    @Override
    public void setProjectFinishedAt(Date projectFinishedAt) {
        projectEntity.setProjectFinishedAt(projectFinishedAt);
    }

    @Override
    public List<ProjectType> getProjectTypes() {
        return projectEntity.getProjectTypes()
                .stream()
                .map(ProjectTypeImpl::new)
                .collect(Collectors.toList());
    }

    @Override
    public void setProjectTypes(List<ProjectTypeImpl> projectTypes) {
        List<ProjectTypeEntity> projectTypeEntities = projectTypes
                .stream()
                .map(ProjectTypeImpl::getProjectTypeEntity)
                .collect(Collectors.toList());
        projectEntity.setProjectTypes(projectTypeEntities);
    }

    @Override
    public List<Technology> getProjectTechnologies() {
        return projectEntity.getProjectTechnologies()
                .stream()
                .map(TechnologyImpl::new)
                .collect(Collectors.toList());
    }

    @Override
    public void setProjectTechnologies(List<TechnologyImpl> projectTechnologies) {
        List<TechnologyEntity> technologyEntities = projectTechnologies
                .stream()
                .map(TechnologyImpl::getTechnologyEntity)
                .collect(Collectors.toList());
        projectEntity.setProjectTechnologies(technologyEntities);
    }

    @Override
    public List<SoftSkill> getProjectSoftSkills() {
        return projectEntity.getProjectSoftSkills();
    }

    @Override
    public void setProjectSoftSkills(List<SoftSkill> projectSoftSkills) {
        projectEntity.setProjectSoftSkills(projectSoftSkills);
    }

    @Override
    public List<HardSkill> getProjectHardSkills() {
        return projectEntity.getProjectHardSkills();
    }

    @Override
    public void setProjectHardSkills(List<HardSkill> projectHardSkills) {
        projectEntity.setProjectHardSkills(projectHardSkills);
    }

    @Override
    public String getProjectRepresentative() {
        return projectEntity.getProjectRepresentative();
    }

    @Override
    public void setProjectRepresentative(String projectRepresentative) {
        projectEntity.setProjectRepresentative(projectRepresentative);
    }

    @Override
    public String getProjectRepresentativeEmail() {
        return projectEntity.getProjectRepresentativeEmail();
    }

    @Override
    public void setProjectRepresentativeEmail(String projectRepresentativeEmail) {
        projectEntity.setProjectRepresentativeEmail(projectRepresentativeEmail);
    }
}
