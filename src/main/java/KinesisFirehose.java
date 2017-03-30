import KinesisFirehosePackage.KinesisClient;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.model.CreateDeliveryStreamRequest;
import com.amazonaws.services.kinesisfirehose.model.ExtendedS3DestinationConfiguration;


/**
 * Created by psenthil on 3/30/17.
 */
public class KinesisFirehose {

    private AmazonKinesisFirehose _kinesisClient;

    public KinesisFirehose() { _kinesisClient = KinesisClient.get_amazonKinesisClient();}


    public boolean createFirehose(String myFirehoseName, String myS3Bucket, String myRoleARN) {

        ExtendedS3DestinationConfiguration extendedS3DestinationConfiguration = new ExtendedS3DestinationConfiguration();
        extendedS3DestinationConfiguration.setBucketARN(myS3Bucket);


        try{
            CreateDeliveryStreamRequest createDeliveryStreamRequest = new CreateDeliveryStreamRequest();
            createDeliveryStreamRequest.setDeliveryStreamName(myFirehoseName);
            createDeliveryStreamRequest.setExtendedS3DestinationConfiguration(extendedS3DestinationConfiguration);
            createDeliveryStreamRequest.setExtendedS3DestinationConfiguration( extendedS3DestinationConfiguration.withRoleARN( myRoleARN ) );
            _kinesisClient.createDeliveryStream(createDeliveryStreamRequest);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }


}

