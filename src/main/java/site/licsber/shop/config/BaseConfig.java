package site.licsber.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.licsber.shop.controller.V1RestController;
import site.licsber.shop.model.CustomConfig;

@Configuration
public class BaseConfig implements WebMvcConfigurer {

    final CustomConfig customConfig;

    public BaseConfig(CustomConfig customConfig) {
        this.customConfig = customConfig;
    }

    // https://www.codecocoa.com/t/6168?np=20
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api/v1", c -> c.isAnnotationPresent(V1RestController.class));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:" + customConfig.getImgUploadPath() + "/");
    }
}
