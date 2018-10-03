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
import javax.sql.DataSource;



import it.objectmethod.continente.dao.ICityDao;
import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.dao.impl.CityDaoImpl;
import it.objectmethod.continente.dao.impl.NationDaoImpl;
import it.objectmethod.continente.domain.CityBean;
import it.objectmethod.continente.domain.CountryBean;;

//@WebServlet("/aggiungimodifica")
public class AggiungiModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		INationDao iNationDao=new NationDaoImpl();
		List<CountryBean> countriesList=iNationDao.listaCountry();

		CityBean citta = new CityBean();
		int ident = 0;
		
		try {
			ident = Integer.parseInt(request.getParameter("identd"));
		} catch (NumberFormatException e) {
			ident = 0;
		}

		
		if (ident != 0) {
			ICityDao iCityDao = new CityDaoImpl();
			
			citta = iCityDao.selezionaCitta(ident);
			request.setAttribute("citta",citta );
		}
		
		request.setAttribute("countries", countriesList);
		request.getRequestDispatcher("CercaCittaModifica.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
