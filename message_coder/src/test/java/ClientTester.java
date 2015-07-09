/**
 * Created by root on 7/9/15.
 */
import org.kylin.server.NettyServer ;

public class ClientTester
{
    public static void main ( String [] args )throws Exception
    {
        String ip = "10.2.0.27" ;
        String port = "9989" ;
        System.out.println("we start the client ") ;
        NettyServer.initClient( ip , port );
    }
}
