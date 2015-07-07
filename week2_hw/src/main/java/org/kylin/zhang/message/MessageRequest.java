package org.kylin.zhang.message;

import java.util.LinkedList ;
import java.util.List ;

import io.netty.buffer.ByteBuf ;

/**
 * Created by root on 7/5/15.
 */
public class MessageRequest
{
    private short clientID ;
    private short [] destinationIDs ;
    private boolean broadcast ;
    private ByteBuf buffer ;
    private List<Object> requests ;

    MessageRequest ()
    {
        requests = new LinkedList<Object> ();
        broadcast = false ;
    }

    public MessageRequest ( short ... destinationIDs )
    {
        this () ;
        this.destinationIDs = destinationIDs ;
    }

    public void add ( Object request )
    {
        requests.add(request) ;
    }

    public void add ( Object ... request )
    {
        for ( Object o : requests )
        {
            add(o) ;
        }
    }

    public void setBuffer ( ByteBuf buffer )
    {
        this.buffer = buffer ;
    }

    public ByteBuf getBuffer ()
    {
        return buffer ;
    }

    void broadcast()
    {
        broadcast = true ;
    }

    public boolean isBroadcast ()
    {
        return broadcast ;
    }

    void setDestinationIDs ( short ... ids )
    {
        destinationIDs = ids ;
    }

    public void setClientID ( short id )
    {
        clientID = id ;
    }

    public short getClientID ()
    {
        return clientID ;
    }

    public short [] getDestinationIDs ()
    {
        return destinationIDs ;
    }

    public Iterable<Object> request ()
    {
        return requests ;
    }
}
