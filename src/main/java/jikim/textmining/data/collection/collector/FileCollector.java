package jikim.textmining.data.collection.collector;

import java.nio.file.Path;

public interface FileCollector 
{    
    public boolean isTargetFile( Path file );
    public void collect( Path file );
}
