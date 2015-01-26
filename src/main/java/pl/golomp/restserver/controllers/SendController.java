package pl.golomp.restserver.controllers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.golomp.restserver.HibernateUtil;
import pl.golomp.restserver.TokenUtil;
import pl.golomp.restserver.entities.GMessage;
import pl.golomp.restserver.entities.GUser;
import pl.golomp.restserver.exceptions.BadDateException;
import pl.golomp.restserver.exceptions.SessionNotValidException;
import pl.golomp.restserver.exceptions.UserNotFoundException;
import pl.golomp.restserver.requests.SendRequest;
import pl.golomp.restserver.responses.SendResponse;

import java.sql.Timestamp;

/**
 * Created by konrad on 26.01.15.
 */
@Controller
@RequestMapping("/send")
public class SendController {
    @RequestMapping(method = RequestMethod.POST)
    private @ResponseBody
    SendResponse send(@RequestBody SendRequest sendRequest) throws SessionNotValidException, UserNotFoundException, BadDateException {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (sendRequest.getDeliveryTime().before(now)) throw new BadDateException();

        GUser sender = TokenUtil.validateToken(sendRequest.getToken());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From GUser where login = :login");
        q.setParameter("login", sendRequest.getRecipient());
        GUser recipient = (GUser) q.uniqueResult();
        if (recipient == null) throw new UserNotFoundException();

        session.beginTransaction();
        GMessage msg = new GMessage(sendRequest.getContent(), sender, recipient, sendRequest.getDeliveryTime());
        session.save(msg);
        session.getTransaction().commit();

        return new SendResponse(msg.getId());
    }
}
