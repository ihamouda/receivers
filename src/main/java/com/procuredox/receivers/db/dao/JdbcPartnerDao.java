package com.procuredox.receivers.db.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author procuredox on 9/18/16.
 */
@Deprecated
public class JdbcPartnerDao extends JdbcDaoSupport implements PartnerDao {
    private static final Logger log = LoggerFactory.getLogger(JdbcPartnerDao.class);

    @Override
    @Deprecated
    public String findPartnerBySecKey(String key) {
        try {
            final List<String> list = getJdbcTemplate().queryForList(
                    "select partner_id from partner where partner_key = ?",
                    String.class, key);
            if (list.isEmpty()) {
                log.warn("can't get partner by security key: {}", key);
                return null;
            }
            return "OK";
        } catch (DataAccessException e) {
            log.warn("can't get partner by security key: {}", e.getMessage());
            return null;
        }
    }
}