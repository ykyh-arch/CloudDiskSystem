package uetec.filesystem.ui.callback;

import java.util.List;

import uetec.filesystem.server.enumeration.*;
import uetec.filesystem.ui.pojo.FileSystemPath;

public interface GetServerStatus
{
    int getPropertiesStatus();
    
    boolean getServerStatus();
    
    int getPort();
    
    String getInitProt();
    
    int getBufferSize();
    
    String getInitBufferSize();
    
    LogLevel getLogLevel();
    
    LogLevel getInitLogLevel();
    
    VCLevel getVCLevel();
    
    VCLevel getInitVCLevel();
    
    String getFileSystemPath();
    
    String getInitFileSystemPath();
    
    boolean getMustLogin();
    
    List<FileSystemPath> getExtendStores();
}
