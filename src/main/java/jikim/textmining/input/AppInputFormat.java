package jikim.textmining.input;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class AppInputFormat 
{    
    public static String RUN_COMMAND_TOPIC_MODELING = "topic-modeling";
    public static String RUN_COMMAND_PROCESS_DATA = "process-data";
    public static String RUN_COMMAND_FILE_COLLECTION = "file-collection";

    String dataSetPath;    
    String runCommand; //** a run command in the set of run commands { create-instances, topic-modeling} */
    String createInstanceOptionJSONPath; 
    String dpOptionJSONPath; //** Data process option JSON file path */
    String tmOptionJSONPath; //** Topic modeling option JSON file path */
    String fcOptionJSONPath; 

    private boolean isRunCommand(String runCommand)
    {
        return this.runCommand.equals(runCommand);
    }

    public boolean isRunTopicModeling()
    {
        return isRunCommand(RUN_COMMAND_TOPIC_MODELING);
    }

    public boolean isRunDataProcess()
    {
        return isRunCommand( RUN_COMMAND_PROCESS_DATA );
    }

    public boolean isRunFileCollection()
    {
        return isRunCommand( RUN_COMMAND_FILE_COLLECTION );
    }

    public String getTopicModelingOptionJSONPath()
    {
        return tmOptionJSONPath;
    }

    public String getDataProcessJSONPath()
    {
        return dpOptionJSONPath;
    }

    public String getFileCollectionJSONPath()
    {
        return fcOptionJSONPath;
    }

    public static AppInputFormat read(String jsonFilePath) throws IOException
    {
        Reader reader = Files.newBufferedReader( Path.of(jsonFilePath) );
        Gson gson = new Gson();
        return gson.fromJson(reader, AppInputFormat.class);
    }
    
}
