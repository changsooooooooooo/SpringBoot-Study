package com.springbootstudy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootstudy.objectmapper.ObjectUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStudyApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        var objectmapper = new ObjectMapper();

        var objectUser = new ObjectUser("steve", 10, "010-1111-2222");
        var text = objectmapper.writeValueAsString(objectUser);
        System.out.println(text);

        var textUser = objectmapper.readValue(text, ObjectUser.class);
        System.out.println(textUser);
    }

}
