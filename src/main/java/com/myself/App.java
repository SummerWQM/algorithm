package com.myself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class App {

    // 同一个类 避开双亲模式， 从而实现一个类被多次加载，实现热部署。
    public static void main(String[] args) {

        // SpringApplication.run(App.class);
        ConfigurableApplicationContext app = new SpringApplication(App.class).run(args);

        ConfigurableEnvironment env = app.getEnvironment();

        String[] profiles = env.getDefaultProfiles();

        for (String profile : profiles) {
            System.out.println(profile);
        }

//        Object object = new Object();
//
//        ClassLoader classLoader = App.class.getClassLoader();
//
//        System.out.println(classLoader.getClass());


    }

    public static class Custom extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            // defineClass(name,data 0,data.length)
            return super.findClass(name);


        }
    }

}
