package de.dataport.dtalentschmiede.model.users;

import de.dataport.dtalentschmiede.enums.TalentStatus;
import de.dataport.dtalentschmiede.model.Project;
import de.dataport.dtalentschmiede.model.Skill;
import jakarta.persistence.Entity;

import java.util.List;

/**
 * Class "Talent" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class Talent extends DataportUser {

    private String mainDepartment;
    private TalentStatus talentStatus;
    private List<Skill> talentSkills;
    private List<Project> currentProjects;
    private List<Project> completedProjects;
    private String studyYear;
    private String studyProgramm;
    private Double rating;

}
