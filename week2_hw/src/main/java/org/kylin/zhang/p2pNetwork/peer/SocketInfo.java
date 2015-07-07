package org.kylin.zhang.p2pNetwork.peer;

import org.kylin.zhang.p2pNetwork.peer.util.ServerId;

import java.net.InetSocketAddress ;

/**
 * Created by root on 7/7/15.
 */
public class SocketInfo
{

    long serverId ; // serverId just like UID of each server
    InetSocketAddress socketAddress ;

    public SocketInfo ( String ip , String port  )
    {

        this.socketAddress = new InetSocketAddress( ip , Short.parseShort( port )) ;
        this.serverId = ServerId.getServerID(ip , port) ;
    }

    public SocketInfo (ServerInfo info )
    {
        this(info.getIp() , info.getPort()) ;
    }

    public long getServerId()
    {
        return this.serverId ;
    }

    boolean compareServerId ( SocketInfo sockId) throws Exception
    {
        if ( this.serverId > sockId.getServerId() )
            return true ;
        else if (this.serverId < sockId.getServerId())
            return false ;
        else
            throw new Exception ("two server id equal , error !") ;
    }
}
