package de.dataport.dtalentschmiede.persistence.projecttype;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class "ProjectTypeEntity" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Entity
public class ProjectTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectTypeId;
    private String projectTypeName;
    private String projectTypeValue;

    public ProjectTypeEntity() {
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
