package pl.golomp.restserver.controllers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.golomp.restserver.Constants;
import pl.golomp.restserver.HibernateUtil;
import pl.golomp.restserver.entities.GToken;
import pl.golomp.restserver.entities.GUser;
import pl.golomp.restserver.exceptions.IncorrectPasswordException;
import pl.golomp.restserver.exceptions.ProtocolTooOldException;
import pl.golomp.restserver.exceptions.UserNotFoundException;
import pl.golomp.restserver.requests.LoginRequest;
import pl.golomp.restserver.responses.LoginResponse;

/**
 * Created by konrad on 25.01.15.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody LoginResponse login(@RequestBody LoginRequest loginRequest) throws ProtocolTooOldException, UserNotFoundException, IncorrectPasswordException {
        // alg goes here
        if (loginRequest.getProtocolVersion() < Constants.lowestProtocol) throw new ProtocolTooOldException();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From GUser guser where guser.login = :login");
        q.setParameter("login", loginRequest.getLogin());
        GUser user = (GUser) q.uniqueResult();

        System.out.println(user);

        if (user == null) throw new UserNotFoundException();
        if (!user.checkPassword(loginRequest.getPassword())) throw new IncorrectPasswordException();

        session.beginTransaction();
        GToken token = new GToken(user, Constants.sessionDuration);
        session.save(token);
        session.getTransaction().commit();

        return new LoginResponse(token);
    }

}
