/**
 * Created by root on 7/9/15.
 */

import io.netty.buffer.ByteBuf ;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.embedded.EmbeddedChannel ;
import io.netty.util.CharsetUtil ;

import org.junit.Assert ;
import org.junit.Test ;

import org.kylin.message.* ;

public class EncoderTest
{
    @Test
    public void testMessageEncoder()
    {
        String msgData = "Hello Aimer, Hello World !" ;
        short len =(short) (3 + msgData.getBytes().length) ;
        Message msg = new Message ( MessageType.READY_SEND_FILE , len , msgData.getBytes()) ;

        EmbeddedChannel channel = new EmbeddedChannel ( new Encoder ()    ) ;


        Assert.assertTrue( channel.writeOutbound( msg )) ;
        // write the message directly, and we get the ByteBuf when we read outbound

        ByteBuf encoded = (ByteBuf) channel.readOutbound() ;

        Assert.assertNotNull(encoded) ;

       Message enMsg = new Message () ;

        enMsg.setType( MessageType.fromByte( encoded.readByte()));
        enMsg.setLength( encoded.readShort());

        ByteBuf tData = encoded.readBytes(enMsg.getLength() -3) ;
        enMsg.setData( tData.array() );

        System.out.println(enMsg) ;



    }
}
