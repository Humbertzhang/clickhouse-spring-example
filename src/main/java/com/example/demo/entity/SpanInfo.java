package com.example.demo.entity;

import lombok.Data;

@Data
public class SpanInfo {
    private String spanId;
    private String traceId;
    private Long pathId;
    private String operationName;
    private String serviceName;
    private String podIp;
    private String requestName;
    private String spanLayer;
    private Long startTime;
    private Long endTime;
    private String tags;
}
