package org.kylin.zhang.netty.message;

import io.netty.channel.ChannelHandlerContext ;
import io.netty.channel.ChannelOutboundHandlerAdapter ;
import io.netty.channel.ChannelPromise ;

/**
 * Created by root on 7/8/15.
 */
public class MessagePacket extends ChannelOutboundHandlerAdapter
{
    // check if the message is empty

    @Override
    public void write (ChannelHandlerContext ctx , Object msg ,
                       ChannelPromise promis ) throws Exception
    {
      // first check

    }
}
