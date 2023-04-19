package jikim.textmining.topicmodeling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

public class TopicDistribution 
{
    List<TopicWordDist> listTopicWordDist;
    List<DocTopicDist> listDocTopicDist;
    Set<String> bagWords;

    public TopicDistribution()
    {
        this.listTopicWordDist = new ArrayList<TopicWordDist>();
        this.listDocTopicDist = new ArrayList<DocTopicDist>();
        this.bagWords = new TreeSet<String>();
    }

    public void addBagWords( Object[] words )
    {
        for( Object word : words ) 
        {
            bagWords.add( (String) word );
        }
    }
    
    public void addTopicWordDist( TopicWordDist topicWordDist )
    {
        listTopicWordDist.add( topicWordDist );
    }

    public void addDocTopicDist( DocTopicDist docTopicDist )
    {
        listDocTopicDist.add( docTopicDist );
    }

    public void write(String path) throws IOException
    {
        Gson gson = new Gson();
        JsonWriter writer = new JsonWriter( Files.newBufferedWriter(Paths.get(path)) );
        gson.toJson(this, TopicDistribution.class, writer);
        writer.close();
    }

}
