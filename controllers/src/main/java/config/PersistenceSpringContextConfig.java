package config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.vfedotov.service_layer")
public class PersistenceSpringContextConfig {
}