package demo.dynamodb.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
        (basePackages = "demo.dynamodb.repositories")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    String endpoint;

    @Value("{amazon.aws.accesskey}")
    String accessKey;

    @Value("{amazon.aws.secretkey}")
    String secretkey;

    @Bean
    AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, "us-west-2"))
                .build();
        return amazonDynamoDB;
    }

    @Bean
    AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(accessKey, secretkey);
    }
}
