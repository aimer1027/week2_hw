package org.kylin.message;

import io.netty.buffer.ByteBuf ;
import io.netty.channel.ChannelHandlerContext ;
import io.netty.handler.codec.MessageToByteEncoder ;
import io.netty.util.CharsetUtil ;

/**
 * Created by root on 7/9/15.
 */
public class Encoder extends MessageToByteEncoder<Message>
{
    @Override
    protected void encode ( ChannelHandlerContext ctx, Message msg , ByteBuf out)
        throws Exception
    {
        out.writeByte( msg.getType().getByte()) ;
        out.writeShort( msg.getLength() ) ;

        out.writeBytes( msg.getData() ) ;
    }
}
