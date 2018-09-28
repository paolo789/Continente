package it.objectmethod.world.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.continente.dao.INationDao;
import it.objectmethod.continente.dao.impl.NationDaoImpl;
import it.objectmethod.continente.domain.CountryBean;

@Controller
public class CountryController {
	
	@RequestMapping("/listacontinenti")
	public String continents(ModelMap map) {
		INationDao cd = new NationDaoImpl();
		List<String> continentList=cd.getContinent();
		map.addAttribute("continenti", continentList);
		return "ListaContinenti";
	}
	
	@RequestMapping("/listanazioni")
	public String nations(HttpServletRequest request,ModelMap map, @RequestParam("Cont") String continent) {
		HttpSession session= request.getSession();
		INationDao nd = new NationDaoImpl();
		List<CountryBean> n=nd.getNationsByContinent(continent);
		map.addAttribute("nazioni", n);
		session.setAttribute("cont", continent);
		return "ListaNazioni";
	}
}
