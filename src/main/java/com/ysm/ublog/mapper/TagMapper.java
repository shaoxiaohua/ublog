package com.ysm.ublog.mapper;

import com.ysm.ublog.tag.entity.T_tags;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    void addUserTag(@Param("t_tag") T_tags t_tags);
}
