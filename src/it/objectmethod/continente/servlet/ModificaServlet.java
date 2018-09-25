package it.objectmethod.continente.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continente.dao.IModificaDao;
import it.objectmethod.continente.dao.impl.ModificaDaoImpl;

@WebServlet("/modifica")
public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/world";   
	static final String USER = "root";
	static final String PASS = "root";    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String citta= request.getParameter("nomecitta");
		int id= Integer.parseInt(request.getParameter("id"));
		String countrycode=request.getParameter("countrycode");
		String district=request.getParameter("District");
		int population=Integer.parseInt(request.getParameter("population"));
		IModificaDao md=new ModificaDaoImpl();
		md.modificaCitta(citta,countrycode,district,population, id);
		request.getRequestDispatcher("listacitta?nation="+countrycode).forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
