
package com.svoflee.spartacus.core.domain.utils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.svoflee.spartacus.core.domain.meta.Column;
import com.svoflee.spartacus.core.domain.meta.DataType;
import com.svoflee.spartacus.core.domain.meta.Table;

/**
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class DBMetaDataUtils {

    /**************************** Fields ****************************/

    /**
     * 获取一个底层数据表的MetaSchemaInfo
     * 
     * @param databaseMetaData
     * @param tableName
     * @return
     * @throws SQLException
     */
    public static List<Column> getColumnMetaInfo(DatabaseMetaData databaseMetaData, String tableName)
            throws SQLException {
        List<Column> result = new ArrayList<Column>();
        // String[] types = { "TABLE" };
        // ResultSet tablesResult = dbMetaData.getTables("", "%", tableName,
        // types);//获取所有TableName 的Table表
        ResultSet columnsResult = databaseMetaData.getColumns("", "%", tableName, "%");
        while (columnsResult.next()) {
            Column column = new Column();
            String columnName = columnsResult.getString("COLUMN_NAME");
            int columnDataType = columnsResult.getInt("DATA_TYPE");// 获取数据字段类型
            String columnDataTypeName = columnsResult.getString("TYPE_NAME");// 获取类型名称
            int columnSize = columnsResult.getInt("COLUMN_SIZE");// 字段长度

            column.setName(columnName);
            column.setDataType(DataType.fromSupportSqlType(columnDataType));
            // column.setType(columnDataType);
            column.setTypeName(columnDataTypeName);
            column.setColumnSize(columnSize);
            result.add(column);
        }
        return result;
    }

    // private static DataType getDataTypeByColumnDataType(int columnDataType) {
    // // VVV:稍后实现该方法
    // EUtils.throwNotSupportedException();
    //
    // return null;
    // }

    /**
     * 获取一个数据库中指定数据表的所有MetaData
     * 
     * @param dbMetaData
     * @param tableName
     * @return
     * @throws SQLException
     */
    public static List<Table> getTableMetaInfo(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        List<Table> result = new ArrayList<Table>();
        String[] types = { "TABLE" };
        ResultSet tablesResult = databaseMetaData.getTables("", "%", tableName, types);
        while (tablesResult.next()) {
            Table aTable = new Table();
            String tableNameFromDb = tablesResult.getString("TABLE_NAME");
            aTable.setTableName(tableNameFromDb);
            result.add(aTable);
        }
        return result;
    }

    /**
     * 获取一个数据库的所有MetaData
     * 
     * @param databaseMetaData
     * @return
     * @throws SQLException
     */
    public static List<Table> getTableMetaInfo(DatabaseMetaData databaseMetaData) throws SQLException {
        List<Table> result = new ArrayList<Table>();
        String[] types = { "TABLE" };
        ResultSet tablesResult = databaseMetaData.getTables("", "%", "%", types);
        while (tablesResult.next()) {
            Table aTable = new Table();
            String tableName = tablesResult.getString("TABLE_NAME");
            aTable.setTableName(tableName);
            result.add(aTable);
        }
        return result;
    }

    public static boolean isNumType(int columnType) {
        // TODO:@@@@@@ 这里可能存在遗漏的情况
        return (columnType == Types.INTEGER) || (columnType == Types.BIGINT) || (columnType == Types.BIT)
                || (columnType == Types.DOUBLE) || (columnType == Types.FLOAT) || (columnType == Types.NUMERIC)
                || (columnType == Types.TINYINT) || (columnType == Types.REAL);
    }

    public static boolean isStringType(int columnType) {
        // TODO:@@@@@@ 这里可能存在遗漏的情况
        return !isNumType(columnType) && (columnType != Types.CLOB) && (columnType != Types.BLOB);
    }

}
