package com.jxau.studentdocument.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxau.studentdocument.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxau.studentdocument.utils.DTO.Condition;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface RoleService extends IService<Role> {
    List<Role> selectAll();

    Page selectPage(Condition condition);

}
