package jikim.textmining.data;

import java.nio.file.FileSystems;

import cc.mallet.pipe.Pipe;
import cc.mallet.types.InstanceList;
import jikim.textmining.input.ProcessDataOption;

public class ProcessDataRunner 
{
    ProcessDataOption options;

    public ProcessDataRunner( ProcessDataOption options )
    {
        this.options = options;
    }

    public void runProcess()
    {
        switch ( options.getProcessType() )
        {
            case ProcessDataOption.PROCESS_TYPE_MAKE_INSTANCES :
                makeInstance();
                break;
        }
    }
    
    public void makeInstance()
    {
        Pipe pipe = initPipe();
        InstanceList instanceList = InstanceFactory.createTextFileInstances(options.getInputDocumentPath(), pipe);
        instanceList.save(FileSystems.getDefault().getPath( options.getPath2MakedInstances() ).toFile());
    }

    private Pipe initPipe() 
    {
        Pipe pipe = null;
        
        switch (options.getPipeType())
        {
            case ProcessDataOption.PIPE_TYPE_FROM_TEXT_2_FEATURESEQUENCE : 
                pipe = PipeBuilder.createBasePipeBuilder().build();
                break;
            case ProcessDataOption.PIPE_TYPE_FROM_TEXT_2_FEATUREVECTOR : 
                pipe = PipeBuilder.createBasePipeBuilderWithText2FeatureVectorPipe().build();
                break;
        }

        return pipe;
    }   
    
}
