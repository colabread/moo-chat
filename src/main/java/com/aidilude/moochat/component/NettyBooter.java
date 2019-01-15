package com.aidilude.moochat.component;

import com.aidilude.moochat.netty.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 实现ApplicationListener的bean会监听传入的泛型事件
 * 此处传入的是ContextRefreshedEvent，那么该bean会监听这个事件
 * ContextRefreshedEvent：当所有的bean都初始化完成并被成功装载后会触发该事件
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private WSServer wsServer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {    //当spring容器初始化完成，启动netty服务
            wsServer.start();
            System.out.println("netty server started");
        }
    }

}