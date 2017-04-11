package com.xinguang;

import com.xinguang.msgprotocol.client.transfer.MCProtocolPB;
import com.xinguang.msgprotocol.client.transfer.MsgTypePB;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by fanzhengchen on 4/11/17.
 */

public class MainServiceHandler extends ChannelInboundHandlerAdapter {


    private String mUserId = null;

    public MainServiceHandler(String userId) {
        mUserId = userId;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg + " " + MyThrowable.printDefault());
    }

    /**
     * 发送消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("channle active " + MyThrowable.printDefault());
        MCProtocolPB.MCProtocol builder = MCProtocolPB.MCProtocol.newBuilder()
                .setAppClientID("tubobo-pda-android")
                .setPlatformID("tubobo")
                .setClientSN(mUserId)
                .setType(MsgTypePB.MsgType.HEART_BEAT)
                .build();

        byte[] bytes = builder.toByteArray();

        MCProtocolPB.MCProtocol mcProtocol = MCProtocolPB.MCProtocol.parseFrom(bytes);

        ctx.writeAndFlush(builder);
        System.out.println("userId " + mUserId + " send " + builder.toString() + " "
                + MyThrowable.printDefault());

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive " + MyThrowable.printDefault());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception " + MyThrowable.printDefault());
        cause.printStackTrace();
        ctx.close();
    }
}
