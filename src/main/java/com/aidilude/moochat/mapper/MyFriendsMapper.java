package com.aidilude.moochat.mapper;

import com.aidilude.moochat.pojo.MyFriends;

public interface MyFriendsMapper {

    int deleteByPrimaryKey(String id);

    int insert(MyFriends record);

    MyFriends selectByPrimaryKey(String id);

    int updateByPrimaryKey(MyFriends record);

}