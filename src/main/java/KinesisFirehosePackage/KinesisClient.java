package KinesisFirehosePackage;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClientBuilder;

/**
 * Created by psenthil on 3/30/17.
 */
public class KinesisClient {
    private static AmazonKinesisFirehoseClientBuilder _amazonKinesisFirehoseClient;
    private static KinesisClient _kinesisClient = new KinesisClient();

    private KinesisClient() {
        _amazonKinesisFirehoseClient = AmazonKinesisFirehoseClientBuilder.standard()
                .withRegion(Regions.US_EAST_1);
    }

    public static AmazonKinesisFirehose get_amazonKinesisClient() {return _amazonKinesisFirehoseClient.build();}



}
