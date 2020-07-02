package bmworks.ustaxes;

import bmworks.ustaxes.masterdata.MetadataPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStarted(ApplicationStartedEvent event) throws IOException, URISyntaxException {
        MetadataPublisher metadataPublisher = event.getApplicationContext().getBean(MetadataPublisher.class);
        metadataPublisher.execute();
    }
}
