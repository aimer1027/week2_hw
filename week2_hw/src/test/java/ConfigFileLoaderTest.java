import org.kylin.zhang.config.* ;

/**
 * Created by root on 7/7/15.
 *
 * in this file we would like write the test
 * method of ConfigLoader
 */
public class ConfigFileLoaderTest
{
    public static void main ( String [] args ) throws Exception
    {


        ConfigLoader.loadInitPropFile();
        ConfigLoader.loadZooConfFile();



        System.out.println("what we use most during the whole proj " +
                "is the ConfigInfo and its static config infos so output them " +
                "to see are they initialized or not ") ;

        System.out.println("-----------------------------------------") ;
        System.out.println ("INIT_PATH   "+ConfigInfo.INIT_PATH) ;
        System.out.println ("LOADER_PATH   " +ConfigInfo.LOADER_PATH) ;

        System.out.println("Server ip  "+ConfigInfo.SERVER_IP) ;
        System.out.println("Server name "+ConfigInfo.SERVER_NAME) ;

        System.out.println("Server ZK MAIN PATH NAME"+ ConfigInfo.ZK_MAIN_PATH_NAME) ;

        System.out.println("Server ZK_CONF_PATH   "+ConfigInfo.ZK_CONF_PATH) ;



    }
}
