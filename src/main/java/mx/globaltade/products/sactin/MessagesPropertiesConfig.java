package mx.globaltade.products.sactin;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:messages.properties")
})
public class MessagesPropertiesConfig {
}
