package com.backend.pragma_aws_services.crud.domain.entities;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Data
public class CustomerEntity {

    private String id;
    private String fullName;
    private String documentId;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
