package org.kylin.initializers;

import io.netty.channel.ChannelInitializer ;
import io.netty.channel.socket.SocketChannel ;

import org.kylin.message.* ;
import org.kylin.handlers.client.ClientReceiveMessage ;

/**
 * Created by root on 7/9/15.
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel>
{
    public ClientChannelInitializer()
    {

    }

    @Override
    protected void initChannel( SocketChannel ch ) throws Exception
    {
        ch.pipeline()


                .addLast("client handler", new ClientReceiveMessage()) .addLast("decoder" , new Decoder ());

    }
}
