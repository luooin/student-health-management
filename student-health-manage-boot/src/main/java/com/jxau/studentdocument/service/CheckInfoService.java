package com.jxau.studentdocument.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxau.studentdocument.entity.CheckInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxau.studentdocument.utils.DTO.Condition;
import org.springframework.http.ResponseEntity;

import java.awt.print.Book;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface CheckInfoService extends IService<CheckInfo> {

    ResponseEntity<CheckInfo> getCurrentCheckInfo(Integer userId);

    List<CheckInfo> getDataAnalysis(Integer userId);

    Page<CheckInfo> selectPage(Condition condition);

    boolean CheckIsExist(Integer userId, String checkYear);
}
