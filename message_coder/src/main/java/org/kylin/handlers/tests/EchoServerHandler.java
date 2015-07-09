package org.kylin.handlers.tests;

import io.netty.channel.ChannelHandler.Sharable ;
import io.netty.channel.ChannelHandlerContext ;
import io.netty.channel.ChannelInboundHandlerAdapter ;

/**
 * Created by root on 7/9/15.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelRead ( ChannelHandlerContext ctx , Object msg )
    {
        ctx.write (msg) ;
    }

    @Override
    public void channelReadComplete ( ChannelHandlerContext ctx )
    {
        ctx.flush() ;
    }

    @Override
    public void exceptionCaught ( ChannelHandlerContext ctx, Throwable cause )
    {
        cause.printStackTrace();
        ctx.close () ;
    }
}
