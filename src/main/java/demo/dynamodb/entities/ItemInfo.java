package demo.dynamodb.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;

@Builder
@DynamoDBTable(tableName = "ItemInfo")
public class ItemInfo {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    String id;

    @DynamoDBAttribute
    String name;

    @DynamoDBAttribute
    String category;

}