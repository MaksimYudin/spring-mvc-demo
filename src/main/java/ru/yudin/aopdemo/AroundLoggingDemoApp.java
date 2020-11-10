package ru.yudin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yudin.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;


public class AroundLoggingDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundLoggingDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("main app running");

        String name = fortuneService.getFortune();

        myLogger.info("fortune service run" );

        myLogger.info("name = " + name);

        myLogger.info("finished");

        context.close();

    }

}
