package com.procuredox.receivers.db.dao;

import com.procuredox.receivers.db.model.DocumentXPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author procuredox on 9/18/16.
 */
public class JdbcDocumentDao extends JdbcDaoSupport implements DocumentDao {
    private static final Logger log = LoggerFactory.getLogger(JdbcDocumentDao.class);

    public DocumentXPaths loadPaths(String secKey, String rootElement) {
        try {
            final SimpleJdbcCall jdbcCall = new SimpleJdbcCall(getJdbcTemplate());
            final Map<String, Object> result = jdbcCall.withProcedureName("vendor_doc_xpath")
                    .returningResultSet("result", (ResultSet rs, int i) -> {
                        final DocumentXPaths paths = new DocumentXPaths();
                        paths.setCustomerCodeId(rs.getString("hascode"));
                        paths.setSenderIdentifierXpath(rs.getString("sender_identifier_xpath"));
                        paths.setReceiverIdentifierXpath(rs.getString("receiver_identifier_xpath"));
                        paths.setDocumentTypeXpath(rs.getString("document_type_xpath"));
                        return paths;
                    })
                    .execute(secKey, rootElement);
            final ArrayList<DocumentXPaths> resultList = (ArrayList<DocumentXPaths>) result.get("result");
            if (resultList.isEmpty()) {
                log.warn("can't load document xpaths for: secKey[{}], rootElement[{}]", secKey, rootElement);
                return null;
            }
            return resultList.get(0);
        } catch (DataAccessException e) {
            log.error("can't load document properties: {}", e.getMessage());
            return null;
        }
    }
}