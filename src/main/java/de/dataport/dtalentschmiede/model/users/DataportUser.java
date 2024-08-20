package de.dataport.dtalentschmiede.model.users;

import jakarta.persistence.Entity;

/**
 * Class "DataportUser" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class DataportUser extends User {

    private String department;
    private String location;
    private String email;
    private String alias;

}
