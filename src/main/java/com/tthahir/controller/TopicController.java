package com.tthahir.controller;

import com.tthahir.entity.Topic;
import com.tthahir.exception.ResourceNotFoundException;
import com.tthahir.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopicController {

  private final TopicService topicService;

  @GetMapping("/")
  public String homepage() {
    return "Hai! welcome to our website. click here to to see all topics available in this website";
  }

  @GetMapping("/topics")
  public List<Topic> getAllTopics() {
    return topicService.getAllTopics();
  }

  @GetMapping("/topics/{id}")
  public Topic getTopic(@PathVariable int id) {
    return topicService
        .getTopic(id)
        .orElseThrow(() -> new ResourceNotFoundException("not found" + id));
  }

  @PostMapping("/topics")
  public String addTopic(@RequestBody Topic topic) {
    return topicService.addTopic(topic);
  }

  @PutMapping("topics/{id}")
  public String updateTopic(@RequestBody Topic topic, @PathVariable int id) {
    return topicService.updateTopic(topic, id);
  }

  @DeleteMapping("/topics/{id}")
  public String deleteTopic(@PathVariable int id) {
    return topicService.deleteTopic(id);
  }
}
