package jikim.textmining.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cc.mallet.pipe.Pipe;
import cc.mallet.types.Alphabet;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

public class InstanceFactoryTest 
{
    @Test
    public void testCreateTextFileInstances()
    {
        String dirPath = "./data/readme/";
        Pipe pipe = PipeBuilder.createBasePipeBuilder().build();
        InstanceList instanceList = InstanceFactory.createTextFileInstances(dirPath, pipe);

        assertNotNull(instanceList);
    }
    
}
