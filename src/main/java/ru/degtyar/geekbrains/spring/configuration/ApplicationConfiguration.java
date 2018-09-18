package ru.degtyar.geekbrains.spring.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.degtyar.geekbrains.spring.Camera;
import ru.degtyar.geekbrains.spring.CameraImpl;
import ru.degtyar.geekbrains.spring.CameraRoll;

@Configuration
@ComponentScan("ru.degtyar.geekbrains.spring")
@EnableJpaRepositories("ru.degtyar.geekbrains.spring.repository")
@Import(DataSourceConfiguration.class)
public class ApplicationConfiguration {


    @Bean(name = "camera")
    public Camera camera(CameraRoll  cameraRoll) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }

}
