package org.kylin.zhang.p2pNetwork.peer;

import org.kylin.zhang.p2pNetwork.peer.util.ServerId;

import java.net.InetSocketAddress ;

/**
 * Created by root on 7/7/15.
 */
public class SocketInfo
{

    String serverName ;
    String ip ;
    String port ;
    long serverId ; // serverId just like UID of each server
    InetSocketAddress socketAddress ;

    public SocketInfo ( String serverName , String ip , String port  )
    {
        this.serverName = serverName ;
        this.ip = ip ;
        this.port = port ;
        this.socketAddress = new InetSocketAddress( ip , Short.parseShort( port )) ;
        this.serverId = ServerId.getServerID(ip , port) ;
    }

    public SocketInfo ( SocketInfo info  )
    {
        this.serverName = info.getServerName() ;
        this.ip  = info.getIp() ;
        this.port = info.getPort() ;
    }


    public long getServerId()
    {
        return this.serverId ;
    }
    public String getIp () {return this.ip ;}
    public String getPort () {return this.port ;}
    public String getServerName () {return this.serverName ;}

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
