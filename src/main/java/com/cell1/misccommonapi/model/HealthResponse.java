package com.cell1.misccommonapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthResponse {
    private String service;
    private String status;
    private long timestamp;
}
