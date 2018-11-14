package com.ysm.ublog.mapper;

import com.ysm.ublog.vo.ActivityVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 15:01.
 */
public interface ActivityMapper {
   List<ActivityVo> findAllActivity(int id);
}
