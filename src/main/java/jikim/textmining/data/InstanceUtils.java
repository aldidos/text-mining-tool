package jikim.textmining.data;

import java.util.HashSet;
import java.util.Set;

import cc.mallet.types.Alphabet;
import cc.mallet.types.InstanceList;
import jikim.textmining.util.Frequency;

public class InstanceUtils 
{
    public static Set<Object> getWords(InstanceList instanceList)
    {
        Alphabet alphabet = instanceList.getAlphabet();
        Set<Object> setWords = new HashSet<Object>();
		for ( int id = 0; id < alphabet.size() ; id++ )
        {
            Object word = alphabet.lookupObject(id);
            setWords.add(word);            
        }
        return setWords;
    }

    public static Frequency getWordFreq(InstanceList instanceList)
    {
        Alphabet alphabet = instanceList.getAlphabet();
        Frequency wordFreq = new Frequency();
		for ( int id = 0; id < alphabet.size() ; id++ )
        {
            Object word = alphabet.lookupObject(id);
            wordFreq.add(word);
        }
        return wordFreq;
    }


    
}
