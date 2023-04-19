package jikim.textmining.classification;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class TextClassificationOption 
{
    public static final String RUN_TYPE_TRAIN_MODEL = "train-model"; //** */

    public static final String CLASSIFIER_TYPE_NAIVE = "NaiveBayes";

    String runType;
    String classifierType;

    String trainInstancePath;
    String testInstancePath; 

    public static TextClassificationOption read(String JSONPath) throws JsonSyntaxException, JsonIOException, IOException
    {
        Gson gson = new Gson();
        return gson.fromJson(Files.newBufferedReader(FileSystems.getDefault().getPath(JSONPath)), TextClassificationOption.class);
    }

}
