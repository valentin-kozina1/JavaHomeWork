package com.pb.kozina.hw15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientServer {

    public static void main(String[] args) throws Exception {
        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int port = 1234;

        // Открыть сокет (Socket) для обращения к локальному компьютеру
        // Сервер мы будем запускать на этом же компьютере
        // Это специальный класс для сетевого взаимодействия c клиентской стороны
        Socket socket = new Socket("localhost", port);

        // Создать поток для чтения символов из сокета
        // Для этого надо открыть поток сокета - socket.getInputStream()
        // Потом преобразовать его в поток символов - new InputStreamReader
        // И уже потом сделать его читателем строк - BufferedReader
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Создать поток для записи символов в сокет
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Frame frame = new Frame();
        Label label = new Label(" Клиент подключился. Сервер ждет запроса");
        Button button = new Button("Отправить сообщение");
        TextField textField = new TextField();

        label.setBounds(20, 20, 450, 150);
        textField.setBounds(20, 280, 450, 200);
        button.setBounds(20, 250, 450, 30);

        frame.add(button);
        frame.add(label);
        frame.add(textField);

        frame.setSize(700,500);
        frame.setTitle("Чат");
        // нужно убрать менеджер компоновки который установлен по умолчанию
        // иначе будет использован BorderLayout и компоненты будут расположены не так как задумано
        frame.setLayout(null);

        // для работы кнопки закрытие окна "крестик"
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // обработка нажатия кнопки
        button.addActionListener(event -> {
            Label label2 = new Label("Запрос отправлен на сервер: " + textField.getText());
            label2.setBounds(20, 40, 450, 150);
            frame.add(label2);
            out.println(textField.getText());
        });

        frame.setVisible(true);

        // Пишем, что стартовал клиент
       // System.out.println("Клиент подключился");
       // System.out.println("Сервер ждет запроса");
       // Scanner scan = new Scanner(System.in);
        //String message = scan.nextLine();

        // Отправляем тестовую строку в сокет
        //out.println(message);
       // System.out.println(" Запрос отправлен на сервер ");

        String str;
        // Входим в цикл чтения, что нам ответил сервер
        while ((str = in.readLine()) != null) {
            // Печатаем ответ от сервера на консоль для проверки
            System.out.println(str);
        }

        in.close();
        out.close();
        socket.close();
    }
}
