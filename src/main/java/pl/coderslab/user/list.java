package pl.coderslab.user;

import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/list")
public class list extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        request.setAttribute("users", userDao.readAllUsers());
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request,response);
    }


}
