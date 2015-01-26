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
import pl.golomp.restserver.exceptions.NotPermittedException;
import pl.golomp.restserver.exceptions.SessionNotValidException;
import pl.golomp.restserver.requests.StatusGetRequest;
import pl.golomp.restserver.responses.StatusResponse;

/**
 * Created by konrad on 26.01.15.
 */
@Controller
@RequestMapping("/status")
public class StatusController {
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody StatusResponse status(@RequestBody StatusGetRequest statusGetRequest) throws SessionNotValidException, NotPermittedException, MessageNotFoundException {
        GUser gUser = TokenUtil.validateToken(statusGetRequest.getToken());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From GMessage where id = :id");
        q.setParameter("id", statusGetRequest.getMsgId());
        GMessage gMessage = (GMessage) q.uniqueResult();
        if (gMessage == null) throw new MessageNotFoundException();
        if (gMessage.getRecipient().getId() != gUser.getId()) throw new NotPermittedException();
        return new StatusResponse(gMessage.readyToGet(), gMessage.getDeliveryDate());
    }

}
