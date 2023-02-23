package com.jenkins.deployment.example.crud_1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class Crud1ApplicationTests {

    @Test
     contextLoads() {
        log.info("Test case executing with new JENKINS BUILD!!!");
        assertThat(true).isTrue();
    }
}
