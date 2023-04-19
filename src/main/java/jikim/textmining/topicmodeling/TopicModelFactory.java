package jikim.textmining.topicmodeling;

import java.io.IOException;
import java.nio.file.FileSystems;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.InstanceList;
import jikim.textmining.data.InstanceFactory;
import jikim.textmining.input.TopicModelingOption;

public class TopicModelFactory 
{
    public static TopicModel trainTopicModel( TopicModelingOption option ) throws IOException
    {
        InstanceList instances = InstanceFactory.loadInstances(option.getTrainInstancesFilePath());

        TopicModel topicModel = 
            new TopicModelBuilder()
            .setNumThreads(option.getNumThreads())
            .setNumIteration(option.getNumIteration())
            .setNumTopics(option.getNumTopics())
            .setAlphaSum(option.getAlpha())
            .setbeta(option.getBeta())
            .setTrainingInstances(instances)
            .build();  
            
        topicModel.estimate();

        return topicModel;
    }

    public static TopicModel read(String filePath) throws Exception
    {
        ParallelTopicModel model = ParallelTopicModel.read(FileSystems.getDefault().getPath(filePath).toFile());
        return new TopicModel(model);
    }
    
}
