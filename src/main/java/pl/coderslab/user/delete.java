package pl.coderslab.user;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/delete")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String number = request.getParameter("id");
    int numberToDelete = Integer.parseInt(number);
        UserDao userDao = new UserDao();
        User userToDelete = userDao.readUser(numberToDelete);
        userDao.deleteUser(userToDelete);
        response.sendRedirect(request.getContextPath() + "/user/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
