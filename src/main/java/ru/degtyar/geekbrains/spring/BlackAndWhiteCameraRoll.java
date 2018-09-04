package ru.degtyar.geekbrains.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component(BlackAndWhiteCameraRoll.NAME)
public class BlackAndWhiteCameraRoll implements CameraRoll{

    public static final String NAME = "BlackAndWhiteCameraRoll";
    public void processing(){
        System.out.println("-1 черно-белый кадр");
    }
}
