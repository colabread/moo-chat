package com.aidilude.moochat.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * TextWebSocketFrame是netty用于处理文本对象的，是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //所有客户端channel的容器
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        Channel currentChannel = channelHandlerContext.channel();
        String currentShortID = currentChannel.id().asShortText();
        String content = textWebSocketFrame.text();
        System.out.println("收到客户端[" + currentShortID + "]的消息：" + content);

        for (Channel channel : clients) {
            channel.writeAndFlush(new TextWebSocketFrame("[" + currentShortID + "]：" + content));
        }

        //上面的循环也可以写成下面这种方式
//        clients.writeAndFlush(new TextWebSocketFrame("[" + currentShortID + "]：" + content));

    }

    /**
     * 当新客户端（channel）连接时将会调用此方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    /**
     * 当channel关闭时将调用此方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel currentChannel = ctx.channel();
        String currentShortID = currentChannel.id().asShortText();
        String currentLongID = currentChannel.id().asLongText();
        System.out.println(currentLongID);
        clients.writeAndFlush("[" + currentShortID + "]退出群聊");
    }

}
