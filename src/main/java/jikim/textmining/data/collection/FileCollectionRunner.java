package jikim.textmining.data.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jikim.textmining.data.collection.collector.FileCollector;
import jikim.textmining.data.collection.collector.ReadmeFileCollector;
import jikim.textmining.input.FileCollectionOption;

public class FileCollectionRunner 
{
    FileCollectionOption option;
    
    public FileCollectionRunner( FileCollectionOption option )
    {
        this.option = option;
    }

    public void run() throws IOException
    {
        Path sourceDirPath = Path.of( option.getSourceDir() );
        FileCollector fCollector = createFileCollector();
        Files.walkFileTree(sourceDirPath, new CollectionFileVisitor( fCollector ) );
    }

    private FileCollector createFileCollector() 
    {
        FileCollector fCollector = null;

        switch ( option.getTargetFileType() )
        {
            case FileCollectionOption.TARGET_FILE_TYPE_README : 
                fCollector = new ReadmeFileCollector( option.getTargetDir() );
        }

        return fCollector;
    }
}
