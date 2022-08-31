package com.elite.springboot;



import com.elite.springboot.entity.ColumnEntity;
import com.elite.springboot.entity.TableEntity;
import com.elite.springboot.mapper.ColumnEntityMapper;
import com.elite.springboot.mapper.TableEntityMapper;
import com.elite.springboot.utils.CreateTableHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    @Resource
    ColumnEntityMapper columnEntityMapper;

    @Resource
    TableEntityMapper tableEntityMapper;
    /**
     * 测试oracel
     */
    @Test
    public void geneSQL() {
        List<ColumnEntity> columns = new ArrayList<>();
        ColumnEntity column1 = new ColumnEntity();
        column1.setColumnName("id");
        column1.setColumnDesc("主键");
        column1.setColumnType("int");
        column1.setColumnLen("30");
        column1.setIsPrimaryKey("Y");
        column1.setIsNotNull("true");
        ColumnEntity column2 = new ColumnEntity();
        column2.setColumnName("name");
        column2.setColumnDesc("姓名");
        column2.setColumnType("varchar");
        column2.setColumnLen("50");
        column2.setIsPrimaryKey("N");
        column2.setIsNotNull("N");
        //添加列1
        columns.add(column1);
        //添加列2
        columns.add(column2);
        //表实体类
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName("testtable");
        tableEntity.setTableComment("测试表");
        tableEntity.setTableColumns(columns);
        tableEntity.setDatabaseName("testdb");

        //输出mysqlSql
        //String mysqlSql = CreateTableHelper.getMysqlSqlByConvertEntity(tableEntity);

        //输出oracelSql
        String oracelSql = CreateTableHelper.getOracleSqlByConvertEntity(tableEntity);
        System.out.println(oracelSql);

    }
    /**
     * 插入sql
     */
    @Test
    public void test(){

        //插入主表ID
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName("table1");
        tableEntity.setTableComment("测试表");
        tableEntity.setDatabaseName("test");
        tableEntity.setDatabaseType("mysql");
        tableEntity.setTableSchema("");
        tableEntityMapper.insert(tableEntity);

        ColumnEntity columnEntity = new ColumnEntity();
        columnEntity.setColumnName("test");
        columnEntity.setTableId(1);
        columnEntity.setColumnDesc("测试列");
        columnEntity.setColumnType("int");
        columnEntity.setColumnLen("30");
        columnEntity.setIsPrimaryKey("Y");
        columnEntity.setIsNotNull("N");
        columnEntityMapper.insert(columnEntity);

    }
}
