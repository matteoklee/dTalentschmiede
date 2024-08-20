package de.dataport.dtalentschmiede.model;

import de.dataport.dtalentschmiede.enums.ProjectStatus;
import de.dataport.dtalentschmiede.enums.ProjectType;
import de.dataport.dtalentschmiede.model.users.Employee;
import de.dataport.dtalentschmiede.model.users.Talent;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Class "Project" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectTitle;
    @OneToOne
    private ProjectDescription projectDescription;
    private ProjectStatus projectStatus;
    @ManyToOne
    private Employee projectCreatedBy;

    @ManyToMany
    private List<Talent> assignedTalents;
    private Date projectCreatedAt;
    private Date projectFinishedAt;
    private Integer requiredTalents;
    private ProjectType projectType;
    @ManyToMany
    private List<Category> projectCategories;
    @ManyToMany
    private List<Skill> projectSkills;
    @ManyToOne
    private Employee projectRepresentative;//String or E-Mail
    private boolean projectPublished;
    @ManyToMany
    private List<Milestone> milestones;

    @PrePersist
    public void setProjectCreatedAt() {
        this.projectCreatedAt = new Date();
    }
}
