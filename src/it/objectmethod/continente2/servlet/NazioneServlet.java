package it.objectmethod.continente2.servlet;

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

import it.objectmethod.continente2.dao.INationDao;
import it.objectmethod.continente2.dao.impl.NationDaoImpl;

@WebServlet("/listanazioni")
public class NazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String continent =request.getParameter("Cont");
		List<String> n = new ArrayList();
		INationDao nd =(INationDao) new NationDaoImpl(); //TODO implementare interfaccia
		n=nd.getNation(continent);
		
		request.setAttribute("nazioni", n);
		request.getRequestDispatcher("ListaNazioni.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
