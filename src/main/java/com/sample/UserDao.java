package com.sample;

import com.sample.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao(){
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void connectDb(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/ForTests",
                    "postgres", "admin");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void disconnectDb(){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int addUser(UserModel user){
        String query = "INSERT INTO users" +
                        "(name, surname, age)" +
                        " VALUES" +
                        "(?,?,?)";
        int status = 0;

        connectDb();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());

            status = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        disconnectDb();

        return status;
    }

    public List<UserModel> getAllUsers(){
        String query = "SELECT * FROM users";
        List<UserModel> allUsers = new ArrayList<UserModel>();

        connectDb();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");

                UserModel user = new UserModel();
                user.setId(id);
                user.setName(name);
                user.setSurname(surname);
                user.setAge(age);

                allUsers.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        disconnectDb();

        return allUsers;
    }

    public int deleteById(int id){
        String query = "DELETE FROM users WHERE id=?";
        int status = 0;

        connectDb();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        disconnectDb();

        return status;
    }

    public int editById(int id, String nameUser, String surnameUser, int ageUser){
        String query = "UPDATE users SET name=?, surname=?, age=? WHERE id=?";
        int status = 0;

        connectDb();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameUser);
            preparedStatement.setString(2, surnameUser);
            preparedStatement.setInt(3, ageUser);
            preparedStatement.setInt(4, id);

            status = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        disconnectDb();

        return status;
    }

    public UserModel getUserById(int id){
        String query="SELECT * FROM users WHERE id=?";
        UserModel user = new UserModel();

        connectDb();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int idUser = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");

                user.setId(idUser);
                user.setName(name);
                user.setSurname(surname);
                user.setAge(age);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        disconnectDb();

        return user;
    }
}
