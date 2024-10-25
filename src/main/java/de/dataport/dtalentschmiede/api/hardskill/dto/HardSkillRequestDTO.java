package de.dataport.dtalentschmiede.api.hardskill.dto;

/**
 * Class "HardSkillRequestDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class HardSkillRequestDTO {

    private String hardSkillName;
    private String hardSkillValue;

    public HardSkillRequestDTO() {

    }

    public HardSkillRequestDTO(String hardSkillName, String hardSkillValue) {
        this.hardSkillName = hardSkillName;
        this.hardSkillValue = hardSkillValue;
    }

    public String getHardSkillName() {
        return hardSkillName;
    }

    public void setHardSkillName(String hardSkillName) {
        this.hardSkillName = hardSkillName;
    }

    public String getHardSkillValue() {
        return hardSkillValue;
    }

    public void setHardSkillValue(String hardSkillValue) {
        this.hardSkillValue = hardSkillValue;
    }
}
