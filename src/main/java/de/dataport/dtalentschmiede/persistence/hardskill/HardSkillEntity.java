package de.dataport.dtalentschmiede.persistence.hardskill;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class "HardSkillEntity" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Entity
public class HardSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hardSkillId;
    private String hardSkillName;
    private String hardSkillValue;

    public HardSkillEntity() {
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

