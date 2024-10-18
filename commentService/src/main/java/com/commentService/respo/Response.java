package com.commentService.respo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private int status;
    private String message;
    private Object data;
}
