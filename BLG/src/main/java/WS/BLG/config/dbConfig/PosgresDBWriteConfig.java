package WS.BLG.config.dbConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.Properties;

@Configuration
@ConfigurationProperties("spring.datasource-write")//dung cho master con read dung cho replicas
@EnableJpaRepositories(basePackages = "WS.BLG.repository.posgres",
        entityManagerFactoryRef = "postgresEntityManager",
        transactionManagerRef = "postgreTransactionManager")
public class PosgresDBWriteConfig extends HikariConfig {
    @Autowired
    Environment environment;

    @Bean
    public HikariDataSource dataSource() {
//        co the cau hinh hikari config trong code
        Properties props = new Properties();

        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "test");
        props.setProperty("dataSource.password", "test");
        props.setProperty("dataSource.databaseName", "mydb");
        props.setProperty("datasource.url", "jdbc:postgresql://localhost:5432/somedb");
//        props.put("dataSource.logWriter", new PrintWriter(System.out));
        HikariConfig config = new HikariConfig(props);
//        config.setJdbcUrl("jdbc_url");
//        config.setUsername("database_username");
//        config.setPassword("database_password");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
//        return new HikariDataSource(this);
    }

    @Bean(name = "postgresEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(final HikariDataSource dataSourceWrite) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceWrite);

        // Scan Entities in Package:
        em.setPackagesToScan("WS.BLG.entities");
        em.setPersistenceUnitName("write");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        //
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();

        // JPA & Hibernate
        //properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.vnptpaybss"));
        properties.put("hibernate.ddl-auto", environment.getProperty("spring.jpa.hibernate.ddl-auto.BLG"));
        properties.put("hibernate.show-sql", environment.getProperty("spring.jpa.show-sql.BLG"));
        properties.put("hibernate.enable_lazy_load_no_trans", environment.getProperty("spring.jpa.enable_lazy_load_no_trans.BLG"));

        // Solved Error: PostGres createClob() is not yet implemented.
        // PostGres Only:
        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",  false);

        em.setJpaPropertyMap(properties);
        em.afterPropertiesSet();
        return em;
    }

    @Bean("postgreTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean(dataSource()).getObject());
        return transactionManager;
    }
}
