package org.kylin.initializers;

import io.netty.channel.ChannelInitializer ;
import io.netty.channel.socket.nio.NioServerSocketChannel ;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler ;

/**
 * Created by root on 7/9/15.
 */
public class ServerBossChannelInitializer extends ChannelInitializer<NioServerSocketChannel>
{
    public ServerBossChannelInitializer ()
    {

    }

    @Override
    protected void initChannel ( NioServerSocketChannel ch ) throws Exception
    {
        ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO)) ;
    }
}
