package jikim.textmining.topicmodeling;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.InstanceList;

public class TopicModelBuilder 
{
    int numTopics;
    double alphaSum;
    double beta;
    int numIterations;
    InstanceList trainingInstances;
    int numThreads;

    public TopicModelBuilder() {}

    public TopicModelBuilder setNumTopics(int nTopics)
    {
        this.numTopics = nTopics;
        return this;
    }

    public TopicModelBuilder setAlphaSum(double alphaSum)
    {
        this.alphaSum = alphaSum;
        return this;
    }

    public TopicModelBuilder setbeta(double beta)
    {
        this.beta = beta;
        return this;
    }

    public TopicModelBuilder setNumIteration(int n)
    {
        this.numIterations = n;
        return this;
    }

    public TopicModelBuilder setTrainingInstances(InstanceList instanceList)
    {
        this.trainingInstances = instanceList;
        return this;
    }

    public TopicModelBuilder setNumThreads(int n)
    {
        this.numThreads = n;
        return this;
    }

    public TopicModel build()
    {
        ParallelTopicModel topicModel = new ParallelTopicModel(numTopics, alphaSum, beta);

        topicModel.setNumIterations(numIterations);
        topicModel.setNumThreads(numThreads);
        topicModel.addInstances(trainingInstances);

        return new TopicModel( topicModel ) ;
    }

}
