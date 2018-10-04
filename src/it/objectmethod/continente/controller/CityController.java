package it.objectmethod.continente.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.continente.dao.ICityDao;
import it.objectmethod.continente.dao.ICountryDao;
import it.objectmethod.continente.dao.impl.CityDaoImpl;
import it.objectmethod.continente.dao.impl.CountryDaoImpl;
import it.objectmethod.continente.domain.CityBean;
import it.objectmethod.continente.domain.CountryBean;

@Controller
public class CityController {
	/*ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/mondo-servlet.xml");
	CityDaoImpl cd = (CityDaoImpl)context.getBean("cd");
	NationDaoImpl nd=(NationDaoImpl)context.getBean("nd"); */
	
	@Autowired
	ICityDao cd;
	
	@Autowired
	ICountryDao nd;
	
	@RequestMapping("/listacitta")
	public String cities(ModelMap map,@RequestParam("nation") String nation) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//ICityDao cd = new CityDaoImpl();
		List<CityBean> v=cd.getCitiesByNations(nation);
		map.addAttribute("citta", v);
		map.addAttribute("nation",nation);
		return "ListaCitta";
	}
	
	@RequestMapping("/ricercacitta")
	public String cercaCitta(ModelMap map, @RequestParam("cercacitta") String cercaCitta) {
		//ICityDao ccd=new CityDaoImpl();
		List<CityBean> v=cd.cercaCitta(cercaCitta);
		map.addAttribute("listacitta", v);
		return "CercaCitta";
	}
	
	@RequestMapping("/aggiungimodifica")
	public String aggiungiModificaCitta(HttpServletRequest request,ModelMap map) {
		//INationDao iNationDao=new NationDaoImpl();
		List<CountryBean> countriesList=nd.listaCountry();
		CityBean citta = new CityBean();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("identd"));
		} catch (NumberFormatException e) {
			id = 0;
			e.printStackTrace();
		}
		if (id != 0) {
			//ICityDao iCityDao = new CityDaoImpl();
			citta = cd.selezionaCitta(id);
			map.addAttribute("citta",citta );
		}
		map.addAttribute("countries", countriesList);
		return  "CercaCittaModifica";
	}
	
	
		
		@RequestMapping("/modifica")
		public String modifica(HttpServletRequest request,ModelMap map, @RequestParam("nomecitta") String citta,@RequestParam("country") String countryCode,@RequestParam("district") String district,@RequestParam("population") String population) {
			CityBean cb = new CityBean();
			cb.setName(citta);
			cb.setCountryCode(countryCode);
			cb.setDistrict(district);
			cb.setPopulation(Integer.parseInt(population));
			if (request.getParameter("id")!=null) {
				int id= Integer.parseInt(request.getParameter("id"));
				cb.setId(id);
				//ICityDao md=new CityDaoImpl();
				cd.modificaCitta(cb);
				map.addAttribute("nationCode", countryCode); //TODO meglio agire così
			}
			else {
				//ICityDao md=new CityDaoImpl();
				cd.insertCity(cb);
			}
			return "forward:listacitta?nation="+countryCode; //TODO piuttosto che così
		}
		
		@RequestMapping("/cancella")	
		public String cancellaCitta(ModelMap map, @RequestParam("identd") String id, @RequestParam("countrycode") String countryCode) {
			int ident= Integer.parseInt(id);
			//ICityDao cd = new CityDaoImpl();
			cd.cancellaCitta(ident);
			System.out.println("Sto cancellando "+countryCode);
			return "forward:listacitta?nation="+countryCode;
		}

}
