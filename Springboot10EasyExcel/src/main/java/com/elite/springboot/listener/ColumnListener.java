package com.elite.springboot.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.elite.springboot.cache.DataCache;
import com.elite.springboot.entity.ColumnEntity;
import com.elite.springboot.mapper.ColumnEntityMapper;
import com.elite.springboot.mapper.TableEntityMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/***
 * easyexcel监听类
 * 保存数据库传入构造mapper
 */
@Slf4j
public class ColumnListener implements ReadListener {


    private  DataCache dataCache;

    //保存主表类
    private TableEntityMapper tableEntityMapper;


    //保存列表类
    private ColumnEntityMapper columnEntityMapper;

    public ColumnListener(TableEntityMapper tableEntityMapper,ColumnEntityMapper columnEntityMapper,DataCache dataCache){
        this.tableEntityMapper =  tableEntityMapper;
        this.columnEntityMapper = columnEntityMapper;
        this.dataCache = dataCache;
    }
    /**
     * 这个每一条数据解析都会来调用
     *
     * @param o
     * @param analysisContext
     */
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {

        dataCache.columnEntityList.add((ColumnEntity) o);
    }

    /**
     * 所有数据解析完成了 都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //
        log.info("所有数据解析完成！");
    }
}
