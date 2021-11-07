package com.cofeeBin.web.dto;

import lombok.*;


@Data
@AllArgsConstructor
public class PointGetResponseDto {

    private String size; //얼마만큼 적립되었는지?
    private String date; //날짜
    private int curPoint; //현재 포인트

    public PointGetResponseDto(){

    }

}
