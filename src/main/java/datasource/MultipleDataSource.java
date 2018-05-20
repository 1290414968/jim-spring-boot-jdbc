package datasource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
@Configuration
public class MultipleDataSource {
    @Bean
    @Primary
    public DataSource masterDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://47.52.240.168:3306/spring-jdbc")
                .username("jim")
                .password("Jim$$123!")
                .build();
        return dataSource;
    }
    @Bean
    public DataSource salveDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://47.52.240.168:3306/spring-jdbc-2")
                .username("jim")
                .password("Jim$$123!")
                .build();
        return dataSource;
    }
}
