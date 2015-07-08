package org.kylin.zhang.p2pNetwork.peer;

import java.net.UnknownHostException ;
import io.netty.bootstrap.Bootstrap ;
import io.netty.channel.Channel ;
import io.netty.channel.ChannelFuture ;
import io.netty.channel.EventLoopGroup ;
import io.netty.channel.nio.NioEventLoopGroup  ;
import io.netty.channel.socket.nio.NioSocketChannel ;

import java.net.InetAddress ;
import java.net.InetSocketAddress ;

import java.util.* ;

import org.kylin.zhang.netty.handlers.ClientChannelInitializer;
import org.kylin.zhang.netty.server.NettyServer;
import org.kylin.zhang.p2pNetwork.peer.util.* ;

/**
 * Created by root on 7/7/15.
 */
public class Peer
{
    SocketInfo socketInfo ; // network connection

    Map<String , FileNode> fileHashMap ; // this list is used to store remote peer's
                                        // file on this server host

    ChannelMultiplexer mux ;

    NettyServer server ;

    public Peer (String serverName , String ip , String port )
    {

    }

    public Peer ( NettyServer server)
    {
        this(server.getLocalSocketInfo().getServerName() , server.getLocalSocketInfo().getIp() ,
                server.getLocalSocketInfo().getPort() ) ;
    }

    public void setNettyServer ( NettyServer server )
    {
        this.server = server ;
    }

    // this method used to create a Peer by the given messages

    public Peer createPeer ( SocketInfo sockInfo )
    {
        Peer peer = new Peer ( sockInfo.getServerName() , socketInfo.getIp() , socketInfo.getPort()) ;
        return peer ;
    }

    public Peer [] createPeers (SocketInfo ... sockInfo)
    {
        Peer [] peers = new Peer[sockInfo.length] ;

        for ( int i = 0 ; i < sockInfo.length ; i++ )
        {
            peers[i] = createPeer(sockInfo[i]) ;
        }

        return peers ;
    }

    public ChannelFuture connectToRemotePeer ( Peer peer )
    {
        EventLoopGroup group = new NioEventLoopGroup () ;
        return bootstrap( peer.getSocketInfo().socketAddress ,group ) ;
    }

    private ChannelFuture bootstrap( InetSocketAddress address ,
                                     EventLoopGroup group )
    {
        Bootstrap b = new Bootstrap ( ) ;

        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ClientChannelInitializer(this )) ;

        return b.connect(address) ;
    }

    public SocketInfo getSocketInfo ()
    {
        return this.socketInfo ;
    }

    public void printFileMap ()
    {
        Iterator iter = fileHashMap.keySet().iterator() ;

        while ( iter.hasNext())
        {
            Object key = (String ) iter.next() ;
            Object val = (FileNode) fileHashMap.get(key)  ;

            System.out.println("---------------------------------------------------------------------------------") ;
            System.out.println ("key  "+ key ) ;
            System.out.println ("value "+ val ) ;
            System.out.println("---------------------------------------------------------------------------------") ;
        }

    }

    public void connectToAnotherPeer ( Peer otherPeer )
    {

    }

    public ChannelFuture writeTo (Object o , Peer dest )
    {
        Channel c = getSpecificChannel( dest ) ;
        return c.write(o) ;
    }

    private Channel getSpecificChannel (Peer destination)
    {
        return mux.getChannel(destination) ;
    }

    public void flushTo(Peer destination )
    {
        Channel c = getSpecificChannel( destination) ;
    }

    public ChannelFuture writeAndFlushTo ( Object o , Peer dest)
    {
        ChannelFuture future = writeTo(o, dest) ;
        flushTo(dest) ;

        return future ;
    }


}
