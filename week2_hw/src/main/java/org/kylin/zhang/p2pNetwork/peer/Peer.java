package org.kylin.zhang.p2pNetwork.peer;

import java.util.* ;

/**
 * Created by root on 7/7/15.
 */
public class Peer
{
    SocketInfo socketInfo ; // network connection
    ServerInfo serverInfo ; // store server node info
    Map<String , FileNode> fileHashMap ; // this list is used to store remote peer's
                                        // file on this server host


    public Peer ( String ip , String port )
    {}



}
