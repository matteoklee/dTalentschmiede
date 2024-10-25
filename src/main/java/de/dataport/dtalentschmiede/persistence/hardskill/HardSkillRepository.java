package de.dataport.dtalentschmiede.persistence.hardskill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class "HardSkillRepository" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Repository
public interface HardSkillRepository extends JpaRepository<HardSkillEntity, Long> {
}

