package org.kylin.zhang.p2pNetwork.peer.util;

import java.util.HashMap ;
import io.netty.channel.Channel ;
import io.netty.channel.group.ChannelGroup ;
import io.netty.channel.group.DefaultChannelGroup ;
import io.netty.util.concurrent.GlobalEventExecutor;

import org.kylin.zhang.p2pNetwork.peer.Peer;

/**
 * Created by root on 7/8/15.
 */
public class ChannelMultiplexer
{
    private HashMap<Peer,Channel> channelMap ;
    private ChannelGroup channelGroup ;

    public ChannelMultiplexer()
    {
        channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE) ;
        channelMap   = new HashMap<Peer, Channel> () ;
    }

    public void addChannel(Peer peer , Channel c )
    {
        channelGroup.add(c) ;
        channelMap.put(peer, c ) ;
    }

    public Channel getChannel(Peer peer )
    {
        return channelMap.get(peer) ;
    }

    public ChannelGroup getAllChannels()
    {
        return channelGroup ;
    }
}
