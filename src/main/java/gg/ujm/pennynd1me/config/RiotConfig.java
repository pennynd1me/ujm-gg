package gg.ujm.pennynd1me.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "riot.api")
public class RiotConfig {

    private String url;

    @Value("${riot.api.token}")
    private String token;
}
