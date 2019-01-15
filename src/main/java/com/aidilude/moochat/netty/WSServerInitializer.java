package com.aidilude.moochat.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


public class WSServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        //websocket基于http协议，所以要有http编解码器
        pipeline.addLast(new HttpServerCodec());
        //添加对大数据流的写支持
        pipeline.addLast(new ChunkedWriteHandler());
        //聚合HttpMessage，聚合成FullHttpRequest或FullHttpResponse
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));

        //=====================以上用于支持http协议=====================

        /**
         * 处理websocket协议的处理器
         * 指定了客户端连接的路由地址：/ws
         * 这个助手类会做很多事情，比如握手，close，ping，pong等
         * 对websocket来讲，数据都是以frames进行传输的，不同的数据类型对应的frames也不同
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //添加自定义处理器
        pipeline.addLast(new ChatHandler());
    }
}
