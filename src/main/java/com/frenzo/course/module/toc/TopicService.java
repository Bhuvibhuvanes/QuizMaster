package com.frenzo.course.module.toc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

@Service
public class TopicService {
    @Autowired
    TopicRepo topicRepo;

    public List<Topic> getTopics() {
        List<Topic> topics = topicRepo.findAll();
        if (!topics.isEmpty()) {
            return topics;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Topic addTopic(Topic topic) {
        return topicRepo.save(topic);
    }

    public void deleteTopic(int id) {
        topicRepo.deleteById(id);
    }

    public Topic getTopicById(int id) {
        Optional<Topic> topic = topicRepo.findById(id);
        if (topic.isPresent()) {
            return topic.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Topic updateTopic(int id, Topic updatedTopic) {
        return topicRepo.findById(id).map(existingTopic -> {
            updatedTopic.setId(existingTopic.getId());
            return topicRepo.save(updatedTopic);
        }).orElseThrow(() -> new RuntimeException("Topic with ID " + id + " not found"));
    }
}