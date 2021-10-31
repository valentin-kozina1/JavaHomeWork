package com.pb.kozina.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] book = new Book[5];
        book[0] = new Book("Приключения", "Иванов А.А.", 1970);
        book[1] = new Book("Детектив", "Петров А.А.", 1980);
        book[2] = new Book("Боевик","Сидоров А.А.", 1990);
        book[3] = new Book("Роман", "Кузнецов А.А.", 2000);
        book[4] = new Book("Фельетон", "Васильев А.А.", 2010);

        for (int i = 0; i < book.length; i++){
            System.out.println(book[i].getBook());
        }

        Reader[] reader = new Reader[5];
        reader[0] = new Reader("Иваненко А.А.", 123, "экономический", "01.01.2000", "+380000000000");
        reader[1] = new Reader("Петренко А.А.", 124, "физ-мат", "02.02.2001", "+380000000000");
        reader[2] = new Reader("Сидоренко А.А.", 125, "исторический", "03.03.2002", "+380000000000");
        reader[3] = new Reader("Марченко А.А.", 126, "юридический", "04.04.2003", "+380000000000");
        reader[4] = new Reader("Андриенко А.А.", 127, "физ. восп.", "05.05.2004", "+380000000000");

        for (int i = 0; i < reader.length; i++){
            System.out.println(reader[i].getReader());
        }

        reader[0].takeBook(3);
        reader[1].takeBook("Приключения", "Боевик", "Роман");
        reader[2].takeBook(book[2], book[4]);

        reader[0].returnBook(3);
        reader[1].returnBook("Приключения", "Боевик", "Роман");
        reader[2].returnBook(book[2], book[4]);

    }

}
