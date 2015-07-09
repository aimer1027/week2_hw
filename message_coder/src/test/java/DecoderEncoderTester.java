/**
 * Created by root on 7/9/15.
 *
 * here we simulate the channel readin and
 * write out methods
 *
 * this means that we encoder a message and then transfer by the
 * channel
 * and then
 * get the channel output message
 * and then use the decoder
 *
 * and we check the input message and output message 's values
 *
 * however the name of the test is not correctly ,
 * we first encoder the message and then decoder it
 *
 */

import io.netty.buffer.ByteBuf ;
import io.netty.buffer.Unpooled ;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.embedded.EmbeddedChannel ;
import io.netty.util.CharsetUtil ;


import org.kylin.message.* ;

import org.junit.Assert ;
import org.junit.Test ;


public class DecoderEncoderTester
{
    @Test
    public void  MainProcess ()
    {
        Message inMessage , outMessage ;

        // we initialize the inMessage
        String data = "Hello Aimer, Hello World!" ;
        short  len = (short)(data.getBytes().length + 3) ;
        MessageType type = MessageType.READY_SEND_FILE ;

        inMessage = new Message(type ,len , data.getBytes()) ;

        System.out.println("here is the inMessage ") ;
        System.out.println(inMessage ) ;

        // decoder : Bytebuf ---> Message object
        // Encoder : Message object ---> Bytebuf

        EmbeddedChannel channelIn =   new EmbeddedChannel ( new Encoder ()) ;
        EmbeddedChannel channelOut = new EmbeddedChannel (new Decoder()    ) ;

        channelIn.writeOutbound(  inMessage ) ;
        ByteBuf buffer = (ByteBuf)channelIn.readOutbound() ;

        // after we write the Message object into the channel which bind the ENcoder and we get the ByteBuf of the message
        // when we use the read out method

        // and then , we write the buffer into the channelOut channel
        channelOut.writeInbound(  buffer ) ;
        // and we try to get the Message object on the other
        outMessage = (Message)channelOut.readInbound() ;

        System.out.println( outMessage ) ;



/*
        /// after we use the writeInbound method write the data
        // into the channel (simulated channel)
        // we use the readInbound method to read the object
        // from the channel , and transfer it into the
        // message
        outMessage= (Message) channel.readInbound() ;


        System.out.println(" this is the output message ") ;
        System.out.println(outMessage) ;
        */
    }

    @Test
    public void test()
    {

    }


}
