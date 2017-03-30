/**
 * Created by psenthil on 3/30/17.
 */


public class Main {

    public static void main (String[] args){
        String myFirehoseName = "SdKFireHose";
        String myS3Buck = "arn:aws:s3:::firehose-change-s3-001";
        String myRoleArn = "arn:aws:iam::086043250494:role/firehose_sdk_delivery_role";
        KinesisFirehose kinesisFirehose = new KinesisFirehose();
        boolean output = kinesisFirehose.createFirehose(myFirehoseName,myS3Buck,myRoleArn);
        if(output)
        {
            System.out.println("KinesisFirehose Created sucessfully" + myFirehoseName);
        }

    }
}
