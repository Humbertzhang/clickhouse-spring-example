package com.example.demo.dao;

import com.example.demo.entity.SpanInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpanInfoMapper {
    // 存入数据
    void saveOne(SpanInfo spanInfo);
    // 批量存入数据
    void saveMany(List<SpanInfo> spanInfoList);

    SpanInfo selectBySpanId(@Param("spanId") String spanId);
    List<SpanInfo> selectManyByTraceId(@Param("traceId") String traceId);
    List<SpanInfo> selectManyByPathId(@Param("pathId") Long pathId);
    List<SpanInfo> selectAll();
}
