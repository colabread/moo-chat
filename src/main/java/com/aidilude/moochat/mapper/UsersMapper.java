package com.aidilude.moochat.mapper;

import com.aidilude.moochat.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {

    int deleteByPrimaryKey(String id);

    @Insert("insert into users(id,username,password,nickname,qrcode,face_image,face_image_big,cid) " +
            "values(#{id},#{username},#{password},#{nickname},#{qrcode},#{faceImage},#{faceImageBig},#{cid})")
    int insert(Users record);

    @Select("select * from users where id = #{id}")
    Users selectByPrimaryKey(String id);

    int updateByPrimaryKey(Users record);

}