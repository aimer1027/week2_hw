package org.kylin.zhang.utils.socket;

import java.net.InetAddress ;
import java.net.InetSocketAddress ;

/**
 * Created by root on 7/5/15.
 */
public class SocketId
{
    public static enum Status {INVALID, UNRESOLVED ,IDENTIFY_PENDING, IDENTIFIED} ;

    long addedTimeStamp ;
    Status idStatus ;
    String name ;
    short clientId ;
    InetSocketAddress udpAddress ;
    InetSocketAddress tcpAddress ;

    public SocketId ()
    {
        idStatus = Status.INVALID ;
    }

    public SocketId ( short id , InetAddress ipAddress , int tcpPort , int udpPort )
    {
        name = ""+clientId ;
        udpAddress = new InetSocketAddress (ipAddress , udpPort ) ;
        tcpAddress = new InetSocketAddress (ipAddress , tcpPort ) ;

        clientId = id ;
    }

    public void setName ( String name )
    {
        this.name = name ;
    }

    /**
     * @return The associated name to this socket . Default is th eid
     * */
    public String getName ()
    {
        return name ;
    }

    public short getClientId ()
    {
        return clientId ;
    }

    public InetSocketAddress getUdpAddress ()
    {
        return udpAddress ;
    }

    public InetSocketAddress getTcpAddress ()
    {
        return tcpAddress ;
    }

    public long getAddedTimeStamp ()
    {
        return addedTimeStamp ;
    }

    public boolean isIdentified ()
    {
        return idStatus.equals(Status.IDENTIFIED) ;
    }

    @Override
    public int hashCode ()
    {
        int hash = 666 ;
        if ( idStatus != Status.INVALID)
            hash = udpAddress.hashCode()+tcpAddress.hashCode()
                    + 7 * clientId ;
        return hash ;
    }

    @Override
    public boolean equals ( Object obj )
    {
        boolean equals = true ;
        SocketId other = (SocketId) obj ;

        if ( !udpAddress.equals(other.udpAddress))
        {
            equals = false ;
        }
        if ( !tcpAddress.equals(other.tcpAddress))
        {
            equals = false ;
        }

        if ( clientId != other.clientId)
        {
            if ( equals )
                System.err.println("Warning : Two socketIds with the " +
                        "same addresses but different ids") ;
            equals = false ;
        }

        return equals ;
    }

}
