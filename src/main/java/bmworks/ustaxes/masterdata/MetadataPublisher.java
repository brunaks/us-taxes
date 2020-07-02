package bmworks.ustaxes.masterdata;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class MetadataPublisher {

    private RabbitMessenger rabbitMessenger;

    public MetadataPublisher(RabbitMessenger rabbitMessenger) {
        this.rabbitMessenger = rabbitMessenger;
    }

    public void execute() throws IOException, URISyntaxException {
        System.out.println("Sending metadata");
        String content = Files.readString(Paths.get(this.getClass().getResource("w4Info.json").toURI()));
        rabbitMessenger.sendMessage("metadata-published", content);
    }
}
