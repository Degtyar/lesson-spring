package ru.degtyar.geekbrains.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.degtyar.geekbrains.spring.configuration.DataSourceConfiguration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.degtyar.geekbrains.spring")
@Import(DataSourceConfiguration.class)
public class AppConfigCamera {

    @Bean(name = "camera")
    public Camera camera(CameraRoll  cameraRoll) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
