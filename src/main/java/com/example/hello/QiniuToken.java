package com.example.hello;

import lombok.Data;

@Data
public class QiniuToken {

    private Long deadline;

    private String scope;


}