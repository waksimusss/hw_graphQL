package hwGraphQL.service;

import hwGraphQL.dto.Task;
import java.util.ArrayList;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service {
    public List<Task> todo = new ArrayList<>();

    @MutationMapping
    public Task createTask(@Argument String desc, @Argument String title) {
        Task newTask = new Task(desc, title);
        todo.add(newTask);
        return newTask;
    }

    @QueryMapping
    public List<Task> findAll() {
        return todo;
    }
}
