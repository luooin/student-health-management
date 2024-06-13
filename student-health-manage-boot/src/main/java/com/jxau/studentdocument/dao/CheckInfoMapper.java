package com.jxau.studentdocument.dao;

import com.jxau.studentdocument.entity.CheckInfo;
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
public interface CheckInfoMapper extends BaseMapper<CheckInfo> {
    List<CheckInfo> getDataAnalysis(@Param("userId") Integer userId);

    CheckInfo getCurrentCheckInfo(@Param("userId") Integer userId);
}
