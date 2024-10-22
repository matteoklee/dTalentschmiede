package de.dataport.dtalentschmiede.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class "PersistenceConfiguration" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 20.08.2024
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("de.dataport.dtalentschmiede")
@EntityScan("de.dataprt.dtalentschmiede")
public class PersistenceConfiguration {
}
