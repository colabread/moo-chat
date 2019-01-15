package com.aidilude.moochat.mapper;


import com.aidilude.moochat.pojo.FriendsRequest;

public interface FriendsRequestMapper {

    int deleteByPrimaryKey(String id);

    int insert(FriendsRequest record);

    FriendsRequest selectByPrimaryKey(String id);

    int updateByPrimaryKey(FriendsRequest record);

}