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

import it.objectmethod.continente.dao.IAggiungiDao;
import it.objectmethod.continente.dao.IModificaDao;
import it.objectmethod.continente.dao.impl.AggiungiDaoImpl;
import it.objectmethod.continente.dao.impl.ModificaDaoImpl;
import it.objectmethod.continente.domain.CityBean;;

@WebServlet("/aggiungimodifica")
public class AggiungiModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("identd")==null) {
			String citta =request.getParameter("citta");
			String countrycode =request.getParameter("countrycode");
			String district =request.getParameter("district");
			int population =Integer.parseInt(request.getParameter("population"));
			IAggiungiDao ad = new AggiungiDaoImpl();
			ad.insertCity(citta, countrycode, district, population);

			//request.setAttribute("listacitta", v);
			request.getRequestDispatcher("listacitta?nation="+countrycode).forward(request, response);


		} //request.getparameter
		else {
			int ident= Integer.parseInt(request.getParameter("identd"));
			List<CityBean> v = new ArrayList();
			IModificaDao md=new ModificaDaoImpl();
			v=md.selezionaCitta(ident);

			request.setAttribute("citta",v );
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
