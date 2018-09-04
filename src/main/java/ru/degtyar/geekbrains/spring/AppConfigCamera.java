package ru.degtyar.geekbrains.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.degtyar.geekbrains.spring")
public class AppConfigCamera {

    @Bean(name = "camera")
    public Camera camera(CameraRoll  cameraRoll) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
