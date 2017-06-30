I setup the project with the gradle init plugin:
gradle init --type java-application

Hanlde IOT things with AWS CLI

setup infrastructure:

http://docs.aws.amazon.com/iot/latest/developerguide/thing-registry.html
- aws iot create-thing --thing-name "JavaAWSiotSerialBridge"
- aws iot create-keys-and-certificate

tear down

// Get all prinicapls attached to a thing
- aws iot list-thing-principals --thing-name JavaAWSiotSerialBridge
- principals=`aws iot list-thing-principals --thing-name JavaAWSiotSerialBridge --query principals[*] --outp
ut text`

- echo ${#principals[@]} // get number of principals

// get all policies attache to a principal
aws iot list-principal-policies --principal <principal>

- aws iot delete-thing --thing-name JavaAWSiotSerialBrid



Run Application
gradle run // see build.gradle for arguments needet to run app

Attaching policy to the used certificate (http://docs.aws.amazon.com/iot/latest/developerguide/pub-sub-policy.html)
I did not really figure out how this works. I used an existing policy, which is automatically created
when you follow the getting started AWS IOT guide.
Needt to find out how to do this programatically using the aws cli.