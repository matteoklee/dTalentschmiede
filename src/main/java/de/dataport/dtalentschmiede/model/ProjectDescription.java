package de.dataport.dtalentschmiede.model;


import jakarta.persistence.*;

/**
 * Class "ProjectDescription" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class ProjectDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectDescriptionId;

    //private Long projectId;
    @OneToOne
    private Project project;

    private String projectRequirements;
    private String projectEnvironment; //workEnvironment
    private String projectTasks;
    private String projectTechnicalStack;

}
