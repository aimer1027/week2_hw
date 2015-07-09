package org.kylin.message;

/**
 * Created by root on 7/9/15.
 *
 * Message-Structure
 * Message-Type : 1 byte
 * Message-Length : 2 bytes
 * Message-Data : n bytes
 *
 * n = Message-Length - 3
 */
public class Message
{
    private MessageType type ;
    private short       length ;
    private byte[]      data   ;

    public Message()
    {}

    public Message (MessageType type , short len , byte [] data )
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
