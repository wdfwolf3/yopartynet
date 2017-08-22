package com.yoparty.mapper;

import com.yoparty.bean.Area;

import java.util.List;

public interface AreaMapper {
    List<Area> select(String tableName, String parentId);

    List<Area> selectProvince();
}