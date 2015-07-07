package org.kylin.zhang.config;

/**
 * Created by root on 7/6/15.
 *
 * these config info are used to initial server and zookeeper path
 *
 * znode-path = ZK_MAIN_PATH_NAME+"/"+SERVER_NAME
 *
 */
public class ConfigInfo
{
    // init.properties file path
    public static final String INIT_PATH="init.properties" ;
    public static final String LOADER_PATH = "/Conf/loader.properties" ;


    public static String PRO_MAIN_PATH ;
    public static String ZK_CONF_PATH ;
    public static String ZK_MAIN_PATH_NAME ;
    public static String SERVER_NAME ;
    public static String SERVER_IP ;
    public static String SERVER_PORT ;



}
