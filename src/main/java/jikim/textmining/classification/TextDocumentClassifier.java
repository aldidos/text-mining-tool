package jikim.textmining.classification;

import cc.mallet.classify.Classification;
import cc.mallet.classify.Classifier;
import cc.mallet.types.Instance;

public class TextDocumentClassifier 
{
    Classifier classifier;
    
    public TextDocumentClassifier(Classifier classifier)
    {
        this.classifier = classifier;
    }

    public Classification classify(Instance instance)
    {
        return classifier.classify(instance);
    }

    public Classifier getClassifier()
    {
        return this.classifier;
    }
}
