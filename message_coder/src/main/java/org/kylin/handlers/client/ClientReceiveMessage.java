package org.kylin.handlers.client;

import org.kylin.message.* ;
import io.netty.channel.ChannelHandlerContext ;
import io.netty.channel.ChannelInboundHandlerAdapter ;

/**
 * Created by root on 7/9/15.
 *
 * this class extends the ChannelOutboundAdapter
 * we known that the Outbound channel is user self-defined net channel
 *
 * here we implements the
 * 1. read method which reads the server's byte buf
 *    and transfer it into the instance of Message
 *
 * note this handler adapter 's handler is after of the decoder
 * which means the decoder already decode the ByteBuf into the
 * message object
 *
 */
public class ClientReceiveMessage extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelRead ( ChannelHandlerContext ctx, Object msg )
    {
        System.out.println("message received from server") ;
        System.out.println((Message)msg) ;


    }

    @Override
    public void exceptionCaught ( ChannelHandlerContext ctx , Throwable cause )
    {
        cause.printStackTrace();
    }
}
