package com.elite.springboot.utils;

import com.elite.springboot.entity.ColumnEntity;
import com.elite.springboot.entity.ColumnTypeConstant;
import com.elite.springboot.entity.TableEntity;

import java.util.List;

/**
 * 创建表辅助类
 * create database.table(
 *   column type  isprimarykey isnull default comment '',
 *   column2 type ,
 *   ....
 * )
 *  列顺序
 *  1.mysql:  字段 类型 约束  默认值  注释
 *  2.oracle: 字段 类型 约束  默认值  注释单独进行拼接一个串。
 *  3.mssql:
 */
public class CreateTableHelper {
    /**
     * @Param:将实体类转换为mysql创表的sql
     * @return:
     */
    public static String getMysqlSqlByConvertEntity(TableEntity tableEntity) {
        StringBuffer sql = new StringBuffer();
        //存在则删除表
        sql.append("DROP TABLE IF EXISTS "+tableEntity.getTableName()+";");
        sql.append("CREATE TABLE `");
        sql.append(tableEntity.getDatabaseName());
        sql.append("`.`");
        sql.append(tableEntity.getTableName());
        sql.append("` (");
        // CREATE TABLE `databaseName`.`tablePhysicalName` (
        List<ColumnEntity> columns = tableEntity.getTableColumns();
        // 主键列
        String primaryKeyColumn = null;
        //
        int i = 0;
        // 获取主键
        for (ColumnEntity column : columns) {
            // 将pk为true的设为主键
            if ("true".equals(column.getIsPrimaryKey()) || "Y".equals(column.getIsPrimaryKey())) {
                primaryKeyColumn = column.getColumnName();
                break;
            }
        }
        //循环列拼接动态的sql的顺序：
        //1.mysql:  字段 类型 约束  默认值  注释
        //2.oracle: 字段 类型 约束  默认值  注释单独进行拼接一个串。
        //3.mssql:
        for (ColumnEntity column : columns) {
            sql.append(" `");
            sql.append(column.getColumnName().trim());
            sql.append("` ");
            // `physicalColumnName`
            // 根据NOT NULL 来拼接
            if ("Y".equals(column.getIsNotNull()) || "true".equals(column.getIsNotNull())) { // 如果不允许为空，则拼接NOT NULL
                //类型
                String type = column.getColumnType().toLowerCase();
                if (type.indexOf("varchar") != -1) {
                    type = ColumnTypeConstant.VARCHAR;
                } else if (type.indexOf("number") != -1) {
                    type = ColumnTypeConstant.INT;
                    //默认长度
                    if (column.getColumnLen() == null || column.getColumnLen().isEmpty()) {
                        column.setColumnLen("11");
                    }
                } else if (type.indexOf("char") != -1) {
                    type = ColumnTypeConstant.CHAR;
                }
                // 根据类型选择是否拼接长度
                if (ColumnTypeConstant.CHAR.equals(type) || ColumnTypeConstant.VARCHAR.equals(type)) { // 文本需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(") CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '");
                } else if (ColumnTypeConstant.TEXT.equals(type) || ColumnTypeConstant.LONG_TEXT.equals(type)) { // 文本不需要拼接长度
                    sql.append(type);
                    sql.append(" CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '");
                } else if (ColumnTypeConstant.DATE.equals(type)) { // 时间不需要拼接长度
                    sql.append(type);
                    sql.append(" NOT NULL COMMENT '");
                } else if (ColumnTypeConstant.DATE_TIME.equals(type) || ColumnTypeConstant.TIME_STAMP.equals(type)) { // 时间需要拼接长度 并且长度为0
                    sql.append(type);
                    sql.append("(0) NOT NULL COMMENT '");
                } else if (ColumnTypeConstant.INT.equals(type)) { // 数字需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(")  NOT NULL COMMENT '");
                }
            } else { // 如果允许为空，则拼接 NULL DEFAULT NULL
                String type = column.getColumnType().toLowerCase();
                //类型转换
                if (type.indexOf("varchar") != -1) {
                    type = ColumnTypeConstant.VARCHAR;
                } else if (type.indexOf("number") != -1) {
                    type = ColumnTypeConstant.INT;
                    //默认长度
                    if (column.getColumnLen() == null || column.getColumnLen().isEmpty()) {
                        column.setColumnLen("11");
                    }
                } else if (type.indexOf("char") != -1) {
                    type = ColumnTypeConstant.CHAR;
                }
                // 根据类型选择是否拼接长度
                if (ColumnTypeConstant.CHAR.equals(type) || ColumnTypeConstant.VARCHAR.equals(type)) { // 文本需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(") CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '");
                } else if (ColumnTypeConstant.TEXT.equals(type) || ColumnTypeConstant.LONG_TEXT.equals(type)) { // 文本不需要拼接长度
                    sql.append(type);
                    sql.append(" CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '");
                } else if (ColumnTypeConstant.DATE.equals(type)) { // 时间不需要拼接长度
                    sql.append(type);
                    sql.append(" NULL DEFAULT NULL COMMENT '");
                } else if (ColumnTypeConstant.DATE_TIME.equals(type) || ColumnTypeConstant.TIME_STAMP.equals(type)) { // 时间需要拼接长度 并且长度为0
                    sql.append(type);
                    sql.append("(0) NULL DEFAULT NULL COMMENT '");
                } else if (ColumnTypeConstant.INT.equals(type) || ColumnTypeConstant.BIGINT.equals(type) || ColumnTypeConstant.LONG.equals(type)) { // 数字需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(")  NULL DEFAULT NULL COMMENT '");
                }
            }
            i++;
            // 拼接逻辑列名/如果为最后一个字段就不拼接，
            if (columns.size() == i && primaryKeyColumn == null) {
                sql.append(column.getColumnDesc());
                sql.append("'");
            } else {
                sql.append(column.getColumnDesc());
                sql.append("',");
            }
        }
        // 拼接主键
        if (primaryKeyColumn != null) {
            sql.append(" PRIMARY KEY (`");
            sql.append(primaryKeyColumn);
            sql.append("`) USING BTREE ) ");
        } else {
            sql.append(") ");
        }
        // 拼接引擎和逻辑表名
        sql.append("ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '");
        sql.append(tableEntity.getTableComment());
        sql.append("'  ROW_FORMAT = Compact;");
        System.out.println(sql.toString());
        return sql.toString();
    }
    /**
     * @Param:将实体类转换为oracle创表的sql
     * @return:
     */
    public static String getOracleSqlByConvertEntity(TableEntity tableEntity) {
        StringBuffer sql = new StringBuffer();
        //删表默认注释掉
        sql.append("--DROP TABLE "+tableEntity.getTableName()+";");
        StringBuffer comments = new StringBuffer();
        sql.append("CREATE TABLE `");
        sql.append(tableEntity.getDatabaseName());
        sql.append("`.`");
        sql.append(tableEntity.getTableName());
        sql.append("` (");
        // CREATE TABLE `databaseName`.`tablePhysicalName` (
        List<ColumnEntity> columns = tableEntity.getTableColumns();
        //获取表名注释
        comments.append("COMMENT ON TABLE "+ tableEntity.getTableName()+" is '"+tableEntity.getTableComment() +"';");
        // 主键列
        String primaryKeyColumn = null;
        int i = 0;
        // 获取主键
        for (ColumnEntity column : columns) {
            // 将pk为true的设为主键
            if ("true".equals(column.getIsPrimaryKey()) || "Y".equals(column.getIsPrimaryKey())) {
                primaryKeyColumn = column.getColumnName();
                break;
            }
        }
        //循环列拼接动态的sql的顺序：
        //1.mysql:  字段 类型 约束  默认值  注释
        //2.oracle: 字段 类型 约束  默认值  注释单独进行拼接一个串。
        //3.mssql:
        for (ColumnEntity column : columns) {
            sql.append(" `");
            sql.append(column.getColumnName().trim());
            sql.append("` ");
            // `physicalColumnName`
            // 根据NOT NULL 来拼接
            if ("Y".equals(column.getIsNotNull()) || "true".equals(column.getIsNotNull())) { // 如果不允许为空，则拼接NOT NULL
                //类型
                String type = column.getColumnType().toLowerCase();
                if (type.indexOf("varchar") != -1) {
                    type = ColumnTypeConstant.VARCHAR;
                } else if (type.indexOf("number") != -1) {
                    type = ColumnTypeConstant.INT;
                    //默认长度
                    if (column.getColumnLen() == null || column.getColumnLen().isEmpty()) {
                        column.setColumnLen("11");
                    }
                } else if (type.indexOf("char") != -1) {
                    type = ColumnTypeConstant.CHAR;
                }
                // 根据类型选择是否拼接长度
                if (ColumnTypeConstant.CHAR.equals(type) || ColumnTypeConstant.VARCHAR.equals(type)) { // 文本需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(")");
                } else if (ColumnTypeConstant.TEXT.equals(type) || ColumnTypeConstant.LONG_TEXT.equals(type)) { // 文本不需要拼接长度
                    sql.append(type);
                    sql.append(" '");
                } else if (ColumnTypeConstant.DATE.equals(type)) { // 时间不需要拼接长度
                    sql.append(type);
                    sql.append(" NOT NULL ");
                } else if (ColumnTypeConstant.DATE_TIME.equals(type) || ColumnTypeConstant.TIME_STAMP.equals(type)) { // 时间需要拼接长度 并且长度为0
                    sql.append(type);
                    sql.append("(0) NOT NULL ");
                } else if (ColumnTypeConstant.INT.equals(type)) { // 数字需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(")  NOT NULL ");
                }
            } else { // 如果允许为空，则拼接 NULL DEFAULT NULL
                String type = column.getColumnType().toLowerCase();
                //类型转换
                if (type.indexOf("varchar") != -1) {
                    type = ColumnTypeConstant.VARCHAR;
                } else if (type.indexOf("number") != -1) {
                    type = ColumnTypeConstant.INT;
                    //默认长度
                    if (column.getColumnLen() == null || column.getColumnLen().isEmpty()) {
                        column.setColumnLen("11");
                    }
                } else if (type.indexOf("char") != -1) {
                    type = ColumnTypeConstant.CHAR;
                }
                // 根据类型选择是否拼接长度
                if (ColumnTypeConstant.CHAR.equals(type) || ColumnTypeConstant.VARCHAR.equals(type)) { // 文本需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(") ");
                } else if (ColumnTypeConstant.TEXT.equals(type) || ColumnTypeConstant.LONG_TEXT.equals(type)) { // 文本不需要拼接长度
                    sql.append(type);
                    sql.append(" ");
                } else if (ColumnTypeConstant.DATE.equals(type)) { // 时间不需要拼接长度
                    sql.append(type);
                    sql.append(" ");
                } else if (ColumnTypeConstant.DATE_TIME.equals(type) || ColumnTypeConstant.TIME_STAMP.equals(type)) { // 时间需要拼接长度 并且长度为0
                    sql.append(type);
                    sql.append("(0) ");
                } else if (ColumnTypeConstant.INT.equals(type) || ColumnTypeConstant.BIGINT.equals(type) || ColumnTypeConstant.LONG.equals(type)) { // 数字需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(") ");
                }
            }
            i++;
            // 拼接逻辑列名/如果为最后一个字段就不拼接，
            if (columns.size() == i && primaryKeyColumn == null) {
                sql.append("");
            } else {
                sql.append(",");
            }
            //每一列的注释
            comments.append( "COMMENT ON COLUMN "+tableEntity.getTableName()+"."+column.getColumnName()+" IS '" + column.getColumnDesc()+"';");
        }
        // 拼接主键
        if (primaryKeyColumn != null) {
            sql.append(" PRIMARY KEY (`");
            sql.append(primaryKeyColumn);
            sql.append("`)); ");
        } else {
            sql.append(") ;");
        }
        System.out.println("sql:"+sql.toString());
        System.out.println("comment:"+comments.toString());
        return sql.toString()+comments.toString();
    }
    /**
     * @Param:将实体类转换为mssql创表的sql
     * @return:
     */
    public static  String getMSSQLSqlByConvertEntity(TableEntity tableEntity) {



        //建表字段的sql
        StringBuffer sql = new StringBuffer();
        //判断是否存在存在进行删除
        sql.append("IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].["+tableEntity.getTableName()+"]') AND type in (N'U')");
        sql.append("DROP TABLE [dbo].["+tableEntity.getTableName()+"];");
        sql.append("[dbo].["+tableEntity.getTableName()+"]");


        //表注释
        StringBuffer comments = new StringBuffer();
        comments.append("EXEC sp_addextendedproperty 'MS_Description', '"+tableEntity.getTableComment()+"', 'SCHEMA', dbo, 'table', "+tableEntity.getTableName()+", null, null;");


        // CREATE TABLE `databaseName`.`tablePhysicalName` (
        List<ColumnEntity> columns = tableEntity.getTableColumns();
        // 主键列
        String primaryKeyColumn = null;
        //
        int i = 0;
        // 获取主键
        for (ColumnEntity column : columns) {
            // 将pk为true的设为主键
            if ("true".equals(column.getIsPrimaryKey()) || "Y".equals(column.getIsPrimaryKey())) {
                primaryKeyColumn = column.getColumnName();
                break;
            }
        }
        //循环列拼接动态的sql的顺序：
        for (ColumnEntity column : columns) {
            sql.append(" `");
            sql.append(column.getColumnName().trim());
            sql.append("` ");
            // `physicalColumnName`
            // 根据NOT NULL 来拼接
            if ("Y".equals(column.getIsNotNull()) || "true".equals(column.getIsNotNull())) { // 如果不允许为空，则拼接NOT NULL
                //类型
                String type = column.getColumnType().toLowerCase();
                if (type.indexOf("varchar") != -1) {
                    type = ColumnTypeConstant.VARCHAR;
                } else if (type.indexOf("number") != -1) {
                    type = ColumnTypeConstant.INT;
                    //默认长度
                    if (column.getColumnLen() == null || column.getColumnLen().isEmpty()) {
                        column.setColumnLen("11");
                    }
                } else if (type.indexOf("char") != -1) {
                    type = ColumnTypeConstant.CHAR;
                }
                // 根据类型选择是否拼接长度
                if (ColumnTypeConstant.CHAR.equals(type) || ColumnTypeConstant.VARCHAR.equals(type)) { // 文本需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(")");
                } else if (ColumnTypeConstant.TEXT.equals(type) || ColumnTypeConstant.LONG_TEXT.equals(type)) { // 文本不需要拼接长度
                    sql.append(type);
                    sql.append(" ");
                } else if (ColumnTypeConstant.DATE.equals(type)) { // 时间不需要拼接长度
                    sql.append(type);
                    sql.append(" NOT NULL");
                } else if (ColumnTypeConstant.DATE_TIME.equals(type) || ColumnTypeConstant.TIME_STAMP.equals(type)) { // 时间需要拼接长度 并且长度为0
                    sql.append(type);
                    sql.append("(0) NOT NUL");
                } else if (ColumnTypeConstant.INT.equals(type)) { // 数字需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(")  NOT NULL");
                }
            } else { // 如果允许为空，则拼接 NULL DEFAULT NULL
                String type = column.getColumnType().toLowerCase();
                //类型转换
                if (type.indexOf("varchar") != -1) {
                    type = ColumnTypeConstant.VARCHAR;
                } else if (type.indexOf("number") != -1) {
                    type = ColumnTypeConstant.INT;
                    //默认长度
                    if (column.getColumnLen() == null || column.getColumnLen().isEmpty()) {
                        column.setColumnLen("11");
                    }
                } else if (type.indexOf("char") != -1) {
                    type = ColumnTypeConstant.CHAR;
                }
                // 根据类型选择是否拼接长度
                if (ColumnTypeConstant.CHAR.equals(type) || ColumnTypeConstant.VARCHAR.equals(type)) { // 文本需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(") ");
                } else if (ColumnTypeConstant.TEXT.equals(type) || ColumnTypeConstant.LONG_TEXT.equals(type)) { // 文本不需要拼接长度
                    sql.append(type);
                    sql.append(" ");
                } else if (ColumnTypeConstant.DATE.equals(type)) { // 时间不需要拼接长度
                    sql.append(type);
                    sql.append(" ");
                } else if (ColumnTypeConstant.DATE_TIME.equals(type) || ColumnTypeConstant.TIME_STAMP.equals(type)) { // 时间需要拼接长度 并且长度为0
                    sql.append(type);
                    sql.append("(0)  ");
                } else if (ColumnTypeConstant.INT.equals(type) || ColumnTypeConstant.BIGINT.equals(type) || ColumnTypeConstant.LONG.equals(type)) { // 数字需要拼接长度
                    sql.append(type);
                    sql.append("(");
                    sql.append(column.getColumnLen());
                    sql.append(") ");
                }
            }
            i++;
            // 拼接逻辑列名/如果为最后一个字段就不拼接，
            if (columns.size() == i && primaryKeyColumn == null) {
            } else {
                sql.append(",");
            }
            //追加注释表的sql
            comments.append("EXEC sp_addextendedproperty 'MS_Description', '"+column.getColumnDesc()+"', 'SCHEMA', dbo, 'table', "+tableEntity.getTableName()+", 'column', "+column.getColumnName()+";");
        }
        // 拼接主键
        if (primaryKeyColumn != null) {
            sql.append(", PRIMARY KEY (`");
            sql.append(primaryKeyColumn);
            sql.append("`); ");
        } else {
            sql.append("); ");
        }
        System.out.println(sql.toString());
        System.out.println(comments.toString());
        return sql.toString()+comments.toString();
    }
}
