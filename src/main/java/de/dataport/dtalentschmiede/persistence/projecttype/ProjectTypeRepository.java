package de.dataport.dtalentschmiede.persistence.projecttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class "ProjectTypeRepository" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectTypeEntity, Long> {
}

