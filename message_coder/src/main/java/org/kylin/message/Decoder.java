package org.kylin.message;

import io.netty.buffer.ByteBuf ;
import io.netty.channel.ChannelHandlerContext ;
import io.netty.handler.codec.ByteToMessageDecoder ;
import io.netty.util.CharsetUtil ;
import java.util.List ;

/**
 * Created by root on 7/9/15.
 *
 * decoder is used to parse the input stream data
 * into the message struct into the List<Object> out
 */
public class Decoder  extends ByteToMessageDecoder
{


    @Override
    protected void decode ( ChannelHandlerContext ctx, ByteBuf in  , List<Object> out)
        throws Exception
    {
        Message msg = new Message() ;

        System.out.println( in.isReadable()) ;

        if ( in.readableBytes() < 3 )
        {
            System.out.println("message data wrong") ;
            return ;
        }

        //read message type
        msg.setType( MessageType.fromByte(in.readByte()));

        // read message length
        msg.setLength( in.readShort() );

        // read message data
       ByteBuf tempData = in.readBytes( msg.getLength()-3 ) ;
        msg.setData( tempData.array());

        out.add( new Message (msg.getType() , msg.getLength() , msg.getData())) ;

    }


}
