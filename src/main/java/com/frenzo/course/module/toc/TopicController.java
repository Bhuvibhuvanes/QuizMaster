package com.frenzo.course.module.toc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
        Topic addedTopic = topicService.addTopic(topic);
        return new ResponseEntity<>(addedTopic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getTopics() {
        List<Topic> topics = topicService.getTopics();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable("id") int id) {
        Topic topic = topicService.getTopicById(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable int id, @RequestBody Topic topic) {
        Topic updatedTopic = topicService.updateTopic(id, topic);
        return new ResponseEntity<>(updatedTopic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTopic(@PathVariable int id) throws NotFoundException {
        topicService.deleteTopic(id);
        return HttpStatus.OK;
    }
}