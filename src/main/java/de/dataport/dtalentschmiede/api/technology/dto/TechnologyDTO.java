package de.dataport.dtalentschmiede.api.technology.dto;

import de.dataport.dtalentschmiede.core.technology.Technology;

/**
 * Class "TechnologyResponseDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class TechnologyDTO {

    private Long technologyId;
    private String technologyName;
    private String technologyValue;

    public TechnologyDTO() {

    }

    public TechnologyDTO(Long technologyId, String technologyName, String technologyValue) {
        this.technologyId = technologyId;
        this.technologyName = technologyName;
        this.technologyValue = technologyValue;
    }

    public TechnologyDTO(Technology technology) {
        this.setTechnologyId(technology.getTechnologyId());
        this.setTechnologyName(technology.getTechnologyName());
        this.setTechnologyValue(technology.getTechnologyValue());
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTechnologyValue() {
        return technologyValue;
    }

    public void setTechnologyValue(String technologyValue) {
        this.technologyValue = technologyValue;
    }
}
