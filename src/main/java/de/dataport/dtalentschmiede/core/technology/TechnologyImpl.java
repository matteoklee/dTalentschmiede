package de.dataport.dtalentschmiede.core.technology;

import de.dataport.dtalentschmiede.persistence.technology.TechnologyEntity;

/**
 * Class "TechnologyImpl" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public class TechnologyImpl implements Technology {

    private final TechnologyEntity technologyEntity;

    public TechnologyImpl(TechnologyEntity technologyEntity) {
        this.technologyEntity = technologyEntity;
    }

    public TechnologyImpl(Technology technology) {
        this.technologyEntity = new TechnologyEntity();
        this.technologyEntity.setTechnologyId(technology.getTechnologyId());
        this.technologyEntity.setTechnologyName(technology.getTechnologyName());
        this.technologyEntity.setTechnologyValue(technology.getTechnologyValue());
    }

    public TechnologyEntity getTechnologyEntity() {
        return technologyEntity;
    }

    @Override
    public Long getTechnologyId() {
        return technologyEntity.getTechnologyId();
    }

    @Override
    public void setTechnologyId(Long technologyId) {
        technologyEntity.setTechnologyId(technologyId);
    }

    @Override
    public String getTechnologyName() {
        return technologyEntity.getTechnologyName();
    }

    @Override
    public void setTechnologyName(String technologyName) {
        technologyEntity.setTechnologyName(technologyName);
    }

    @Override
    public String getTechnologyValue() {
        return technologyEntity.getTechnologyValue();
    }

    @Override
    public void setTechnologyValue(String technologyValue) {
        technologyEntity.setTechnologyValue(technologyValue);
    }

}

