package com.malviya.pmp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author The Rp
 */
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
    @Autowired
    public void setDataSource2(DataSource ds){
        super.setDataSource(ds);
    }
    
}
