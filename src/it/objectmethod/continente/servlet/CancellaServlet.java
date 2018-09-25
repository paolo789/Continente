package it.objectmethod.continente.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continente.dao.ICancellaDao;
import it.objectmethod.continente.dao.impl.CancellaDaoImpl;


@WebServlet("/cancella")
public class CancellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/world";   
	static final String USER = "root";
	static final String PASS = "root";      
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ident= Integer.parseInt(request.getParameter("identd"));
		String countrycode=request.getParameter("countrycode");
		ICancellaDao cd = new CancellaDaoImpl();
		cd.cancellaCitta(ident);
		request.getRequestDispatcher("listacitta?nation="+countrycode).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
