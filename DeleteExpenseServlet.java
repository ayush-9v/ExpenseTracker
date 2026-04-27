package com.expense.controller;

import com.expense.dao.DataDAO;
import com.expense.util.DBConnect;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteExpenseServlet")
public class DeleteExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        
        DataDAO dao = new DataDAO(DBConnect.getConnection());
        dao.deleteexp(sno);
        
        response.sendRedirect("ViewExpenseServlet");
    }
}