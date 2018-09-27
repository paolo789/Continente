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

import it.objectmethod.continente.dao.ICityDao;

import it.objectmethod.continente.dao.impl.CityDaoImpl;


@WebServlet("/modifica")
public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/world";   
	static final String USER = "root";
	static final String PASS = "root";    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String citta= request.getParameter("nomecitta");
		String countryCode=request.getParameter("country");
		String district=request.getParameter("district");
		int population=Integer.parseInt(request.getParameter("population"));
		if (request.getParameter("id")!=null) {
			int id= Integer.parseInt(request.getParameter("id"));
			ICityDao md=new CityDaoImpl();
			md.modificaCitta(citta,countryCode,district,population, id);
			request.setAttribute("nationCode", countryCode); //TODO meglio agire cos�
			request.getRequestDispatcher("listacitta").forward(request, response);
		}
		else {
			ICityDao md=new CityDaoImpl();
			md.insertCity(citta, countryCode, district, population);
			request.getRequestDispatcher("listacitta?nation="+countryCode).forward(request, response); //TODO piuttosto che cos�
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
