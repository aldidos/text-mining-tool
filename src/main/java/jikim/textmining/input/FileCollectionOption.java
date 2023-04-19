package jikim.textmining.input;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class FileCollectionOption 
{
    public static final String TARGET_FILE_TYPE_README = "README.md";
    public static final String TARGET_FILE_TYPE_TXT = ".txt";
    
    String sourceDir;
    String targetDir;

    String targetFileType;

    public String getSourceDir()
    {
        return sourceDir;
    }

    public String getTargetDir()
    {
        return targetDir;
    }

    public String getTargetFileType()
    {
        return targetFileType;
    }

    public static FileCollectionOption read(String jsonPath) throws IOException
    {
        Reader reader = Files.newBufferedReader(Path.of(jsonPath));
        Gson gson = new Gson();        
        return gson.fromJson( reader , FileCollectionOption.class );
    }
    
}
