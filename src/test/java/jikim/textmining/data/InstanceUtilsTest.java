package jikim.textmining.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import cc.mallet.pipe.Pipe;
import cc.mallet.types.InstanceList;
import jikim.textmining.util.Frequency;

public class InstanceUtilsTest 
{
    InstanceList instanceList;

    @Before
    public void createInstanceList()
    {
        String dirPath = "./data/testing/";
        Pipe pipe = PipeBuilder.createBasePipeBuilder().build();         
        this.instanceList = InstanceFactory.createTextFileInstances(dirPath, pipe);
    }

    @Test
    public void testGetWords()
    {
        Set<Object> setWords = InstanceUtils.getWords(instanceList);
        String word = "neural";
        boolean b = setWords.contains(word);
        assertTrue(b);
        printWords(setWords);
    }

    @Test
    public void testGetWordFreq()
    {
        Frequency freq = InstanceUtils.getWordFreq(instanceList);
        assertEquals(33, freq.get().size() );
        printFreq(freq);
    }

    private void printFreq(Frequency f)
    {
        for( Map.Entry<Object, Integer> e :  f.get().entrySet() ) 
        {
            System.out.println( e.getKey() + "\t" + e.getValue() );
        }
    }

    private void printWords(Set<Object> setWords)
    {
        for ( Object w : setWords ) 
        {
            System.out.println(w);
        }
    }
    
}
