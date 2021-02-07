package pl.coderslab;

import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main03 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbUtil.getConnection();
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("Marcin");
        user.setEmail("marcinek@gmail.com");
        user.setPassword("marrciicn");
        //userDao.addUser(user);
       User [] users = userDao.readAllUsers();
       for(User u : users){
           System.out.println(u);
       }



    }

}
