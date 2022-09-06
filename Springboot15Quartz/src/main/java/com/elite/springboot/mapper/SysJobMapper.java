package com.elite.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elite.springboot.entity.SysJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统任务映射类
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJob> {

}
