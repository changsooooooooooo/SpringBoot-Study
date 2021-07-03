import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("Q5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        List<Car> list = Collections.singletonList(car1);
        user.setCars(list);
        System.out.println(user);

        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        System.out.println(mapper.readValue(json, User.class));

        JsonNode jsonNode = mapper.readTree(json);
        int _age = jsonNode.get("age").asInt();
        System.out.println(_age);

        ArrayNode arrayNode = (ArrayNode) jsonNode.get("cars");
        List<Car> _cars = mapper.convertValue(arrayNode, new TypeReference<List<Car>>(){});
        System.out.println(_cars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        System.out.println(objectNode.toPrettyString());

    }
}
