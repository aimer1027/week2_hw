package org.kylin.handlers;

import io.netty.channel.ChannelInboundHandlerAdapter ;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import org.kylin.message.* ;

/**
 * Created by root on 7/9/15.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter
{
    @Override
    public void channelActive ( ChannelHandlerContext ctx )
    {
        // write message by this method
        // open file and read in a file and use the cycle to write message

        System.out.println("client sends connection requests to me !") ;
        String data = "hello aimer , hello kylin-zhang " ;
        short len =(short)( 3+ data.getBytes().length) ;

        Message msg = new Message (MessageType.READY_RECV_FILE , len , data.getBytes() ) ;

        // send the message to client
        ctx.writeAndFlush(msg) ;


    }
}
