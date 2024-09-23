package de.dataport.dtalentschmiede.model.users;

import de.dataport.dtalentschmiede.model.Project;
import de.dataport.dtalentschmiede.model.users.DataportUser;
import jakarta.persistence.Entity;

import java.util.List;

/**
 * Class "Employee" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class Employee extends DataportUser {

    private String position;

    //Representative E-Mail or String or UserId
    private String representative;
    private List<Project> createdProjects;


}
