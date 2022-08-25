package com.elite.springboot.service.impl;

import com.elite.springboot.entity.Dict;
import com.elite.springboot.mapper.DictMapper;
import com.elite.springboot.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-08-24
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

}
