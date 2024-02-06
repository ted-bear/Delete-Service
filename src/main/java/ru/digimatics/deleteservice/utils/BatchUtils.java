package ru.digimatics.deleteservice.utils;

import ru.digimatics.deleteservice.domain.Car;
import ru.digimatics.deleteservice.domain.Document;
import ru.digimatics.deleteservice.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BatchUtils {

    public static List<Document> create2MillionsDocumentsBefore2005Year() {
        List<Document> documents = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            documents.add(
                    Document.builder()
                            .number(i)
                            .issuanceDate(LocalDateTime.of(2004, 4, 5, 17, 34))
                            .build()
            );
        }

        return documents;
    }

    public static List<Document> create2MillionsDocumentsAfter2005Year() {
        List<Document> documents = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            documents.add(
                    Document.builder()
                            .number(i)
                            .issuanceDate(LocalDateTime.of(2006, 4, 5, 17, 34))
                            .build()
            );
        }

        return documents;
    }

    public static List<Car> create2MillionsCarsBefore2005Year() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            cars.add(
                    Car.builder()
                            .brand("car_brand_" + i)
                            .startExploitationDate(LocalDateTime.of(2004, 4, 5, 17, 34))
                            .build()
            );
        }

        return cars;
    }

    public static List<Car> create2MillionsCarsAfter2005Year() {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            cars.add(
                    Car.builder()
                            .brand("car_brand-" + i)
                            .startExploitationDate(LocalDateTime.of(2006, 4, 5, 17, 34))
                            .build()
            );
        }

        return cars;
    }

    public static List<User> create2MillionsUsersBefore2005Year() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            users.add(
                    User.builder()
                            .username("user_" + i)
                            .registrationDate(LocalDateTime.of(2004, 4, 5, 17, 34))
                            .build()
            );
        }

        return users;
    }

    public static List<User> create2MillionsUsersAfter2005Year() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 2_000_000; i++) {
            users.add(
                    User.builder()
                            .username(i + "_user")
                            .registrationDate(LocalDateTime.of(2006, 4, 5, 17, 34))
                            .build()
            );
        }

        return users;
    }
}
