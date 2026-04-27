package com.expense.controller;

import com.expense.dao.DataDAO;
import com.expense.model.Expense;
import com.expense.util.DBConnect;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddExpenseServlet")
public class AddExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        String item = request.getParameter("item");
        String category = request.getParameter("category");
        String exp_date = request.getParameter("exp_date"); 
        double price = Double.parseDouble(request.getParameter("price"));

        Expense exp = new Expense(sno, item, category, exp_date, price);
        DataDAO dao = new DataDAO(DBConnect.getConnection());
        dao.addexp(exp);

        response.sendRedirect("ViewExpenseServlet");
    }
}