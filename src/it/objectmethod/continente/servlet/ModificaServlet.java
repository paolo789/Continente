
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
import it.objectmethod.continente.domain.CityBean;


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
		CityBean cb = new CityBean();
		cb.setName(citta);
		cb.setCountryCode(countryCode);
		cb.setDistrict(district);
		cb.setPopulation(population);
		if (request.getParameter("id")!=null) {
			int id= Integer.parseInt(request.getParameter("id"));
			cb.setId(id);
			ICityDao md=new CityDaoImpl();
			md.modificaCitta(cb);
			request.setAttribute("nationCode", countryCode); //TODO meglio agire così
			request.getRequestDispatcher("listacitta").forward(request, response);
		}
		else {
			ICityDao md=new CityDaoImpl();
			md.insertCity(cb);
			request.getRequestDispatcher("listacitta?nation="+countryCode).forward(request, response); //TODO piuttosto che così
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
