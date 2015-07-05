package org.kylin.zhang.net;

/**
 * Created by root on 7/5/15.
 */
public interface  P2PNetworkListener
{
    public void networkPeerConnected ( P2PNetwork network , Peer peer ) ;
    public void networkPeerDisconnected ( P2PNetwork network , Peer peer ) ;
}
