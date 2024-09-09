package com.backend.pragma_aws_services.crud.domain.repository;

import com.backend.pragma_aws_services.crud.domain.entities.CustomerEntity;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Repository
public class DynamoDbCustomerRepository  {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    private static final String TABLE_NAME = "users";

    public DynamoDbCustomerRepository(DynamoDbClient dynamoDbClient) {
        this.dynamoDbEnhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    public void save(CustomerEntity customer) {
        DynamoDbTable<CustomerEntity> table = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(CustomerEntity.class));
        table.putItem(customer);
    }
}