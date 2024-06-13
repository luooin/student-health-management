package com.jxau.studentdocument.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxau.studentdocument.entity.HealthDocument;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxau.studentdocument.utils.DTO.Condition;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface HealthDocumentService extends IService<HealthDocument> {

    Page<HealthDocument> selectPage(Condition condition);

    HealthDocument updateHealthDocument(HealthDocument healthDocument);
}
