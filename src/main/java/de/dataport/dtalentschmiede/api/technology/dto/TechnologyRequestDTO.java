package de.dataport.dtalentschmiede.api.technology.dto;

/**
 * Class "TechnologyRequestDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class TechnologyRequestDTO {

    private String technologyName;
    private String technologyValue;

    public TechnologyRequestDTO() {

    }
    public TechnologyRequestDTO(String technologyName, String technologyValue) {
        this.technologyName = technologyName;
        this.technologyValue = technologyValue;
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
