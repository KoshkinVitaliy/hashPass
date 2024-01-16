package data;

import user.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserTable {
    private static List<User> users = new ArrayList<>();
    private final File database = new File(
            "C:\\Users\\admin\\IdeaProjects\\hashPass\\src\\main\\java\\data\\database.txt");

    static {
        User user = new User(0, "Vitaliy", "admin", "0000");
        users.add(user);
    }

    private User showDataBaseInterface() {
        Scanner scanner = new Scanner(System.in);

        int id;
        String name;
        String login;
        String password;

        System.out.println("Введите данные для добавления пользователя:");
        System.out.println("Введите id:");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя:");
        name = scanner.nextLine();
        System.out.println("Введите логин:");
        login = scanner.nextLine();
        System.out.println("Введите введите пароль:");
        password = scanner.nextLine();

        return new User(id, name, login, password);
    }

    public void addUser() {
        User user = showDataBaseInterface();

        try {
            FileWriter fileWriter = new FileWriter(database, true);
            fileWriter.write(
                            user.getId() + " " +
                                user.getName() + " " +
                                user.getLogin() + " "+
                                user.getPassword() + "\n"
                            );

            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("Exception occured: " + e);
        }

    }
}
