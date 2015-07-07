package org.kylin.zhang.netty.server;

import java.net.InetAddress ;
import java.net.UnknownHostException ;

import io.netty.bootstrap.Bootstrap ;
import io.netty.bootstrap.ServerBootstrap ;
import io.netty.channel.AddressedEnvelope ;
import io.netty.channel.Channel ;
import io.netty.channel.ChannelFuture ;
import io.netty.channel.ChannelFutureListener ;
import io.netty.channel.ChannelInboundHandler ;
import io.netty.channel.ChannelInitializer ;
import io.netty.channel.ChannelOption ;
import io.netty.channel.ChannelPipeline ;
import io.netty.channel.nio.NioEventLoopGroup ;
import io.netty.channel.socket.DatagramPacket ;
import io.netty.channel.socket.nio.NioDatagramChannel ;
import io.netty.channel.socket.nio.NioServerSocketChannel ;
import io.netty.handler.logging.LoggingHandler ;

import org.kylin.zhang.config.ConfigInfo;
import org.kylin.zhang.p2pNetwork.P2PNetwork;
import org.kylin.zhang.p2pNetwork.peer.* ;

import org.kylin.zhang.netty.handlers.* ;

/**
 * Created by root on 7/7/15.
 */
public class NettyServer
{
    private NioEventLoopGroup bossGroup ;
    private NioEventLoopGroup workerGroup ;

    private P2PNetwork network ;
    private SocketInfo localSocketInfo ;
    private boolean connected ;

    private Channel udpChannel ;

    /**
     * test only
     * @throws UnknownHostException
     * */

    public NettyServer ( P2PNetwork testNetwork , int port )
        throws UnknownHostException
    {
        connected = false ;
        network = testNetwork ;
        this.localSocketInfo =
                new SocketInfo (ConfigInfo.SERVER_IP , ConfigInfo.SERVER_PORT ) ;


    }

    private void  initNettyServer ()
    {
        ServerBootstrap b = new ServerBootstrap() ;
        b.group (bossGroup, workerGroup )
        .channel(NioServerSocketChannel.class)
        .handler(new ServerBossChannelInitializer())
        .childHandler( new ServerChannelInitializer(this))
        .bind(Integer.parseInt( ConfigInfo.SERVER_PORT));
    }


}
