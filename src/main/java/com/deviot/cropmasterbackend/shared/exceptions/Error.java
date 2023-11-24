package com.deviot.cropmasterbackend.shared.exceptions;

import lombok.Data;
import lombok.Setter;

@Data
public class Error {
    private String code;
    private String message;

}