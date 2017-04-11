package com.xinguang;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.xinguang.msgprotocol.client.transfer.MCProtocolPB;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by fanzhengchen on 4/11/17.
 */

public class MainServiceNative extends Service {

    private static final String HOST = "172.16.14.115";
    private static final int PORT = 12345;

    private MarsServiceStub stub;

    @Override
    public void onCreate() {
        super.onCreate();
        stub = new MarsServiceStub();
        System.out.println("service on create " + MyThrowable.printDefault());

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareGroupWithNetty();
            }
        }).start();
//        prepareGroupWithNetty();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    private void prepareGroupWithNetty() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .remoteAddress(HOST, PORT)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();

                        pipeline.addLast(new ProtobufVarint32FrameDecoder());
                        pipeline.addLast(new ProtobufDecoder(MCProtocolPB.MCProtocol.getDefaultInstance()));
                        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                        pipeline.addLast(new ProtobufEncoder());

                        pipeline.addLast(new MainServiceHandler("100"));
                    }
                });

        ChannelFuture future = bootstrap.connect(HOST, PORT);
        try {
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
