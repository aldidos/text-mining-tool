package jikim.textmining.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.CharSequenceLowercase;
import cc.mallet.pipe.FeatureSequence2FeatureVector;
import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.pipe.TokenSequenceRemoveNonAlpha;
import cc.mallet.pipe.TokenSequenceRemoveStopwords;
import cc.mallet.util.CharSequenceLexer;

public class PipeBuilder 
{
    List<Pipe> pipes;

    public PipeBuilder(){
        this.pipes = new ArrayList<Pipe>();
    }

    public PipeBuilder addInput2CharSequencePipe(String encoding)
    {
        pipes.add( new Input2CharSequence(encoding) );
        return this;
    }

    public PipeBuilder addCharSequenceLowercase()
    {
        pipes.add( new CharSequenceLowercase() ); 
        return this;
    }

    public PipeBuilder addCharSequence2TokenSequence(Pattern lexer)
    {
        pipes.add( new CharSequence2TokenSequence( lexer ) );
        return this;
    }

    public PipeBuilder addTokenSequenceRemoveStopWords(File stopListFile, String encoding, boolean includeDefault, boolean caseSensitive, boolean markDeletions)
    {
        pipes.add( new TokenSequenceRemoveStopwords(stopListFile, encoding, includeDefault, caseSensitive, markDeletions) );
        return this;
    }

    public PipeBuilder addTokenSequence2FeatureSequence()
    {
        pipes.add( new TokenSequence2FeatureSequence() );
        return this;
    }

    public PipeBuilder addTarget2Label()
    {
        pipes.add( new Target2Label() );
        return this;
    }

    public PipeBuilder addFeatureSequence2FeatureVector()
    {
        pipes.add( new FeatureSequence2FeatureVector() );
        return this;
    }

    public PipeBuilder addTokenSequenceRemoveNonAlpha()
    {
        pipes.add( new TokenSequenceRemoveNonAlpha() );
        return this;
    }

    public Pipe build()
    {
        return new SerialPipes( pipes );
    }

    public static PipeBuilder createBasePipeBuilder()
    {
        return new PipeBuilder()
        .addInput2CharSequencePipe("UTF-8")
        .addCharSequenceLowercase()
        .addCharSequence2TokenSequence( CharSequenceLexer.LEX_WORDS )
        .addTokenSequenceRemoveNonAlpha()
        .addTokenSequenceRemoveStopWords( new File("./stoplists/en.txt"), "UTF-8", false, false, false )
        .addTokenSequence2FeatureSequence()
        .addTarget2Label()
        ;        
    }

    public static PipeBuilder createBasePipeBuilderWithText2FeatureVectorPipe()
    {
        PipeBuilder pipeBuilder = createBasePipeBuilder();
        pipeBuilder.addFeatureSequence2FeatureVector();
        
        return pipeBuilder;        
    }  
    
}
