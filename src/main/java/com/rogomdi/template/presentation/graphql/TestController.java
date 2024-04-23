package com.rogomdi.template.presentation.graphql;

import com.rogomdi.template.presentation.model.Entity;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
public class TestController {

    @QueryMapping
    public Mono<Entity> getEntity(@Argument UUID id) {
        return Mono.just(new Entity(id,"test"));
    }

    @MutationMapping
    public Mono<Entity> updateEntity(@Argument UUID id, @Argument String field) {
        return Mono.just(new Entity(id,field));
    }
}
