package it.objectmethod.continente2.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continente2.dao.ICityDao;
import it.objectmethod.continente2.dao.INationDao;
import it.objectmethod.continente2.dao.impl.CityDaoImpl;
import it.objectmethod.continente2.dao.impl.NationDaoImpl;

@WebServlet("/listacitta")
public class CittaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nation =request.getParameter("nation");
		ArrayList<String> v = new ArrayList();
		ICityDao cd = new CityDaoImpl();
		v=cd.getCity(nation);
		request.setAttribute("citta", v);
		request.getRequestDispatcher("ListaCitta.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}