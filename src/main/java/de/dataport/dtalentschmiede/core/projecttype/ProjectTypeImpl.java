package de.dataport.dtalentschmiede.core.projecttype;

import de.dataport.dtalentschmiede.core.technology.Technology;
import de.dataport.dtalentschmiede.persistence.projecttype.ProjectTypeEntity;
import de.dataport.dtalentschmiede.persistence.technology.TechnologyEntity;

/**
 * Class "ProjectTypeImpl" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class ProjectTypeImpl implements ProjectType {

    private final ProjectTypeEntity projectTypeEntity;

    public ProjectTypeImpl(ProjectTypeEntity projectTypeEntity) {
        this.projectTypeEntity = projectTypeEntity;
    }

    public ProjectTypeImpl(ProjectType projectType) {
        this.projectTypeEntity = new ProjectTypeEntity();
        this.projectTypeEntity.setProjectTypeId(projectType.getProjectTypeId());
        this.projectTypeEntity.setProjectTypeName(projectType.getProjectTypeName());
        this.projectTypeEntity.setProjectTypeValue(projectType.getProjectTypeValue());
    }


    public ProjectTypeEntity getProjectTypeEntity() {
        return projectTypeEntity;
    }

    @Override
    public Long getProjectTypeId() {
        return projectTypeEntity.getProjectTypeId();
    }

    @Override
    public void setProjectTypeId(Long projectTypeId) {
        projectTypeEntity.setProjectTypeId(projectTypeId);
    }

    @Override
    public String getProjectTypeName() {
        return projectTypeEntity.getProjectTypeName();
    }

    @Override
    public void setProjectTypeName(String projectTypeName) {
        projectTypeEntity.setProjectTypeName(projectTypeName);
    }

    @Override
    public String getProjectTypeValue() {
        return projectTypeEntity.getProjectTypeValue();
    }

    @Override
    public void setProjectTypeValue(String projectTypeValue) {
        projectTypeEntity.setProjectTypeValue(projectTypeValue);
    }

}

