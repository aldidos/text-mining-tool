package jikim.textmining.util;

import java.util.HashMap;
import java.util.Map;

public class Frequency 
{
    Map<Object, Integer> mapFreq;

    public Frequency()
    {
        this.mapFreq = new HashMap<Object, Integer>();
    }

    public void add(Object o)
    {
        Integer freq = mapFreq.get(o);
        if( freq == null ) 
        {
            freq = 0;
        }
        freq++;
        mapFreq.put(o, freq);
    }

    public Map<Object, Integer> get()
    {
        return mapFreq;
    }    
}
