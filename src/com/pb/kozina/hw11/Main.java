package com.pb.kozina.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.kozina.hw9.FileNumbers;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Scanner scan = new Scanner(System.in);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        List<PhoneNumber> persons = new ArrayList<>( Arrays.asList(
                new PhoneNumber("Иванов Иван Иванович",
                        LocalDate.of(2000, 3, 5),
                        "380671111111",
                        "Большая Васильковская, 12, 3",
                        LocalDate.now()
                ),
                new PhoneNumber("Петров Петр Петрович",
                        LocalDate.of(2001, 5, 22),
                        "380672222222",
                        "Большая Житомирская, 24, 7",
                        LocalDate.now()
                ),
                new PhoneNumber("Андриенко Андрей Андреевич",
                        LocalDate.of(1995, 10, 27),
                        "380673333333",
                        "Оболонский проспект, 7, 103",
                        LocalDate.now()
                ),
                new PhoneNumber("Васильев Василий Васильевич",
                        LocalDate.of(1991, 6, 12),
                        "380674444444",
                        "Голосеевский проспект, 21, 35",
                        LocalDate.now()
                ),
                new PhoneNumber("Сергеенко Сергей Сергеевич",
                        LocalDate.of(1989, 11, 25),
                        "380675555555",
                        "Маяковского, 26, 128",
                        LocalDate.now()
                ),
                new PhoneNumber("Максименко Максим Максимович",
                        LocalDate.of(1999, 8, 24),
                        "380676666666",
                        "Ковпака, 29, 4",
                        LocalDate.now()
                )
        ));

        // добавление элемента
        System.out.println("ТЕЛЕФОННАЯ КНИГА");
        System.out.println("можете добавить в справочник абонента");
        System.out.println("Введите ФИО абонента");
        String FIO = scan.nextLine();
        System.out.println("Введите дату рождения абонента в формате YYYY-MM-DD");
        String dB = scan.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dB);
        System.out.println("Введите телефон абонента");
        String phone = scan.nextLine();
        System.out.println("Введите адрес абонента");
        String adress = scan.nextLine();
        persons.add(new PhoneNumber(FIO, dateOfBirth, phone, adress, LocalDate.now()));

       String personsJson = mapper.writeValueAsString(persons.get(persons.size()-1));
       System.out.println("В телефонную книгу добавлен новый абонент" + personsJson);
       System.out.println("---------------------");

        // удаление элемента
        System.out.println("Хотите удалить абонента");
        System.out.println("Укажите ФИО абонента");
        FIO = scan.nextLine();

        for (PhoneNumber p: persons) {
            if (p.getFIO().equals(FIO)) {
                personsJson = mapper.writeValueAsString(p);
                System.out.println("Из телефонной книги удаляется абонент" + personsJson);;
                persons.remove(p);
                break;
            }
        }

        personsJson = mapper.writeValueAsString(persons);
        System.out.println("Телефонная книга после удаления элемента" + personsJson);
        System.out.println("---------------------");

        //  поиск телефона
        System.out.println("Найти телефон по ФИО");
        FIO = scan.nextLine();
        for (PhoneNumber p: persons) {
            if (p.getFIO().equals(FIO)) {
                personsJson = mapper.writeValueAsString(p);
                System.out.println("В телефонной книге найден абонент" + personsJson);;
                break;
            }
        }

        System.out.println("Найти телефон по адресу");
        adress = scan.nextLine();
        for (PhoneNumber p: persons) {
            if (p.getAdress().equals(adress)) {
                personsJson = mapper.writeValueAsString(p);
                System.out.println("В телефонной книге найден абонент" + personsJson);;
                break;
            }
        }

        System.out.println("Найти телефон по ФИО и дате рождения");
        System.out.println("Введит ФИО");
        FIO = scan.nextLine();
        System.out.println("Введит дату рождения");
        dB = scan.nextLine();
        dateOfBirth = LocalDate.parse(dB);
        for (PhoneNumber p: persons) {
            if (p.getFIO().equals(FIO) && p.getDateOfBirth().equals(dateOfBirth)) {
                personsJson = mapper.writeValueAsString(p);
                System.out.println("В телефонной книге найден абонент" + personsJson);
                break;
            }
        }

        // вывод всех записей с сортировкой по указанному полю
        // сортировка по алфавиту ФИО
        System.out.println("Сортировка по ФИО");

        persons.sort(comparing(PhoneNumber::getFIO).thenComparing(PhoneNumber::getAdress));
        personsJson = mapper.writeValueAsString(persons);
        System.out.print("Телефонная книга после сортировки по ФИО" + personsJson);

        // сортировка по нескольким полям:
        System.out.println("Сортировка по ФИО и адресу");

        persons.sort(comparing(PhoneNumber::getFIO).thenComparing(PhoneNumber::getAdress));
        personsJson = mapper.writeValueAsString(persons);
        System.out.print("Телефонная книга после сортировки по ФИО и адресу" + personsJson);

        // редактирование абонента

        System.out.println("Введите номер телефона абонента, которого необходимо отредактировать");
        phone = scan.nextLine();
        for (PhoneNumber p: persons) {
            if (p.getPhone().equals(phone)) {
                personsJson = mapper.writeValueAsString(p);
                System.out.println("В телефонной книге найден абонент" + personsJson);;
                System.out.println("ФИО абонента " + p.getFIO() + ", введите правильное ФИО");
                FIO = scan.nextLine();
                System.out.println("Дата рождения абонента " + p.getDateOfBirth() + " , введите правильное ДР в формате YYYY-MM-DD");
                dB = scan.nextLine();
                dateOfBirth = LocalDate.parse(dB);
                System.out.println("Телефон абонента " + p.getPhone() + ", введите правильный телефон");
                phone = scan.nextLine();
                System.out.println("Адрес абонента " + p.getAdress() + ", введите правильный адрес");
                adress = scan.nextLine();
                p.setFIO(FIO);
                p.setDateOfBirth(dateOfBirth);
                p.setPhone(phone);
                p.setAdress(adress);
                p.setDateOfRegistration(LocalDate.now());
                personsJson = mapper.writeValueAsString(p);
                System.out.println("абонент отредактирован" + personsJson);;
                break;
            }
        }

        // запись в файл всех данных
        personsJson = mapper.writeValueAsString(persons);
        Path file = Paths.get("C:\\Users\\Master\\Desktop\\IT\\Java\\phoneNumbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(file);) {
            writer.write(personsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // загрузка из фвйла данных

    }
}
