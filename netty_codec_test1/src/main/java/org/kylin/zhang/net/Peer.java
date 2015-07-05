package org.kylin.zhang.net;

import java.net.InetAddress ;
import java.net.InetSocketAddress ;
import java.net.ServerSocket ;
import java.net.SocketAddress ;

import org.jboss.netty.channel.socket.DatagramChannel ;
import org.jboss.netty.channel.socket.SocketChannel ;

import org.kylin.zhang.utils.socket.SocketId ;

/**
 * Created by root on 7/5/15.
 */
public class Peer {
    // -- descriptrive data ---------------------------------------------
    private boolean connected;
    private P2PNetwork associatedNetwork;
    private SocketId id;

    // temporary data until socket initialization
    private InetAddress tempAddress;
    private int tempPort;

    public Peer(SocketId id)
    {
        this.id = id ;
        connected = false ;
    }

    public Peer ( InetSocketAddress address )
    {
        this(address.getAddress() , address.getPort () ) ;
    }

    public Peer ( InetAddress address , int port )
    {
        tempAddress = address ;
        tempPort = port ;
        connected = false ;
    }

    void join ( P2PNetwork network )
    {
        associatedNetwork = network ;
        network.addPeer (this) ;
    }

    void join ( P2PNetwork network , short assignedID , boolean localPeer )
    {
        connected = true ;
        associatedNetwork = network ;
        id = new SocketId (assignedID  , tempAddress , tempPort ,tempPort+1) ;
    }

    public boolean isConnected()
    {
        return connected ;
    }

    public P2PNetwork getAssociatedNetwork ()
    {
        return associatedNetwork ;
    }

    

}
