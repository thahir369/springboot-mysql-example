package com.tthahir.service;

import com.tthahir.entity.Topic;
import com.tthahir.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {

  private final TopicRepository topicRepository;

  public List<Topic> getAllTopics() {
    return topicRepository.findAll();
  }

  public Optional<Topic> getTopic(int id) {
    if (!topicRepository.findById(id).isPresent())
      throw new RuntimeException("topic with id " + id + " is not found");
    else return topicRepository.findById(id);
  }

  public String addTopic(Topic topic) {
    topicRepository.save(topic);
    return ("topic with name" + topic.getName() + " added successfully");
  }

  public String updateTopic(Topic topic, int id) {
    topicRepository.save(topic);
    return ("topic with id " + topic.getId() + " updated successfully");
  }

  public String deleteTopic(int id) {
    topicRepository.deleteById(id);
    return ("topic with " + id + " deleted successfully");
  }
}
