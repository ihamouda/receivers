package com.procuredox.receivers.db.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author procuredox on 9/18/16.
 */
public class JdbcBatchNumberDao extends JdbcDaoSupport implements BatchNumberDao {

    @Override
    public int next() {
        return getJdbcTemplate().queryForObject("select batchnumber()", Integer.class);
    }

}