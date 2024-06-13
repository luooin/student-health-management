package com.jxau.studentdocument.dao;

import com.jxau.studentdocument.entity.Resources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface ResourcesMapper extends BaseMapper<Resources> {

    List<Resources> findRoleResource(@Param("roleId") Integer roleId, @Param("typeId")Integer typeId);

    /**
     *  获取所有url 和 权限
     *  @return 对应所有资源
     */
    List<Resources> listUrlAndPermission();
}
