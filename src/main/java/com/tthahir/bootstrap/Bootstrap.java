package com.tthahir.bootstrap;

import com.tthahir.entity.Topic;
import com.tthahir.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

  private final TopicRepository topicRepository;

  @Override
  public void run(String... args) {
    topicRepository.save(Topic.builder().name("java").description("programming language").build());
    topicRepository.save(Topic.builder().name("springboot").description("framework").build());
    topicRepository.save(Topic.builder().name("microservices").description("architecture").build());
  }
}
