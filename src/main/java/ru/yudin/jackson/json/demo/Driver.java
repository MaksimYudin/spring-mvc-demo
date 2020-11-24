package ru.yudin.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            File file = new File("data/sample-full.json");
            System.out.println(file.exists());
            Student student = mapper.readValue(file, Student.class);

            System.out.println("first name = " + student.getFirstName());
            System.out.println("last name = " + student.getLastName()) ;

            Address address = student.getAddress();
            System.out.println("city: " + address.getCity());

            String[] languages = student.getLanguages();
            for (String language : languages)
                System.out.println(language);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
