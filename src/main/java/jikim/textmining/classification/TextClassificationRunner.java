package jikim.textmining.classification;

import java.nio.file.FileSystems;

import cc.mallet.types.InstanceList;

public class TextClassificationRunner 
{
    TextClassificationOption option;

    public TextClassificationRunner( TextClassificationOption option )
    {
        this.option = option;
    }

    public void run()
    {
        switch( option.runType )
        {
            case TextClassificationOption.RUN_TYPE_TRAIN_MODEL : 
                train();
                break;
        }
    }

    public void train()
    {
        InstanceList instances = InstanceList.load( FileSystems.getDefault().getPath( option.trainInstancePath ).toFile() );
        TextDocumentClassifier textDocClassifier = null ; 

        switch ( option.classifierType )
        {
            case TextClassificationOption.CLASSIFIER_TYPE_NAIVE : 
                textDocClassifier = ClassifierFactory.buildBasedOnNaiveBayes( instances );
                break;
        }        

    }

}
