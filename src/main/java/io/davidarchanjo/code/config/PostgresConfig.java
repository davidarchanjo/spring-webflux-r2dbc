package io.davidarchanjo.code.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.davidarchanjo.code.converters.BookReadConverter;
import io.davidarchanjo.code.converters.PersonReadConverter;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class PostgresConfig extends AbstractR2dbcConfiguration {

	@Bean
	@Override
	public ConnectionFactory connectionFactory() {
		return new PostgresqlConnectionFactory(
			PostgresqlConnectionConfiguration.builder()
				.host("localhost")
				.port(5432)
				.username("postgres")
				.password("admin")
				.database("postgres")
				.build());
	}

    @Bean
    public ConnectionFactoryInitializer databaseInitializer(ConnectionFactory connectionFactory) {
        final ConnectionFactoryInitializer cfi = new ConnectionFactoryInitializer();
        cfi.setConnectionFactory(connectionFactory);

        final CompositeDatabasePopulator cdp = new CompositeDatabasePopulator();
        cdp.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema/schema.sql")));
        cfi.setDatabasePopulator(cdp);
        return cfi;
    }

	@Override
	protected List<Object> getCustomConverters() {
		return List.of(
			new PersonReadConverter(),
			new BookReadConverter()
		);
	}
}