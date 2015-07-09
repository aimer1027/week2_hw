package org.kylin.handlers.tests;

import io.netty.buffer.ByteBuf ;
import io.netty.buffer.Unpooled ;
import io.netty.channel.ChannelHandlerContext ;
import io.netty.channel.ChannelInboundHandlerAdapter ;


/**
 * Created by root on 7/9/15.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter
{
    private ByteBuf firstMessage ;

    // here we create a client handler
    public EchoClientHandler()
    {
        String data = "hello zhang kylin " ;
        firstMessage = Unpooled.buffer(2914) ;
        firstMessage.writeBytes(data.getBytes()) ;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx )
    {
        ctx.writeAndFlush(firstMessage) ;
    }

    @Override
    public void channelRead( ChannelHandlerContext ctx, Object msg )
    {
        ctx.write(msg) ;
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
