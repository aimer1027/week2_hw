package org.kylin.zhang.net;

import java.util.ArrayList ;
import java.util.List ;

import org.kylin.zhang.utils.socket.SocketId ;
import org.kylin.zhang.net.NetworkInformation ;

/**
 * Created by root on 7/5/15.
 */
public class P2PNetwork
{
    // all connected peers. The fist in the list is the localhost
    private List<Peer> connectedPeers ;

    private List<P2PNetworkListener> listeners ;

    private NetworkInformation info ;

    P2PNetwork ()
    {
        connectedPeers = new ArrayList<Peer> () ;
        listeners = new ArrayList<P2PNetworkListener >() ;
    }

    P2PNetwork ( NetworkInformation info )
    {
        this() ;
        setNetworkInfo (info) ;
    }


    public void broadcast ( Object ... objects )
    {
        for ( Object o : objects )
            broadcast (o) ;
    }

    public void broadcast ( Object o )
    {

    }

    public void sendTo( Peer peer , Object ... objects )
    {
        for( Object o : objects )
            sendTo(peer , o ) ;
    }

    public void sendTo(Peer peer, Object object  )
    {

    }

    public void sendToHost ( Object ... objects )
    {
        for ( Object o : objects )
            sendToHost ( o ) ;
    }

    public void sendToHost ( Object o )
    {

    }

    void addPeer ( Peer peer )
    {
        info.addPeer () ;
        connectedPeers.add(peer) ;
        notifyPeerAdded(peer) ;
    }

    void setNetworkInfo ( NetworkInformation info )
    {
        this.info = info ;
    }

    public NetworkInformation getNetworkInfo ()
    {
        assert info != null ;
        return info ;
    }

    public Iterable<Peer> getAllConnectedPeers ()
    {
        return connectedPeers ;
    }

    private void notifyPeerAdded ( Peer newPeer )
    {
        for ( P2PNetworkListener listener : listeners )
        {
            listener.networkPeerConnected(this , newPeer );
        }
    }

    private void notifyPeerremoved (Peer removedPeer )
    {
        for ( P2PNetworkListener listener : listeners )
        {
            listener.networkPeerDisconnected(this, removedPeer );
        }
    }

}
