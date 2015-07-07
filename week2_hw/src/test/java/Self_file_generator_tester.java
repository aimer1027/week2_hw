/**
 * Created by root on 7/7/15.
 */


import org.kylin.zhang.config.* ;
import org.kylin.zhang.p2pNetwork.peer.* ;

public class Self_file_generator_tester
{
    public static void main ( String [] args ) throws Exception
    {
        ConfigLoader.loadInitPropFile();
        ConfigLoader.loadZooConfFile();

        SelfNode selfNode = new SelfNode() ;

        selfNode.localFileGenerator();
        selfNode.printFileMap();
    }
}
