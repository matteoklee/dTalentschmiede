package de.dataport.dtalentschmiede.api.projecttype.dto;

import de.dataport.dtalentschmiede.core.projecttype.ProjectType;

/**
 * Class "ProjectTypeDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class ProjectTypeDTO {

    private Long projectTypeId;
    private String projectTypeName;
    private String projectTypeValue;

    public ProjectTypeDTO() {

    }

    public ProjectTypeDTO(ProjectType projectType) {
        this.setProjectTypeId(projectType.getProjectTypeId());
        this.setProjectTypeName(projectType.getProjectTypeName());
        this.setProjectTypeValue(projectType.getProjectTypeValue());
    }

    public Long getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Long projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getProjectTypeValue() {
        return projectTypeValue;
    }

    public void setProjectTypeValue(String projectTypeValue) {
        this.projectTypeValue = projectTypeValue;
    }
}
