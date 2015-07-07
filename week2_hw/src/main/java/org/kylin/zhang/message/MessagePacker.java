package org.kylin.zhang.message;

import io.netty.channel.ChannelHandlerContext ;
import io.netty.channel.ChannelOutboundHandlerAdapter ;
import io.netty.channel.ChannelPromise ;

/**
 * Created by root on 7/5/15.
 */
public class MessagePacker extends ChannelOutboundHandlerAdapter
{
    public static class EmptyMessageException extends Exception
    {
        private static final long serialVersionUID = -321673216732167L ;
        public EmptyMessageException ()
        {
            super("Requesting to send a message with no content .") ;
        }
    }


    
}
