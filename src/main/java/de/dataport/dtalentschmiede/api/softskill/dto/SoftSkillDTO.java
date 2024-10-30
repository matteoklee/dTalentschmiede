package de.dataport.dtalentschmiede.api.softskill.dto;

import de.dataport.dtalentschmiede.core.softskill.SoftSkill;
import de.dataport.dtalentschmiede.core.technology.Technology;

/**
 * Class "SoftSkillDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class SoftSkillDTO {

    private Long softSkillId;
    private String softSkillName;
    private String softSkillValue;

    public SoftSkillDTO() {

    }

    public SoftSkillDTO(SoftSkill softSkill) {
        this.setSoftSkillId(softSkill.getSoftSkillId());
        this.setSoftSkillName(softSkill.getSoftSkillName());
        this.setSoftSkillValue(softSkill.getSoftSkillValue());
    }

    public Long getSoftSkillId() {
        return softSkillId;
    }

    public void setSoftSkillId(Long softSkillId) {
        this.softSkillId = softSkillId;
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
