package com.rogomdi.template.application.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@GraphQlTest(TestController.class)
class TestControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void get() {
        var id = UUID.randomUUID();
        var query = """
                query myQuery($id: ID!){
                  getEntity(id:$id){
                    id
                    field
                  }
                }
                """;
        graphQlTester.document(query)
                .variable("id", id)
                .execute()
                .path("getEntity.id").entity(UUID.class).isEqualTo(id)
                .path("getEntity.field").entity(String.class).isEqualTo("test");
    }

    @Test
    void put() {
        var id = UUID.randomUUID();
        var newValue = "newValue";
        var query = """
                mutation put($id: ID!, $newField: String!){
                  updateEntity(id:$id, field: $newField){
                    id
                    field
                  }
                }
                """;
        graphQlTester.document(query)
                .variable("id", id)
                .variable("newField", newValue)
                .execute()
                .path("updateEntity.id").entity(UUID.class).isEqualTo(id)
                .path("updateEntity.field").entity(String.class).isEqualTo(newValue);
    }
}