package com.aidilude.moochat.mapper;

import com.aidilude.moochat.pojo.ChatMsg;
import org.apache.ibatis.annotations.Insert;

public interface ChatMsgMapper {

    int deleteByPrimaryKey(String id);

    int insert(ChatMsg record);

    ChatMsg selectByPrimaryKey(String id);

    int updateByPrimaryKey(ChatMsg record);

}