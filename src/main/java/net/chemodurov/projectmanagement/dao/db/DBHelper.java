package net.chemodurov.projectmanagement.dao.db;

import java.math.BigDecimal;
import java.sql.ResultSet;

public interface DBHelper {

    void connect();

    ResultSet prepStatementExecuteQuery();

    void disconnect();
    void setAutoCommit(boolean autoCommit);

    void createPrepareStatement(String sql);
    DBHelper prepStatementSetString(int parameterIndex, String uuid);
    DBHelper prepStatementSetBigDecimal(int parameterIndex, BigDecimal bigDecimal);

    DBHelper prepStatementExecuteUpdate();

    void prepareStatementAddBatch();
    int[] prepareStatementExecuteBatch();
    void commit();

    boolean execute(String sql);
    ResultSet executeQuery(String sql);
}