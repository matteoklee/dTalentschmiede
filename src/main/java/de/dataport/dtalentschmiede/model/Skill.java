package de.dataport.dtalentschmiede.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class "Skill" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

}
