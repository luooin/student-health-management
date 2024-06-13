package com.jxau.studentdocument.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxau.studentdocument.entity.Suggestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxau.studentdocument.utils.DTO.InfoDTO;
import com.jxau.studentdocument.utils.DTO.InfoReadDTO;
import com.jxau.studentdocument.utils.Vo.SuggestionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoufanxi
 * @since 2024-01-12
 */
public interface SuggestionService extends IService<Suggestion> {

    Page<SuggestionVo> selectPage(InfoDTO infoDTO);

    boolean markToRead(InfoReadDTO infoReadDTO);
}
