package jikim.textmining.topicmodeling;

import java.io.File;
import java.io.IOException;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicAssignment;
import cc.mallet.types.Instance;

public class TopicModel 
{
    ParallelTopicModel topicModel;

    public TopicModel(ParallelTopicModel topicModel)
    {
        this.topicModel = topicModel;
    }

    public TopicDistribution getTopicDistribution(int nTopWords)
    {
        TopicDistribution topicDistribution = new TopicDistribution();

        for( TopicAssignment topicAsgn : topicModel.getData() )
        {            
            String documentName = topicAsgn.instance.getName().toString();            
            double[] topicDist = topicModel.getTopicProbabilities( topicAsgn.topicSequence );
            topicDistribution.addDocTopicDist( new DocTopicDist( documentName, topicDist ) );
        }
        
        Object[][] topicWords = this.topicModel.getTopWords(nTopWords);
        for( int topic = 0; topic < topicModel.getNumTopics(); topic++ )
        {
            topicDistribution.addBagWords( topicWords[ topic ] );
            topicDistribution.addTopicWordDist( new TopicWordDist(topic, topicWords[ topic ] ) );            
        }

        return topicDistribution;
    }

    public Object[][] getTopicTopWords(int numWords)
    {
        return topicModel.getTopWords(numWords);
    }

    public void estimate() throws IOException
    {
        topicModel.estimate();
    }

    public TopicDistribution infer(Instance document)  //** */
    {
        return null;
    }

    public void write(File file)
    {
        this.topicModel.write(file);
    }

}
