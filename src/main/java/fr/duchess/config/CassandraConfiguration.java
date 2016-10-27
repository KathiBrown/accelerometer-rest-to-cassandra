package fr.duchess.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

@Configuration
//@PropertySource(value = { "classpath:cassandra.properties" })
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        //cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
        //cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9042);
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {

        //return environment.getProperty("cassandra.keyspace");
        return "activityrecognition";
    }
}
