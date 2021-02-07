package pl.coderslab.user;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/read")
public class read extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("id");
        int numberToRead= Integer.parseInt(number);
        UserDao userDao = new UserDao();
        User userToRead = userDao.readUser(numberToRead);
        request.setAttribute("user", userToRead);
        getServletContext().getRequestDispatcher("/users/read.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
