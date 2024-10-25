package de.dataport.dtalentschmiede.persistence.technology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class "TechnologyRepository" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Repository
public interface TechnologyRepository extends JpaRepository<TechnologyEntity, Long> {
}

