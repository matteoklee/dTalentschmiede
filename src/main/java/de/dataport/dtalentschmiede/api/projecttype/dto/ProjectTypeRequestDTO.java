package de.dataport.dtalentschmiede.api.projecttype.dto;

/**
 * Class "ProjectTypeRequestDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class ProjectTypeRequestDTO {

    private String projectTypeName;
    private String projectTypeValue;

    public ProjectTypeRequestDTO() {

    }

    public ProjectTypeRequestDTO(String projectTypeName, String projectTypeValue) {
        this.projectTypeName = projectTypeName;
        this.projectTypeValue = projectTypeValue;
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
