package ru.job4j.storage;

import ru.job4j.model.Hall;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcStorage {

    private static Connection connection;
    private int size = 0;

    public Hall save(Hall hall) {

        String s = "INSERT into halls(id, rows, columns) VALUES(?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(s)) {

            statement.setInt(1, hall.getId());
            statement.setString(2, hall.getRows());
            statement.setString(3, hall.getColumns());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hall;
    }


    public Hall[] getAll() {
        Hall[] halls = new Hall[size];


        try (Connection connection = init()) {
            String s = "SELECT id, rows, columns FROM halls";

            PreparedStatement statement = connection.prepareStatement(s);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                Hall haller = new Hall();

                haller.setId(resultSet.getInt("id"));
                haller.setRows(resultSet.getString("rows"));
                haller.setColumns(resultSet.getString("columns"));

                for (int i = 0; i < size; i++) {
                    halls[i] = haller;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return halls;
    }

    private Connection init() throws SQLException {
        Properties config = new Properties();

        try (InputStream in = JdbcStorage.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        String url = config.getProperty("url");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        this.connection = DriverManager.getConnection(url, username, password);

        return connection;
    }
}
