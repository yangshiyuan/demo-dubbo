package ysy.config;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Constants {

    private static List<Resource> configurationProperties;

    static {
        configurationProperties = getProperties();
    }

    private static List<Resource> getProperties() {
        List<Resource> allOfResources = new LinkedList<Resource>();

        try {
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver
                    = new PathMatchingResourcePatternResolver();

            Resource[] resources = pathMatchingResourcePatternResolver
                    .getResources("classpath*:config/*.properties");

            allOfResources.addAll(Arrays.asList(resources));

            String userHome = System.getProperty("user.home");

            String customizedConfigurationPath = userHome + File.separator + ".config";

            for (Resource resource : resources) {
                FileSystemResource fileSystemResource
                        = new FileSystemResource(customizedConfigurationPath + "/" + resource.getFilename());

                if (fileSystemResource.exists()) {
                    allOfResources.add(fileSystemResource);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read context properties, " + e.getMessage(), e);
        }

        return allOfResources;
    }

    public static List<Resource> getConfigurationProperties() {
        return configurationProperties;
    }

}
