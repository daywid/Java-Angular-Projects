package br.com.erudio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/*
 * Configuration class for file storage
 */
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {

    private String uploadDir;
    /*
     * Get the upload directory path.
     * @return the upload directory path
     */
    public String getUploadDir() {
        return uploadDir;
    }
    /*
     * Set the upload directory path.
     * @param uploadDir the upload directory path
     */
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }   
}
