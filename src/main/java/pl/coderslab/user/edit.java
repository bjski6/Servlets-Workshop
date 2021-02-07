package pl.coderslab.user;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/edit")
public class edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("id");
        int numberToEdit= Integer.parseInt(number);
        UserDao userDao = new UserDao();
        User userToEdit = userDao.readUser(numberToEdit);
        request.setAttribute("user", userToEdit);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String number = request.getParameter("id");
        int numberToEdit= Integer.parseInt(number);
        UserDao userDao = new UserDao();
        User userToEdit = userDao.readUser(numberToEdit);
        userToEdit.setUserName(request.getParameter("userName"));
        userToEdit.setEmail(request.getParameter("email"));
        userToEdit.setPassword(request.getParameter("password"));
        userDao.modifyUser(userToEdit);
        response.sendRedirect(request.getContextPath()+ "/user/list");
    }
}
