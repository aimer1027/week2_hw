package org.kylin.initializers;

import io.netty.channel.ChannelInitializer ;
import io.netty.channel.socket.nio.NioServerSocketChannel ;
import org.kylin.handlers.ServerHandler;
import org.kylin.message.* ;

/**
 * Created by root on 7/9/15.
 */
public class ServerChildChannelInitializer extends ChannelInitializer<NioServerSocketChannel>
{
    public ServerChildChannelInitializer ()
    {}


    // here is the active method which means , this method's will be invoked
    // immediately when a client connects to the server

    @Override
    protected void initChannel ( NioServerSocketChannel ch )
        throws Exception
    {
        ch.pipeline().addLast("encoder ", new Encoder())
                .addLast("sender" , new ServerHandler () ) ;


    }
}
