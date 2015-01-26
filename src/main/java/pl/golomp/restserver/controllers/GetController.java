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
import pl.golomp.restserver.exceptions.MessageNotFoundException;
import pl.golomp.restserver.exceptions.MessageNotReadyYetException;
import pl.golomp.restserver.exceptions.NotPermittedException;
import pl.golomp.restserver.exceptions.SessionNotValidException;
import pl.golomp.restserver.requests.StatusGetRequest;
import pl.golomp.restserver.responses.GetResponse;

import java.sql.Timestamp;

/**
 * Created by konrad on 26.01.15.
 */
@Controller
@RequestMapping("/get")
public class GetController {
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody GetResponse get(@RequestBody StatusGetRequest statusGetRequest) throws MessageNotFoundException, NotPermittedException, SessionNotValidException, MessageNotReadyYetException {
        GUser gUser = TokenUtil.validateToken(statusGetRequest.getToken());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From GMessage where id = :id");
        q.setParameter("id", statusGetRequest.getMsgId());
        GMessage gMessage = (GMessage) q.uniqueResult();
        if (gMessage == null) throw new MessageNotFoundException();
        if (gMessage.getRecipient().getId() != gUser.getId()) throw new NotPermittedException();
        if (!gMessage.readyToGet()) throw new MessageNotReadyYetException();

        if (gMessage.getRecvDate() == null) {
            session.beginTransaction();
            gMessage.setRecvDate(new Timestamp(System.currentTimeMillis()));
            session.save(gMessage);
            session.getTransaction().commit();
        }

        return new GetResponse(gMessage);
    }
}
