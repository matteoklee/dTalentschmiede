package de.dataport.dtalentschmiede.persistence.softskill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class "SoftSkillRepository" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Repository
public interface SoftSkillRepository extends JpaRepository<SoftSkillEntity, Long> {
}

