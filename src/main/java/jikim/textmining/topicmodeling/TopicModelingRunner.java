package jikim.textmining.topicmodeling;

import java.io.IOException;
import java.nio.file.FileSystems;

import jikim.textmining.input.TopicModelingOption;

public class TopicModelingRunner 
{
    TopicModelingOption option;

    public TopicModelingRunner(TopicModelingOption option)
    {
        this.option = option;
    }

    public void run() throws Exception
    {
        switch ( option.getRunType() )
        {
            case TopicModelingOption.RUN_TYPE_TRAIN : 
                train();
                break;
            
            case TopicModelingOption.RUN_TYPE_GET_TOPIC_MODEL_DISTRIBUTION : 
                writeTopicModelDist();
                break;
        }        
    }

    private void train() throws IOException
    {
        TopicModel topicModel = TopicModelFactory.trainTopicModel(option);
        
        topicModel.write( FileSystems.getDefault().getPath( option.getModelOutputPath() ).toFile() );        
    }

    private void writeTopicModelDist() throws Exception
    {
        TopicModel tModel = TopicModelFactory.read( option.getModelInputPath() );
        int topWords = option.getNumTopWords();
        TopicDistribution tDist = tModel.getTopicDistribution(topWords);
        tDist.write(option.getTopicDistOutputPath());
    }
    
}
