package pl.golomp.restserver.controllers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.golomp.restserver.HibernateUtil;
import pl.golomp.restserver.entities.GToken;
import pl.golomp.restserver.requests.LogoutRequest;

/**
 * Created by konrad on 25.01.15.
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void logout(@RequestBody LogoutRequest logoutRequest) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From GToken where token = :token and loggedOut = false ");
        q.setParameter("token", logoutRequest.getToken());
        GToken token = (GToken) q.uniqueResult();
        System.out.println(token);
        token.setLoggedOut(Boolean.TRUE);
        session.beginTransaction();
        session.save(token);
        session.getTransaction().commit();
        return;
    }
}
