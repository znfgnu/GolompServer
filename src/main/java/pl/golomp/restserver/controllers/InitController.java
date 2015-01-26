package pl.golomp.restserver.controllers;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.golomp.restserver.HibernateUtil;
import pl.golomp.restserver.entities.Encja;
import pl.golomp.restserver.entities.GUser;

/**
 * Created by konrad on 25.01.15.
 */
@RestController
@RequestMapping("/init")
public class InitController {
    @RequestMapping
    public @ResponseBody String init() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Encja encja = new Encja("jakistekst lololo1");
        session.save(encja);
        encja = new Encja("jakistekst lololo2");
        session.save(encja);
        encja = new Encja("jakistekst lololo3");
        session.save(encja);
        encja = new Encja("jakistekst lololo4");
        session.save(encja);

        GUser GUser = new GUser("user1", "pass1");
        session.save(GUser);
        GUser = new GUser("user2", "pass1");
        session.save(GUser);
        GUser = new GUser("user3", "pass1");
        session.save(GUser);
        GUser = new GUser("user4", "pass1");
        session.save(GUser);

        session.getTransaction().commit();

        return "Done.";
    }
}
