package com.elite.springboot.cache;

import com.elite.springboot.entity.ColumnEntity;
import com.elite.springboot.entity.TableEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 临时存数据
 */
@Component
public class DataCache {

    //table
    public TableEntity tableEntity;

    /*
    *  列信息
     */
    public  List<ColumnEntity> columnEntityList ;

    public String sql = "";
    /**
     * 释放数据
     */
    public void realseTableColumn(){
        this.tableEntity = null;
        this.columnEntityList = null;
    }
    /**
     * 释放数据
     */
    public void realseAll(){
        this.tableEntity = null;
        this.columnEntityList = null;
        this.sql = "";
    }
}
