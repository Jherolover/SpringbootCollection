package com.elite.springboot.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;


/***
 * easyexcel监听类
 */
@Slf4j
public class ColumnListener implements ReadListener {

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param o
     * @param analysisContext
     */
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        System.out.println(o.toString());
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
