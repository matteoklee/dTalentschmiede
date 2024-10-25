package de.dataport.dtalentschmiede.core.hardskill;

import de.dataport.dtalentschmiede.core.projecttype.ProjectType;
import de.dataport.dtalentschmiede.persistence.hardskill.HardSkillEntity;
import de.dataport.dtalentschmiede.persistence.projecttype.ProjectTypeEntity;

/**
 * Class "HardSkillImpl" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class HardSkillImpl implements HardSkill {

    private final HardSkillEntity hardSkillEntity;

    public HardSkillImpl(HardSkillEntity hardSkillEntity) {
        this.hardSkillEntity = hardSkillEntity;
    }

    public HardSkillImpl(HardSkill hardSkill) {
        this.hardSkillEntity = new HardSkillEntity();
        this.hardSkillEntity.setHardSkillId(hardSkill.getHardSkillId());
        this.hardSkillEntity.setHardSkillName(hardSkill.getHardSkillName());
        this.hardSkillEntity.setHardSkillValue(hardSkill.getHardSkillValue());
    }

    public HardSkillEntity getHardSkillEntity() {
        return hardSkillEntity;
    }

    @Override
    public Long getHardSkillId() {
        return hardSkillEntity.getHardSkillId();
    }

    @Override
    public void setHardSkillId(Long hardSkillId) {
        hardSkillEntity.setHardSkillId(hardSkillId);
    }

    @Override
    public String getHardSkillName() {
        return hardSkillEntity.getHardSkillName();
    }

    @Override
    public void setHardSkillName(String hardSkillName) {
        hardSkillEntity.setHardSkillName(hardSkillName);
    }

    @Override
    public String getHardSkillValue() {
        return hardSkillEntity.getHardSkillValue();
    }

    @Override
    public void setHardSkillValue(String hardSkillValue) {
        hardSkillEntity.setHardSkillValue(hardSkillValue);
    }

}

