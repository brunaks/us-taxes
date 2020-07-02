package bmworks.ustaxes.masterdata;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessenger {

    private RabbitTemplate rabbitTemplate;

    public RabbitMessenger(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String routingKey, Object message) {
        rabbitTemplate.convertAndSend("amq.topic", routingKey, message);
    }
}
