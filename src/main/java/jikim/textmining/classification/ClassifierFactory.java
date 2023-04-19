package jikim.textmining.classification;

import cc.mallet.classify.NaiveBayesTrainer;
import cc.mallet.types.InstanceList;

public class ClassifierFactory 
{
    public static TextDocumentClassifier buildBasedOnNaiveBayes(InstanceList trainData)
    {
        NaiveBayesTrainer trainer = new NaiveBayesTrainer();
        return new TextDocumentClassifier( trainer.train(trainData) );
    }
}
