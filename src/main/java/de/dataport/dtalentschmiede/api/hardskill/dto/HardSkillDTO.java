package de.dataport.dtalentschmiede.api.hardskill.dto;

import de.dataport.dtalentschmiede.core.hardskill.HardSkill;
import de.dataport.dtalentschmiede.core.projecttype.ProjectType;

/**
 * Class "HardSkillDTO" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class HardSkillDTO {

    private Long hardSkillId;
    private String hardSkillName;
    private String hardSkillValue;

    public HardSkillDTO() {

    }

    public HardSkillDTO(HardSkill hardSkill) {
        this.setHardSkillId(hardSkill.getHardSkillId());
        this.setHardSkillName(hardSkill.getHardSkillName());
        this.setHardSkillValue(hardSkill.getHardSkillValue());
    }

    public Long getHardSkillId() {
        return hardSkillId;
    }

    public void setHardSkillId(Long hardSkillId) {
        this.hardSkillId = hardSkillId;
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
