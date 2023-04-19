package jikim.textmining;

import jikim.textmining.data.ProcessDataRunner;
import jikim.textmining.data.collection.FileCollectionRunner;
import jikim.textmining.input.AppInputFormat;
import jikim.textmining.input.FileCollectionOption;
import jikim.textmining.input.ProcessDataOption;
import jikim.textmining.input.TopicModelingOption;
import jikim.textmining.topicmodeling.TopicModelingRunner;

public final class App {
    public static void main(String[] args) throws Exception
    {        
        AppInputFormat inputFormat = AppInputFormat.read( args[0] );

        if( inputFormat.isRunDataProcess() )
        {
            new ProcessDataRunner( ProcessDataOption.read( inputFormat.getDataProcessJSONPath() ) ).runProcess();
        }

        if ( inputFormat.isRunTopicModeling() )
        {
            new TopicModelingRunner( TopicModelingOption.read(inputFormat.getTopicModelingOptionJSONPath() ) ).run();
        }       

        if( inputFormat.isRunFileCollection() )
        {
            new FileCollectionRunner( FileCollectionOption.read(inputFormat.getFileCollectionJSONPath()) ).run();
        }
        
    }
}
