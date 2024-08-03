package com.application.banking_system_monolithic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private int code;
    private boolean success;
    private String message;
    private Object data;
}
