package com.aidilude.moochat;

import com.aidilude.moochat.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MooChatApplicationTests {

	@Resource
	private UsersMapper usersMapper;

	@Test
	public void contextLoads() {

	}

}