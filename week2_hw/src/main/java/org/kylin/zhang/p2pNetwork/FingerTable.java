package org.kylin.zhang.p2pNetwork;

import java.util.* ;

import org.kylin.zhang.p2pNetwork.peer.* ;
/**
 * Created by root on 7/7/15.
 */
public class FingerTable
{
    Map<String , Peer> fingerTable ;

    public FingerTable ()
    {
        this.fingerTable = new HashMap<String, Peer>() ;
    }

    public Peer findPeerNodeByZkPath ( String zk_path )
    {
        Peer dPeer = (Peer)this.fingerTable.get(zk_path) ;

        if ( dPeer != null )
            return dPeer ;

        System.out.println("can not find peer node with zookeeper path "+ zk_path ) ;
        return dPeer ;
    }

    public void addNewRecord ( String zk_path , Peer peer )
    {
        if (findPeerNodeByZkPath( zk_path) != null )
        {
            System.out.println("path already have znode ") ;
            return ;
        }
        this.fingerTable.put(zk_path , peer ) ;
    }

    public void removeRecord(String zk_path )
    {
        if ( findPeerNodeByZkPath(zk_path) == null )
        {
            System.out.println("can not find record with key = "+ zk_path ) ;
            return ;
        }

        this.fingerTable.remove(zk_path) ;
    }
}
