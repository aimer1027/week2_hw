package org.kylin.zhang.p2pNetwork.peer.util;

/**
 * Created by root on 7/7/15.
 */
public class ServerId
{
    // this method is used to get serverId from ip and port
    public static long getServerID ( String ip , String port)
    {
        int pos1 = ip.indexOf('.') ;
        int pos2 = ip.indexOf('.' , pos1+1) ;
        int pos3 = ip.indexOf('.' , pos2+1) ;

        long ip_arr[] = new long [5] ;

        ip_arr[0] = Long.parseLong( ip.substring(0 , pos1) ) ;
        ip_arr[1] = Long.parseLong ( ip.substring(pos1+1 , pos2 )) ;
        ip_arr[2] = Long.parseLong ( ip.substring(pos2+1 , pos3)) ;
        ip_arr[3] = Long.parseLong ( ip.substring(pos3+1)) ;
        ip_arr[4] = Long.parseLong ( port ) ;

        long rt = (ip_arr[0]<<32)+(ip_arr[1]<<24) + (ip_arr[2] << 16) + (ip_arr[3]<< 8) + ip_arr[4] ;

        return rt ;
    }
}
