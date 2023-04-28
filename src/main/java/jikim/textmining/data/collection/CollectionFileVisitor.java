package jikim.textmining.data.collection;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import jikim.textmining.data.collection.collector.FileCollector;

public class CollectionFileVisitor extends SimpleFileVisitor<Path> 
{
    FileCollector fileCollector;
    
    public CollectionFileVisitor( FileCollector fileCollector )
    {
        this.fileCollector = fileCollector;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
    {
        if( this.fileCollector.isTargetFile( file ) )
        {
            this.fileCollector.collect(file);
        }

        return FileVisitResult.CONTINUE;
    }
    
}
