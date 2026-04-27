package com.expense.dao;

import com.expense.model.Expense;
import com.expense.model.Income;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {
    private Connection conn;

    public DataDAO(Connection conn) {
        this.conn = conn;
    }
    public void addexp(Expense exp) {
        try {
            String sql = "INSERT INTO expenses (sno, item, category, exp_date, price) VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, exp.getSno());
            ps.setString(2, exp.getItem());
            ps.setString(3, exp.getCategory());
            ps.setString(4, exp.getExp_date()); 
            ps.setDouble(5, exp.getPrice());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        try {
            String sql = "SELECT sno, item, category, TO_CHAR(exp_date, 'YYYY-MM-DD') AS exp_date, price FROM expenses ORDER BY exp_date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Expense(rs.getInt("sno"), rs.getString("item"), rs.getString("category"), rs.getString("exp_date"), rs.getDouble("price")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public double totalexp() {
        double total = 0;
        try {
            String sql = "SELECT SUM(price) FROM expenses";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) total = rs.getDouble(1);
        } catch (Exception e) { e.printStackTrace(); }
        return total;
    }

    public void deleteexp(int sno) {
        try {
            String sql = "DELETE FROM expenses WHERE sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sno);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void addincome(Income inc) {
        try {
            String sql = "INSERT INTO incomes (sno, source, inc_date, amount) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, inc.getSno());
            ps.setString(2, inc.getSource());
            ps.setString(3, inc.getInc_date()); 
            ps.setDouble(4, inc.getAmount());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Income> getAllIncomes() {
        List<Income> list = new ArrayList<>();
        try {
            String sql = "SELECT sno, source, TO_CHAR(inc_date, 'YYYY-MM-DD') AS inc_date, amount FROM incomes ORDER BY inc_date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Income(rs.getInt("sno"), rs.getString("source"), rs.getString("inc_date"), rs.getDouble("amount")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public double totalincome() {
        double total = 0;
        try {
            String sql = "SELECT SUM(amount) FROM incomes";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) total = rs.getDouble(1);
        } catch (Exception e) { e.printStackTrace(); }
        return total;
    }

    public void deleteincome(int sno) {
        try {
            String sql = "DELETE FROM incomes WHERE sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sno);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}