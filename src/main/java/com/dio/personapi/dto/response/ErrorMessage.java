package com.dio.personapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor @Builder @Getter
public class ErrorMessage {

    private String status;
    private String error;
    private String message;
    // private String path;

}
