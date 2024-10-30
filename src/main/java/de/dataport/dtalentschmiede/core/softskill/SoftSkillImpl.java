package de.dataport.dtalentschmiede.core.softskill;

import de.dataport.dtalentschmiede.core.technology.Technology;
import de.dataport.dtalentschmiede.persistence.softskill.SoftSkillEntity;
import de.dataport.dtalentschmiede.persistence.technology.TechnologyEntity;

/**
 * Class "SoftSkillImpl" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class SoftSkillImpl implements SoftSkill {

    private final SoftSkillEntity softSkillEntity;

    public SoftSkillImpl(SoftSkillEntity softSkillEntity) {
        this.softSkillEntity = softSkillEntity;
    }

    public SoftSkillImpl(SoftSkill softSkill) {
        this.softSkillEntity = new SoftSkillEntity();
        this.softSkillEntity.setSoftSkillId(softSkill.getSoftSkillId());
        this.softSkillEntity.setSoftSkillName(softSkill.getSoftSkillName());
        this.softSkillEntity.setSoftSkillValue(softSkill.getSoftSkillValue());
    }

    public SoftSkillEntity getSoftSkillEntity() {
        return softSkillEntity;
    }

    @Override
    public Long getSoftSkillId() {
        return softSkillEntity.getSoftSkillId();
    }

    @Override
    public void setSoftSkillId(Long softSkillId) {
        softSkillEntity.setSoftSkillId(softSkillId);
    }

    @Override
    public String getSoftSkillName() {
        return softSkillEntity.getSoftSkillName();
    }

    @Override
    public void setSoftSkillName(String softSkillName) {
        softSkillEntity.setSoftSkillName(softSkillName);
    }

    @Override
    public String getSoftSkillValue() {
        return softSkillEntity.getSoftSkillValue();
    }

    @Override
    public void setSoftSkillValue(String softSkillValue) {
        softSkillEntity.setSoftSkillValue(softSkillValue);
    }

}

