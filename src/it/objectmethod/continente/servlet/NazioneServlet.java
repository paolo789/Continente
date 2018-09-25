package it.objectmethod.continente.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.dao.impl.NationDaoImpl;
import it.objectmethod.continente.domain.CountryBean;

@WebServlet("/listanazioni")
public class NazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String continent =request.getParameter("Cont");
		List<CountryBean> n = new ArrayList();
		INationDao nd = new NationDaoImpl(); //TODO implementare interfaccia
		n=nd.getNationsByContinent(continent);
		
		request.setAttribute("nazioni", n);
		session.setAttribute("cont", continent);
		request.getRequestDispatcher("ListaNazioni.jsp").forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
