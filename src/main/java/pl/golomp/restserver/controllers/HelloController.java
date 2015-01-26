package pl.golomp.restserver.controllers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.golomp.restserver.HibernateUtil;
import pl.golomp.restserver.entities.Encja;
import pl.golomp.restserver.entities.GMessage;
import pl.golomp.restserver.entities.GToken;
import pl.golomp.restserver.entities.GUser;
import pl.golomp.restserver.exceptions.SampleException;
import pl.golomp.restserver.responses.ErrorResponse;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String printWelcome() {//ModelMap model) {
		//model.addAttribute("message", "Hello world!");
		Session session = HibernateUtil.getSessionFactory().openSession();

//		session.beginTransaction();
//
//		Encja encja = new Encja("jakistekst lololo");
//		session.save(encja);

//		session.save(new Employee("Jakab Gipsz",department));
//		session.save(new Employee("Captain Nemo",department));
//
//		session.getTransaction().commit();

		Query q = session.createQuery("From Encja ");

		StringBuilder sb = new StringBuilder();

		List<Encja> resultList = q.list();
//		System.out.println("num of employess:" + resultList.size());
		for (Encja next : resultList) {
			sb.append("next: " + next + "<br>\n");
//			System.out.println("next employee: " + next);
		}

		Query q2 = session.createQuery("From GUser ");
		List<GUser> res = q2.list();

		sb.append("<br>\n");
		for(GUser next : res) {
			sb.append("user: "+next+"<br>\n");
		}

		Query q3 = session.createQuery("From GToken ");
		List<GToken> res3 = q3.list();

		sb.append("<br>\n");
		for(GToken next : res3) {
			sb.append("token: "+next+"<br>\n");
		}

		Query q4 = session.createQuery("From GMessage ");
		List<GMessage> res4 = q4.list();

		sb.append("<br>\n");
		for(GMessage next : res4) {
			sb.append("msg: "+next+"<br>\n");
		}

		System.out.println(sb.toString());
		return sb.toString();
	}
}
