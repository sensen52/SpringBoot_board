package com.example.ex01.mapper;

//mapper.xml과 동일한 경로여야한다.

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {
    public String getTime();
}
