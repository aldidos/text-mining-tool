package jikim.textmining.data.collection.collector;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ReadmeFileCollector implements FileCollector 
{
    String targetDir;

    public ReadmeFileCollector(String targetDir)
    {
        this.targetDir = targetDir;
    }

    @Override
    public boolean isTargetFile(Path file) 
    {        
        return file.getFileName().endsWith("README.md");
    }

    @Override
    public void collect(Path file)
    {
        try 
        {
            String targetPathStr = targetDir + file.getParent().getFileName().toString() + ".txt";
            Path targetPath = FileSystems.getDefault().getPath( targetPathStr );
            Files.copy(file, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
