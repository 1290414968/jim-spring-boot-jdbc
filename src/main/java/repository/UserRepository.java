package repository;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;

/**
 * {@link User 用户}的仓储(SQL、或NoSQL、或内存型)
 *
 * @author mercyblitz
 * @email mercyblitz@gmail.com
 * @date 2017-10-15
 **/
@Repository
public class UserRepository {

    private final DataSource dataSource;

    private final DataSource masterDataSource;

    private final DataSource salveDataSource;

    private final JdbcTemplate jdbcTemplate;

    private final PlatformTransactionManager platformTransactionManager;

    @Autowired
    public UserRepository(DataSource dataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("salveDataSource") DataSource salveDataSource,
                          JdbcTemplate jdbcTemplate,
                          PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.salveDataSource = salveDataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.platformTransactionManager = platformTransactionManager;
    }
    @Transactional
    public boolean save(User user) {

        return true;
    }

    private  boolean platTranSave(User user){
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status =  platformTransactionManager.getTransaction(definition);
        platformTransactionManager.commit(status);
        return true;
    }
    public Collection<User> findAll() {
        return Collections.emptyList();
    }

}
