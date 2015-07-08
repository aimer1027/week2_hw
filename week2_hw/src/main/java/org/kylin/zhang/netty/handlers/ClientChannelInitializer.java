package org.kylin.zhang.netty.handlers;

import io.netty.channel.ChannelInitializer ;
import io.netty.channel.socket.SocketChannel ;
import org.kylin.zhang.netty.message.MessagePacket;
import org.kylin.zhang.netty.message.RawMessage;
import org.kylin.zhang.p2pNetwork.peer.Peer;

/**
 * Created by root on 7/8/15.
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel>
{
    public ClientChannelInitializer (Peer peer )
    {
        // read a random file and
    }
    @Override
    protected void initChannel(SocketChannel ch ) throws Exception
    {
        ch.pipeline()
                .addLast ( new MessagePacket() ) ;
    }
}
