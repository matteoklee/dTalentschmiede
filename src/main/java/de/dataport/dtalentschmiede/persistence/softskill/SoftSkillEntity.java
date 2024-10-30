package de.dataport.dtalentschmiede.persistence.softskill;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class "SoftSkillEntity" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Entity
public class SoftSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long softSkillId;
    private String softSkillName;
    private String softSkillValue;

    public SoftSkillEntity() {
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

