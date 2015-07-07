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
import org.kylin.zhang.p2pNetwork.peer.util.FileNode ;

/**
 * Created by root on 7/7/15.
 */
public class Peer
{
    SocketInfo socketInfo ; // network connection
    ServerInfo serverInfo ; // store server node info
    Map<String , FileNode> fileHashMap ; // this list is used to store remote peer's
                                        // file on this server host
  ;

    public Peer ( String serverName , String ip , String port )
    {
        this.serverInfo = new ServerInfo( serverName , ip , port) ;
        this.socketInfo = new SocketInfo (ip , port ) ;

        this.fileHashMap = new HashMap<String , FileNode> () ;
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


}
