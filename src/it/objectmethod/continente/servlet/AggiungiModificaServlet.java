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


import it.objectmethod.continente.dao.ICityDao;
import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.dao.impl.CityDaoImpl;
import it.objectmethod.continente.dao.impl.NationDaoImpl;
import it.objectmethod.continente.domain.CityBean;
import it.objectmethod.continente.domain.CountryBean;;

@WebServlet("/aggiungimodifica")
public class AggiungiModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("identd")==null) {
	//		List<CityBean> b = new ArrayList();
			INationDao iNationDao=new NationDaoImpl();
			List<CountryBean> countriesList=iNationDao.listaCountry();
			request.setAttribute("countries", countriesList);
			request.getRequestDispatcher("CercaCittaModifica.jsp").forward(request, response);
		} //request.getparameter
		else {
			int ident= Integer.parseInt(request.getParameter("identd"));
			//List<CityBean> v = new ArrayList();
			//List<CityBean> b = new ArrayList();
			INationDao iNationDao=new NationDaoImpl();
			ICityDao iCityDao = new CityDaoImpl();
			CityBean citta=iCityDao.selezionaCitta(ident);
			List<CountryBean> countriesList=iNationDao.listaCountry();

			request.setAttribute("countries", countriesList);
			request.setAttribute("citta",citta );
			request.getRequestDispatcher("CercaCittaModifica.jsp").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
