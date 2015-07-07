package org.kylin.zhang.p2pNetwork.peer.util;

/**
 * Created by root on 7/7/15.
 */
public class FileNode
{
    String fileAbPath ;
    long   fileLength ;

    int    process ;
    int    time ;

    boolean isLocal ;

    public FileNode(String filepath , long fileLength , boolean isLocal  )
    {
        this.fileAbPath = filepath ;
        this.fileLength = fileLength ;
        this.isLocal = isLocal ;
        this.time = 0 ;
        this.process = 0 ;
    }
    public FileNode ( String filePath , long fileLength , boolean isLocal , int process , int time)
    {
        this.fileAbPath = filePath ;
        this.fileLength = fileLength ;
        this.isLocal = isLocal ;
        this.process = process ;
        this.time = time ;
    }

    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder() ;

        sb.append("file ab path  ").append(this.fileAbPath)
                .append("\nfile size  ").append(this.fileLength)
                .append("\nfile_local ?  ").append(this.isLocal)
                .append("\ntime ").append(this.time)
                .append("\nprocess ").append(this.process) ;
        return sb.toString() ;
    }

}
