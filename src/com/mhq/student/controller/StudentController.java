package com.mhq.student.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.mhq.student.entity.Student;

public class StudentController {
	private static int insert(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into students (stu_id,stu_name,stu_subject,stu_achievement) values(?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, UUID.randomUUID().toString().replaceAll("-", ""));
	        pstmt.setString(2, student.getStu_name());
	        pstmt.setString(3, student.getStu_subject());
	        pstmt.setInt(4, student.getStu_achievement());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	private static int delete(String id) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from students where stu_id='" + id + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	private static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from students";
	    //查询每个学生总成绩
	    String stuCountsql="SELECT stu_name,sum(stu_achievement) FROM students GROUP BY stu_name";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	private static int update(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update students set stu_name='" + student.getStu_name() + "', stu_achievement='"+student.getStu_achievement() +"', stu_subject='"+student.getStu_subject() +"' where stu_id='" + student.getStu_id() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static void main(String[] args) {
		Student s=new Student();
		s.setStu_id("12");
		s.setStu_achievement(1);
		s.setStu_name("小哥1 ");
		s.setStu_subject("语文");
//		insert(s);
		getAll();
		update(s);
	}
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf-8";
	    String username = "root";
	    String password = "";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
}
