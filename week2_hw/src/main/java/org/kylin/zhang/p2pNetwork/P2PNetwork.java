package org.kylin.zhang.p2pNetwork;

import java.util.ArrayList ;
import java.util.List ;


import java.util.* ;

import org.kylin.zhang.config.ConfigInfo;
import org.kylin.zhang.p2pNetwork.peer.* ;
import org.kylin.zhang.p2pNetwork.peer.util.* ;

/**
 * Created by root on 7/7/15.
 */
public class P2PNetwork
{
    List<Peer>  peerConnectedList ;
    FingerTable fingerTable ;

    public P2PNetwork ()
    {
        // first initialize self and insert it in fingerTable as the 0th element
        SelfNode self = new SelfNode() ;

        this.fingerTable = new FingerTable() ;
        this.peerConnectedList = new ArrayList<Peer>() ;

        this.fingerTable.addNewRecord(ConfigInfo.ZK_MAIN_PATH_NAME+"/"+ConfigInfo.SERVER_NAME,
                self );
    }
}
