package de.dataport.dtalentschmiede.core.technology;

/**
 * Class "Technology" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
public interface Technology {

    public Long getTechnologyId();

    public void setTechnologyId(Long technologyId);

    public String getTechnologyName();

    public void setTechnologyName(String technologyName);

    public String getTechnologyValue();

    public void setTechnologyValue(String technologyValue);

}
