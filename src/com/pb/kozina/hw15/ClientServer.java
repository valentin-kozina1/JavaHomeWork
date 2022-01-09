package com.pb.kozina.hw15;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientServer {

    public static void main(String[] args) throws Exception {
        int port = 1234;
        Socket socket = new Socket("localhost", port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Frame dialog = new Frame();
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        Label label = new Label("Клиент подключился. Сервер ждет запроса");
        Button button = new Button("Отправить сообщение");
        TextArea text = new TextArea();

        label.setBounds(20, 40, 650, 20);
        text.setBounds(20, 280, 650, 200);
        button.setBounds(20, 250, 650, 30);

        dialog.add(button);
        dialog.add(label);
        dialog.add(text);

        dialog.setSize(700,500);
        dialog.setTitle("Чат");
        dialog.setLayout(null);

        // для работы кнопки закрытие окна "крестик"
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        // отправка на сервер
        button.addActionListener(event -> {
            out.println(text.getText());
            Label label2 = new Label("Запрос отправлен на сервер: " + text.getText());
            text.setText("");
            label2.setBounds(20, 60, 650, 20);
            dialog.add(label2);
        });

        dialog.setVisible(true);

        String str;
        List<Label> lab = new ArrayList<>();
        Label label3 = new Label("Получен ответ от сервера: ");
        label3.setBounds(20, 80, 650, 20);
        int i = 0;
        // Входим в цикл чтения, что нам ответил сервер
        while ((str = in.readLine()) != null) {
            lab.add(i, new Label(str));
        }
        i = 1;
        if (lab.size()>0) {
            dialog.add(label3);
            for (Label l : lab) {
                int y = 80+i*20;
                l.setBounds(20, y, 650, 20);
                dialog.add(l);
                i++;
            }
        }
        in.close();
        out.close();
        socket.close();
    }
}
