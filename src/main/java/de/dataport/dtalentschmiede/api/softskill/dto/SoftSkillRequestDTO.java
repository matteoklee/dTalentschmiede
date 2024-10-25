package de.dataport.dtalentschmiede.api.softskill.dto;

/**
 * Class "SoftSkillRequestDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class SoftSkillRequestDTO {

    private String softSkillName;
    private String softSkillValue;

    public SoftSkillRequestDTO() {

    }

    public SoftSkillRequestDTO(String softSkillName, String softSkillValue) {
        this.softSkillName = softSkillName;
        this.softSkillValue = softSkillValue;
    }

    public String getSoftSkillName() {
        return softSkillName;
    }

    public void setSoftSkillName(String softSkillName) {
        this.softSkillName = softSkillName;
    }

    public String getSoftSkillValue() {
        return softSkillValue;
    }

    public void setSoftSkillValue(String softSkillValue) {
        this.softSkillValue = softSkillValue;
    }
}
