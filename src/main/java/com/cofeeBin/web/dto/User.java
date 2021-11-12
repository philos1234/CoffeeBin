package com.cofeeBin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User { //내부 객체
    private int userIdx;
    private String token;
    private String phone_num;
    private String email;
    private int point; //현재 포인트
}
