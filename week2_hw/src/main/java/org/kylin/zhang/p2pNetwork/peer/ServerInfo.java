package org.kylin.zhang.p2pNetwork.peer;

/**
 * Created by root on 7/7/15.
 */

public class ServerInfo
{
    String hostname ;
    String ip ;
    String port ;

    public void setHostname ( String hostname )
    {
        this.hostname = hostname ;
    }

    public void setIp ( String ip )
    {
        this.ip = ip ;
    }

    public void setPort ( String port )
    {
        this.port = port ;
    }

    public String getHostname ()
    {
        return hostname ;
    }

    public String getIp ()
    {
        return ip ;
    }

    public String getPort ()
    {
        return port ;
    }

}
