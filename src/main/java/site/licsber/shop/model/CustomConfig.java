package site.licsber.shop.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "config")
public class CustomConfig {

    private String imgUploadPath;

}
