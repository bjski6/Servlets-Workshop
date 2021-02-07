package pl.coderslab.utils;

import hash_password.BCrypt;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String ADD_USER_QUERY = "insert into users (userName, email, password) VALUES (?,?,?)";
    private static final String MODIFY_USER_QUERY = "update users set userName = ?, email = ?, password =? where id = ?";
    private static final String READ_USER_QUERY = "select * from users where id = ?";
    private static final String DELETE_USER_QUERY = "delete from users where id = ?";
    private static final String READ_ALL_USERS_QUERY = "select * from users";

    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
            }



    public User addUser(User user) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preStmt = connection.prepareStatement(ADD_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getEmail());
            preStmt.setString(3, hashPassword(user.getPassword()));
            preStmt.executeUpdate();
            ResultSet resultSet = preStmt.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyUser(User user) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preStmt = connection.prepareStatement(MODIFY_USER_QUERY);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getEmail());
            preStmt.setString(3, hashPassword(user.getPassword()));
            preStmt.setInt(4, user.getId());
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User readUser(int id) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preStmt = connection.prepareStatement(READ_USER_QUERY);
            preStmt.setInt(1, id);
            ResultSet resultSet = preStmt.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Not found user id = " + id);
        }
        return null;

    }

    public void deleteUser(User user) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preStmt = connection.prepareStatement(DELETE_USER_QUERY);
            preStmt.setInt(1, user.getId());
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User[] addToUserArray(User user, User[] users) {
        User[] allUsers = Arrays.copyOf(users, users.length + 1);
        allUsers[users.length] = user;
        return allUsers;

    }

    public User[] readAllUsers() {
        try (Connection connection = DbUtil.getConnection()) {
            User[] users = new User[0];
            PreparedStatement preStmt = connection.prepareStatement(READ_ALL_USERS_QUERY);
            ResultSet resultSet = preStmt.executeQuery();
            while (resultSet.next()) {
                User nextUser = new User();
                nextUser.setId(resultSet.getInt("id"));
                nextUser.setUserName(resultSet.getString("userName"));
                nextUser.setEmail(resultSet.getString("email"));
                nextUser.setPassword(resultSet.getString("password"));
                users = addToUserArray(nextUser, users);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}




