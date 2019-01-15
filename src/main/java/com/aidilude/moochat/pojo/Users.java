package com.aidilude.moochat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private String id;

    private String username;

    private String password;

    private String nickname;

    private String qrcode;

    private String faceImage;

    private String faceImageBig;

    private String cid;

}