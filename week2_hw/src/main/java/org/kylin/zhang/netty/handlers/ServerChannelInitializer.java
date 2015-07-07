package org.kylin.zhang.netty.handlers;

import io.netty.channel.ChannelInitializer ;
import io.netty.channel.socket.nio.NioServerSocketChannel ;
import io.netty.handler.logging.LogLevel ;
import io.netty.handler.logging.LoggingHandler ;

import org.kylin.zhang.netty.server.NettyServer ;

/**
 * Created by root on 7/7/15.
 */
public class ServerChannelInitializer extends ChannelInitializer <NioServerSocketChannel>
{
   private NettyServer server ;

    public ServerChannelInitializer ( NettyServer server )
    {
        this.server = server ;
    }

    @Override
    protected void initChannel ( NioServerSocketChannel ch ) throws Exception
    {

    }

}

