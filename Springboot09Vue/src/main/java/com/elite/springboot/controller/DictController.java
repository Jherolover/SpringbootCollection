package com.elite.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elite.springboot.common.R;
import com.elite.springboot.entity.Dict;
import com.elite.springboot.entity.Order;
import com.elite.springboot.service.IDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-08-24
 */
@Api(tags = "字典接口")
@RestController
@RequestMapping("/springboot/dict")
public class DictController {

    @Autowired
    IDictService dictService;

    /**
     * 获取字段列表
     */
    @ApiOperation(value = "获取字段列表")
    @PostMapping("/getDictListByPage/{currentPage}/{PageSize}")
    public R getOrderListPage(@PathVariable("currentPage")Integer currentPage,
                              @PathVariable("PageSize") Integer PageSize,
                              @RequestBody Dict dict){
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        IPage<Dict> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(PageSize);
       if (!StringUtils.isEmpty(dict.getDictType())){
           queryWrapper.eq("dict_type",dict.getDictType());
       }
        if (!StringUtils.isEmpty(dict.getDictCode())){
            queryWrapper.eq("dict_code",dict.getDictCode());
        }
        IPage<Dict> Orders = dictService.page(page, queryWrapper);
        return R.ok(Orders);
    }
    /**
     * 根据字典ID获取字典
     */
    @PostMapping("/getDictByDictId/{dict_id}")
    @ApiOperation(value = "获取字段列表")
    public R getDictByDictId(@PathVariable("dict_id") Integer dict_id){
        Dict dict = dictService.getById(dict_id);
        return R.ok(dict);
    }

    /**
     * 新增字典
     */
    @PostMapping("/saveDict")
    @ApiOperation(value = "新增字典")
    public R saveDict(@RequestBody Dict dict){
        boolean save = dictService.save(dict);
        if (save){
         return R.ok(null);
        }
        return R.fail();
    }
    /**
     * 更新字典
     */
    @ApiOperation(value = "更新字典")
    @PutMapping("/updateDictById")
    public R updateDictById(@RequestBody Dict dict){
        boolean success = dictService.updateById(dict);
        if (success){
            return R.ok(null);
        }
        return R.fail();
    }

    /**
     * 删除字典
     */
    @ApiOperation(value = "删除字典")
    @DeleteMapping("/removeDictById/{dict_id}")
    public R removeDictById(@PathVariable("dict_id") Integer dict_id){
        boolean success = dictService.removeById(dict_id);
        //删除成功
        if (success){
            return R.ok(null);
        }
        return R.fail();
    }
}
