package service;

import dataAccess.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalCounter {
    public void countAnimals() {
        int totalAnimals = countAnimaInTable("Pets") + countAnimaInTable("PackAnimals");
        System.out.println("Общее количество животных в обеих таблицах: " + totalAnimals);
    }

    public static int countAnimaInTable(String tableName) {
        int count = 0;
        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT COUNT(*) AS count FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                count = resultSet.getInt("count");
                System.out.println("Количество животных в таблице " + tableName + ": " + count);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подсчете животных в таблице " + tableName + ": " + e.getMessage());
        }
        return count;
    }
}
