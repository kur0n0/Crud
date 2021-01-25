package com.sample;

import com.sample.model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {

    UserDao dao;

    @Override
    public void init() throws ServletException {
        dao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if(action.equals("/AllUsers")){
            getAllUsers(req, resp);
        }else if(action.equals("/Insert")){
            addUser(req, resp);
        }else if (action.equals("/Add")) {
            showNewForm(req, resp);
        }else if(action.contains("/Delete")){
            deleteUser(req, resp);
        }else if (action.equals("/Update")){
            editUser(req, resp);
        }else if(action.contains("/Edit")){
            showEditForm(req, resp);
        }

    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UserModel user = new UserModel();

        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        int age = Integer.parseInt(req.getParameter("Age"));

        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);

        int status = dao.addUser(user);

        if(status > 0){
            resp.getWriter().print("<p>User saved successfully!</p>");
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }else{
            resp.getWriter().println("Sorry! unable to save user");
        }
    }

    private void getAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<UserModel> allUsers = dao.getAllUsers();
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/index.jsp");
        req.setAttribute("allUsers", allUsers);
        requestDispatcher.forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));

        int status = dao.deleteById(id);
        if(status > 0){
            resp.getWriter().print("<p>User deleted</p>");
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }else{
            resp.getWriter().print("Sorry! unable to delete record");
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        int age = Integer.parseInt(req.getParameter("Age"));

        int status = dao.editById(id, name, surname, age);
        if(status > 0){
            resp.getWriter().print("<p>User edited</p>");
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }else {
            resp.getWriter().print("Sorry! unable to edit record");
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));

        UserModel user = dao.getUserById(id);

        req.setAttribute("user", user);
        req.getRequestDispatcher("form.jsp").include(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("form.jsp").include(req, resp);
    }

}
