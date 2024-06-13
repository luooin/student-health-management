package com.jxau.studentdocument.service;

import com.jxau.studentdocument.entity.Resources;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxau.studentdocument.utils.Vo.ResourceVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface ResourcesService extends IService<Resources> {
    List<ResourceVO> getResourceTreeByRoleId(Integer roleId, Integer typeId);

    List<ResourceVO> getResourceTreeByUserId(Integer userId,Integer typeId);

}
