package com.expense.controller;

import com.expense.dao.DataDAO;
import com.expense.util.DBConnect;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewExpenseServlet")
public class ViewExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataDAO dao = new DataDAO(DBConnect.getConnection());
        
        request.setAttribute("total-income", dao.totalincome());
        request.setAttribute("total-expense", dao.totalexp());
        request.setAttribute("expenseList", dao.getAllExpenses());
        request.setAttribute("incomeList", dao.getAllIncomes());
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}