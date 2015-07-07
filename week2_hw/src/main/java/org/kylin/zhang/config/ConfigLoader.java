package org.kylin.zhang.config;

import org.springframework.core.io.support.PropertiesLoaderUtils ;

import java.io.* ;
import java.util.Properties ;

/**
 * Created by root on 7/6/15.
 *
 * this class is used to get the zookeeper's config file zoo.cfg
 * and find the matched server name's record.
 * load and save the corresponding file contents into loader.properties
 *
 */
public class ConfigLoader
{


    /**
     * this method is used to load init.properties file
     * and get its corresponding information into Properties instance
     *
     * throws Exception
     * */
  public static  void loadInitPropFile () throws Exception
  {

      Properties initProp = PropertiesLoaderUtils.loadAllProperties(ConfigInfo.INIT_PATH) ;

      System.out.println (initProp) ;

      ConfigInfo.ZK_CONF_PATH = initProp.getProperty("ZK_CONF_PATH") ;


      ConfigInfo.ZK_MAIN_PATH_NAME = initProp.getProperty("ZK_MAIN_PATH_NAME") ;



      ConfigInfo.SERVER_NAME       = initProp.getProperty("SERVER_NAME") ;

      ConfigInfo.PRO_MAIN_PATH   = initProp.getProperty("PRO_MAIN_PATH") ;
  }

    /**
     * this method is used to load in the zoo.cfg file in
     * then find one server name matches with current server name
     * if could not find matches one , throws Exception with info 'no server name matches'
     * if find one matches , get the server's corresponding
     * ip:port information into the Properties object the loaderProp member variable
     *
     * @throws Exception : 1. config file zoo.cfg could not find 2. no server name matches
     * */
    public static void loadZooConfFile () throws Exception
    {
        File zoo_conf = new File (ConfigInfo.ZK_CONF_PATH) ;
        Properties loaderProp  = new Properties() ;

        if ( !zoo_conf.exists() && zoo_conf.isDirectory())
        {
            System.err.println ("zookeeper config file zoo.cfg not exists ") ;
            throw new Exception ("zoo.cfg file not exists ") ;
        }

        BufferedReader zoo_file = new BufferedReader(new FileReader(zoo_conf));

        String a_line;

        while ((a_line = zoo_file.readLine()) != null)
        {
            if (a_line.startsWith(ConfigInfo.SERVER_NAME)) {
                //server.1=<IP/HOSTNAME>:<port_client>:<port_leader_select>
                ConfigInfo.SERVER_IP = a_line.substring(a_line.indexOf('=') + 1, a_line.indexOf(':'));
                ConfigInfo.SERVER_PORT =  a_line.substring(a_line.indexOf(':') + 1, a_line.lastIndexOf(':'));

                // only if the server name matches we create a new instance of the loaderProp
                // if no server name matches in zoo.cfg , the loaderProp = null

                System.out.println (ConfigInfo.SERVER_NAME) ;
                System.out.println (ConfigInfo.SERVER_IP) ;
                System.out.println(ConfigInfo.SERVER_PORT) ;

                loaderProp.setProperty("SERVER_IP" , ConfigInfo.SERVER_IP) ;
                loaderProp.setProperty("SERVER_PORT" ,   ConfigInfo.SERVER_PORT ) ;

                break ;
            }
        }

        // here we close the input stream
        zoo_file.close() ;


        if ( loaderProp == null )
        {
            System.err.println("no server name in zoo.cfg matches with "+ ConfigInfo.SERVER_NAME ) ;
            throw new Exception ("no server name matches") ;
        }

        createLoaderProp(loaderProp);
    }

    /**
     * this method is used to create a loader.properties under the same path as init.properties file
     * and write the loaderProp instance's contents into it .
     *
     * if the file loaderProp.properties already exists , delete it and re-create it to let the
     * contents always the fresh version
     *
     * */
    public static void createLoaderProp( Properties loaderProp )
    {
        String loaderPropFile = ConfigInfo.PRO_MAIN_PATH+ ConfigInfo.LOADER_PATH;
        System.out.println(loaderPropFile) ;

        File loader_file = new File(loaderPropFile);

        if (loader_file.exists())
            loader_file.delete();

        try {

            loader_file.createNewFile();

            OutputStream output = new FileOutputStream(loader_file);

            loaderProp.store(output, "");

            output.flush() ;
            output.close() ;
        } catch (Exception ex) {
            System.err.println("failed create new file or fail write new contents into file");
            ex.printStackTrace();
        }

    }

}
