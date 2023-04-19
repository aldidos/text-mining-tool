package jikim.textmining.input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

public class TopicModelingOption 
{   
    public static final String RUN_TYPE_TRAIN = "train";
    public static final String RUN_TYPE_INFERENCE = "inference";
    public static final String RUN_TYPE_GET_TOPIC_MODEL_DISTRIBUTION = "get-topic-distribution";

    private int numThreads;
    private int numIteration;
    private int numTopics;    
    private double alpha;
    private double beta;

    String runType; //** {train, inference} */
    
    private String trainInstancesFilePath;
    String testInstancesFilePath;

    String modelInputPath;
    private String modelOutputPath;

    String inputModelPath;
    int numTopWords;
    String outputDistPath;     

    public static TopicModelingOption read(String jsonPath) throws FileNotFoundException
    {
        Gson gson = new Gson();
        Reader reader = new FileReader(jsonPath);
        return gson.fromJson(reader, TopicModelingOption.class);
    }

    public boolean isRunTypeTrain()
    {
        return runType.equals(RUN_TYPE_TRAIN);
    }

    public boolean isRunTypeInference()
    {
        return runType.equals(RUN_TYPE_INFERENCE);
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public int getNumTopics() {
        return numTopics;
    }

    public void setNumTopics(int numTopics) {
        this.numTopics = numTopics;
    }

    public int getNumIteration() {
        return numIteration;
    }

    public void setNumIteration(int numIteration) {
        this.numIteration = numIteration;
    }

    public int getNumThreads() {
        return numThreads;
    }

    public void setNumThreads(int numThreads) {
        this.numThreads = numThreads;
    }

    public String getTrainInstancesFilePath() {
        return trainInstancesFilePath;
    }

    public void setTrainInstancesFilePath(String trainInstancesFilePath) {
        this.trainInstancesFilePath = trainInstancesFilePath;
    }

    public String getModelInputPath()
    {
        return this.modelInputPath;
    }

    public String getModelOutputPath() {
        return modelOutputPath;
    }

    public void setModelOutputPath(String modelOutputPath) {
        this.modelOutputPath = modelOutputPath;
    }

    public String getRunType() {
        return this.runType;
    }

    public int getNumTopWords() {
        return this.numTopWords;
    }

    public String getTopicDistOutputPath() {
        return this.outputDistPath;
    }
}