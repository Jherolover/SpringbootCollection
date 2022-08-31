package com.elite.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elite.springboot.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 表实体信息映射
 */
@Mapper
public interface TableEntityMapper extends BaseMapper<TableEntity> {

}
