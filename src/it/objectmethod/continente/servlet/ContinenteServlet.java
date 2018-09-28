package it.objectmethod.continente.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.dao.impl.NationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/listacontinenti")
public class ContinenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> v = new ArrayList();
		INationDao cd = new NationDaoImpl();
		v=cd.getContinent();
		request.setAttribute("continenti", v);
		request.getRequestDispatcher("ListaContinenti.jsp").forward(request, response);		
	}
}
