package jikim.textmining.input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

public class ProcessDataOption 
{
    public static final String PROCESS_TYPE_MAKE_INSTANCES = "makeInstances";
    
    public static final String PIPE_TYPE_FROM_TEXT_2_FEATURESEQUENCE = "fromText2FeatureSequence";
    public static final String PIPE_TYPE_FROM_TEXT_2_FEATUREVECTOR = "fromText2FeatureVector";

    private String inputDocumentPath;
    private String path2MakedInstances;

    private String processType; 
    private String pipeType;

    public static ProcessDataOption read(String jsonPath) throws FileNotFoundException
    {
        Reader reader = new FileReader(jsonPath);
        Gson gson = new Gson();        
        return gson.fromJson(reader, ProcessDataOption.class);
    }

    public String getPipeType() {
        return pipeType;
    }

    public void setPipeType(String pipeType) {
        this.pipeType = pipeType;
    }

    public String getPath2MakedInstances() {
        return path2MakedInstances;
    }

    public void setPath2MakedInstances(String path2MakedInstances) {
        this.path2MakedInstances = path2MakedInstances;
    }

    public String getInputDocumentPath() {
        return inputDocumentPath;
    }

    public void setInputDocumentPath(String inputDocumentPath) {
        this.inputDocumentPath = inputDocumentPath;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

}
