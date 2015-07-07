package org.kylin.zhang.p2pNetwork.peer;

import org.kylin.zhang.config.* ;
import java.io.* ;
import java.util.* ;

/**
 * Created by root on 7/7/15.
 *
 * class Peer is used to refer peer server nodes
 * and the SelfNode is used to refer to self server node
 *
 *
 */
public class SelfNode extends Peer
{
    public SelfNode (  )
    {
        super(ConfigInfo.SERVER_NAME , ConfigInfo.SERVER_IP , ConfigInfo.SERVER_PORT) ;
    }

    public void localFileGenerator () throws Exception
    {
        // create 30 files in default
        this.localFileGenerator(30);
    }

    public void localFileGenerator( int num ) throws Exception
    {
        int max = 10*(2^20) ;  // size of 10M
        int min = 10*(2^10) ;  // sizeof 10K

        String data_path  = ConfigInfo.PRO_MAIN_PATH +"/Data/";
        Random random = new Random() ;


        for ( int i = 0 ; i < num ; i++ )
        {
            String file_name = ConfigInfo.SERVER_NAME+".data"+Integer.toString(i)+".txt" ;

            // get random long as the random file length
            long random_len = random.nextInt(max)%(max -min +1) + min ;
            byte [] data = new byte[(int)random_len] ;

            File file = new File ( data_path + file_name) ;

            if ( file.exists() )  file.delete () ;

            file.createNewFile() ;

            BufferedWriter buf = new BufferedWriter( new FileWriter (file)) ;

            buf.write( new String (data));
            buf.newLine();
            buf.write("You are the best!") ; // end of the file

            buf.flush() ;
            buf.close () ;
        }
    }
}
