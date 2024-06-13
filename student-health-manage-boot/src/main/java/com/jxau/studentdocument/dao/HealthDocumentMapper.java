package com.jxau.studentdocument.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxau.studentdocument.entity.HealthDocument;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxau.studentdocument.utils.DTO.Clause;
import com.jxau.studentdocument.utils.DTO.Condition;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface HealthDocumentMapper extends BaseMapper<HealthDocument> {
    IPage<HealthDocument> selectPageBy(Page<HealthDocument> page,
                                       String content,
                                       String author,
                                       String book,
                                       int isPublished);
}
