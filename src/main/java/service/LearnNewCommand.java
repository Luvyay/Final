package service;

import dataAccess.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LearnNewCommand {
    public void learnNewCommand() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя таблицы (Pets или PackAnimals): ");
        String tableName = scanner.nextLine();

        int id;
        while (true) {
            System.out.println("Введите ID животного: ");
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                id = Integer.parseInt(input);
                break;
            } else {
                System.out.println("ID должен быть числом. Попробуйте снова.");
            }
        }


        System.out.println("Введите новую команду: ");
        String newCommand = scanner.nextLine();

        addNewCommand(tableName, id, newCommand);
    }

    public static void addNewCommand(String tableName, int id, String newCommand) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "UPDATE " + tableName + " SET Commands = CONCAT(Commands, ', ', ?) WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newCommand);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Новая команда успешно добавлена для животного с ID " + id + " в таблицу " + tableName);
            } else {
                System.out.println("Животное с ID " + id + " в таблице " + tableName + " не найдено.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении новой команды: " + e.getMessage());
        }
    }
}
