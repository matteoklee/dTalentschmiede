package de.dataport.dtalentschmiede.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class "Milestone" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneId;

}
