package com.aidilude.moochat.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FriendsRequest {

    private String id;

    private String sendUserId;

    private String acceptUserId;

    private Date requestDateTime;

}