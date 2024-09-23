package de.dataport.dtalentschmiede.model;

import de.dataport.dtalentschmiede.enums.ApplicationStatus;
import de.dataport.dtalentschmiede.model.users.Talent;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Class "Application" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    @ManyToOne
    private Project applicationProject;
    @ManyToOne
    private Talent applicationTalent;
    private ApplicationStatus applicationStatus;
    private Date applicationDate;
    private String applicationMotivation;
    private String applicationAdditionalInformation;

}
