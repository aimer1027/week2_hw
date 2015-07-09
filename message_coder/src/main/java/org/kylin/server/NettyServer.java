package org.kylin.server;

import io.netty.bootstrap.Bootstrap ;
import io.netty.bootstrap.ServerBootstrap ;
import io.netty.channel.ChannelFuture ;
import io.netty.channel.nio.NioEventLoopGroup ;
import io.netty.channel.socket.nio.NioServerSocketChannel ;
import io.netty.channel.socket.nio.NioSocketChannel ;

import org.kylin.initializers.ClientChannelInitializer;
import org.kylin.initializers.ServerBossChannelInitializer;
import org.kylin.initializers.ServerChildChannelInitializer;


/**
 * Created by root on 7/9/15.
 *
 * this server is a little different from the server
 * in this NettyServer it will invoke  multi-thread which
 * one server thread running to receive different requests
 * and more than two client threads running to request to connect to the
 * server
 *
 *
 */
public class NettyServer
{
    private NioEventLoopGroup bossGroup ;
    private NioEventLoopGroup workerGroup ;

    public NettyServer ()
    {
        this.bossGroup = new NioEventLoopGroup( ) ;
        this.workerGroup = new NioEventLoopGroup( ) ;
    }


    public void initServer ( String ip , String port )
    {
        ServerBootstrap bootstrap = new ServerBootstrap () ;
        bootstrap.group(bossGroup , workerGroup )
                .channel(NioServerSocketChannel.class)
                .handler( new ServerBossChannelInitializer())
                .childHandler( new ServerChildChannelInitializer())
                .bind(ip , Short.parseShort( port )) ;
    }

    public static void initClient ( String ip , String port ) {
        Bootstrap clientBootstrap = new Bootstrap();
        NioEventLoopGroup clientGroup = new NioEventLoopGroup();

        try {
            clientBootstrap.group(clientGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer());

            ChannelFuture chf = clientBootstrap.connect(ip, Short.parseShort(port)).sync();

            // wait until the connection is closed
            chf.channel().closeFuture().sync() ;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        finally {
            clientGroup.shutdownGracefully() ;
        }
    }


    public static void main ( String [] args ) throws Exception
    {
        String ip = "10.2.0.27" ;
        String port = "9989" ;
        NettyServer server = new NettyServer () ;

        server.initServer(ip , port );


        Thread.sleep(60) ;
        System.out.println("client send connect request to server ") ;
       NettyServer.initClient(ip, port );
    }
}
