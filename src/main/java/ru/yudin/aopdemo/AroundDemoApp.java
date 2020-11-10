package ru.yudin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.yudin.aopdemo.dao.AccountDAO;
import ru.yudin.aopdemo.service.TrafficFortuneService;

import java.util.List;


public class AroundDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("main app running");

        String name = fortuneService.getFortune();

        System.out.println("fortune service run" );

        System.out.println("name = " + name);

        System.out.println("finished");

        context.close();

    }

}
