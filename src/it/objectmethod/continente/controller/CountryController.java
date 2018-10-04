package it.objectmethod.continente.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.continente.dao.impl.NationDaoImpl;
import it.objectmethod.continente.domain.CountryBean;

@Controller
public class CountryController {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	NationDaoImpl cd = (NationDaoImpl)context.getBean("nd");
	
	
	@RequestMapping("/listacontinenti")
	public String continents(ModelMap map) throws SQLException{
		//INationDao cd = new NationDaoImpl();
		List<CountryBean> continentList=cd.getContinent();
		map.addAttribute("continenti", continentList);
		return "ListaContinenti";
	}
	
	@RequestMapping("/listanazioni")
	public String nations(HttpServletRequest request,ModelMap map, @RequestParam("Cont") String continent) {
		HttpSession session= request.getSession();
		//INationDao nd = new NationDaoImpl();
		List<CountryBean> n=cd.getNationsByContinent(continent);
		map.addAttribute("nazioni", n);
		session.setAttribute("cont", continent);
		return "ListaNazioni";
	}
}
