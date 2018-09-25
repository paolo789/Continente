package it.objectmethod.continente.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continente.dao.ICercaDao;
import it.objectmethod.continente.dao.impl.CercaDaoImpl;
import it.objectmethod.continente.domain.*;

@WebServlet("/ricercacitta")
public class CercaCittaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/world";   
	static final String USER = "root";
	static final String PASS = "root";   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cercaCitta =request.getParameter("cercacitta");
		List<CityBean> v= new ArrayList();
		ICercaDao ccd=new CercaDaoImpl();
		v=ccd.cercaCitta(cercaCitta);
		request.setAttribute("listacitta", v);
		request.getRequestDispatcher("CercaCitta.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
