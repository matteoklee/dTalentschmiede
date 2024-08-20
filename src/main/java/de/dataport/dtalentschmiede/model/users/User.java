package de.dataport.dtalentschmiede.model.users;

import de.dataport.dtalentschmiede.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

/**
 * Class "User" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userFirstName;
    private String userNickName;

    private UserRole userRole;
    private Date createdAt;
    private Date lastLogin;

    //Password + Email???

}
