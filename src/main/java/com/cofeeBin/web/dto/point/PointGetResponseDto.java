package com.cofeeBin.web.dto.point;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointGetResponseDto {  //클라이언트에 보낼 것

    private int size; //얼마만큼 적립되었는지?
    private String date; //날짜
    private int curPoint; //현재 포인트



}
