package it.objectmethod.continente.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continente.dao.ICityDao;
import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.dao.impl.CityDaoImpl;
import it.objectmethod.continente.dao.impl.NationDaoImpl;
import it.objectmethod.continente.domain.CityBean;

//@WebServlet("/listacitta")
public class CittaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nation =request.getParameter("nation");
		if(nation == null) {
			nation = (String) request.getAttribute("nationCode");
		}
		ICityDao cd = new CityDaoImpl();
		List<CityBean> v=cd.getCitiesByNations(nation);
		request.setAttribute("citta", v);
		request.setAttribute("nation",nation);
		request.getRequestDispatcher("ListaCitta.jsp").forward(request, response);
	}
}
