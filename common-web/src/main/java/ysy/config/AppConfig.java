package ysy.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

@Configuration
@ImportResource({"classpath:spring/spring-context.xml"})
public class AppConfig {

    @Bean
    public static BeanFactoryPostProcessor getBeanFactoryPostProcessor() throws IOException {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
        configurer.setIgnoreResourceNotFound(true);

        List<Resource> allOfResources = Constants.getConfigurationProperties();

        configurer.setLocations(allOfResources.toArray(new Resource[allOfResources.size()]));

        return configurer;
    }
}
