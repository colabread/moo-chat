package com.aidilude.moochat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyFriends {

    private String id;

    private String myUserId;

    private String friendUserId;

}