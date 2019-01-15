package com.aidilude.moochat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class WSServer {

    private int port = 8088;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private ServerBootstrap server;

    private ChannelFuture future;

    public WSServer() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new WSServerInitializer());
        System.out.println("netty server init");
    }

    public void start() {
        future = server.bind(port);
    }

}