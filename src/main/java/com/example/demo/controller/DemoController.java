package com.example.demo.controller;

import com.example.demo.dao.SpanInfoMapper;
import com.example.demo.entity.SpanInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private SpanInfoMapper spanInfoMapper;

    @RequestMapping("/saveOneTest")
    public String saveOneTest() {
        SpanInfo spanInfo = new SpanInfo();
        spanInfo.setSpanId("ed9e341b73e94b6e97f2e98807a6ca3b.41.16116645268210000.1");
        spanInfo.setTraceId("be27038dc82548539b7947fff8603235.39.16116645267630003");
        spanInfo.setPathId(-1120152918L);
        spanInfo.setOperationName("MongoDB/FindOperation");
        spanInfo.setServiceName("alias.ts-travel-mongo:27017");
        spanInfo.setPodIp("127.0.0.1");
        spanInfo.setRequestName("BuyTicket");
        spanInfo.setSpanLayer("Exit");
        spanInfo.setStartTime(1611664526826L);
        spanInfo.setEndTime(1611664526828L);
        spanInfo.setTags("{\"@class\": \"java.util.HashMap\",\"db.type\": \"MongoDB\",\"db.statement\": \"FindOperation { \\\"_id\\\" : { \\\"type\\\" : \\\"D\\\", \\\"number\\\" : \\\"1345\\\" } }\"}");

        spanInfoMapper.saveOne(spanInfo);

        return "ok";
    }

    @RequestMapping("/saveManyTest")
    public String saveManyTest() {
        List<SpanInfo> spans = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            SpanInfo spanInfo = new SpanInfo();
            spanInfo.setSpanId("ed9e341b73e94b6e97f2e98807a6ca3b.41.16116645268210000." + i + "test");
            spanInfo.setTraceId("be27038dc82548539b7947fff8603235.39.16116645267630003" + i + "test");
            spanInfo.setPathId(-1120152918L);
            spanInfo.setOperationName("MongoDB/FindOperation");
            spanInfo.setServiceName("alias.ts-travel-mongo:27017");
            spanInfo.setPodIp("127.0.0.1");
            spanInfo.setRequestName("BuyTicket");
            spanInfo.setSpanLayer("Exit");
            spanInfo.setStartTime(1611664526826L);
            spanInfo.setEndTime(1611664526828L);
            spanInfo.setTags("{\"@class\": \"java.util.HashMap\",\"db.type\": \"MongoDB\",\"db.statement\": \"FindOperation { \\\"_id\\\" : { \\\"type\\\" : \\\"D\\\", \\\"number\\\" : \\\"1345\\\" } }\"}");
            spans.add(spanInfo);
        }
        spanInfoMapper.saveMany(spans);
        return "ok";
    }

    @RequestMapping("/selectBySpanId")
    public String selectBySpanId(@Param("spanId") String spanId) {
        SpanInfo spaninfo = spanInfoMapper.selectBySpanId(spanId);
        if (spaninfo == null) {
            return "not found";
        } else {
            return spaninfo.toString();
        }
    }

    @RequestMapping("/selectByTraceId")
    public String selectByTraceId(@Param("traceId") String traceId) {
        List<SpanInfo> spans = spanInfoMapper.selectManyByTraceId(traceId);
        return spans.toString();
    }

    @RequestMapping("/selectByPathId")
    public String selectByPathId(@Param("pathId") Long pathId) {
        List<SpanInfo> spans = spanInfoMapper.selectManyByPathId(pathId);
        return spans.toString();
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        List<SpanInfo> spans = spanInfoMapper.selectAll();
        return spans.toString();
    }
}
