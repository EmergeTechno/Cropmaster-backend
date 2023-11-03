package com.deviot.cropmasterbackend.shared.exceptions;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;

}