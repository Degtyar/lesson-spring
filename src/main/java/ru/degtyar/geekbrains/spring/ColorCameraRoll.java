package ru.degtyar.geekbrains.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component(ColorCameraRoll.NAME)
public class ColorCameraRoll implements CameraRoll {

    public static final String NAME = "ColorCameraRoll";
    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}
