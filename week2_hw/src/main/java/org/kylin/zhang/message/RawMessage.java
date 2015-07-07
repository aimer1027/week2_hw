package org.kylin.zhang.message;


/**
 * Created by root on 7/5/15.
 *
 * this is the package structure .
 *
 * |Message|Message-Length : 2 bytes | Message-Type : 1byte |
 * Message-Data : x bytes = (Message-Length -3 ) bytes
 *
 */
public class RawMessage
{
    private MessageType type ;
    private short       length ;
    private byte []     data ;

    public RawMessage ()
    {}

    public RawMessage (MessageType type , short len , byte [] data )
    {
        this.type = type ;
        this.length = len ;
        this.data = data ;
    }

    public short getLength ()
    {
        return this.length ;
    }
    public void setLength ( short len )
    {
        this.length = len ;
    }


    public MessageType getType ()
    {
        return this.type ;
    }

    public void setType ( MessageType type )
    {
        this.type = type ;
    }

    public byte [] getData ()
    {
        return this.data ;
    }

    public void setData ( byte [] data )
    {
        this.data = data ;
    }


    @Override
    public String toString ()
    {
        return "\nmessage type :"+this.type +"\n"
                +"message length :"+this.length +"\n"
                +"message content :"+ new String (this.data) +"\n" ;
    }

}
