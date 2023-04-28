package jikim.textmining.data;

import java.nio.file.FileSystems;

import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.iterator.FileIterator;
import cc.mallet.types.InstanceList;

public class InstanceFactory 
{
    public static InstanceList createTextFileInstances(String dirPath, Pipe pipe)
    {
        FileIterator fileIter = new FileIterator(dirPath, FileIterator.LAST_DIRECTORY);

        InstanceList instanceList = new InstanceList(pipe);
        instanceList.addThruPipe(fileIter);

        return instanceList;
    }

    public static InstanceList loadInstances(String path)
    {
        return InstanceList.load( FileSystems.getDefault().getPath(path).toFile() ) ;
    }
}
