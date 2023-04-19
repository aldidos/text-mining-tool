package jikim.textmining.topicmodeling;

import java.util.HashMap;
import java.util.Map;

public class DocTopicDist 
{
    String documentName;
    double[] topicDist;

    public DocTopicDist(String documentName, double[] topicDist)
    {
        this.documentName = documentName;
        this.topicDist = topicDist;
    }

    public String getDocumentName()
    {
        return documentName;
    }    

    public Map<Integer, Double> findSuitableTopics(double criteria)
    {
        Map<Integer, Double> mapSuitableTopics = new HashMap<Integer, Double>();
        for( int topic = 0; topic < topicDist.length; topic++ )
        {
            if( topicDist[topic] >= criteria ) 
                mapSuitableTopics.put(topic, topicDist[topic]);
        }

        return mapSuitableTopics;
    }
    
    public Integer findBestTopic()
    {
        int topic = 0;

        for( int i = 1; i < topicDist.length; i++)
        {
            if( topicDist[topic] < topicDist[i] )
            {
                topic = i;
            }
        }

        return topic;
    }

}
