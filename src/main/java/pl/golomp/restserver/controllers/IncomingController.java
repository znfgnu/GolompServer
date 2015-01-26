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
import pl.golomp.restserver.exceptions.SessionNotValidException;
import pl.golomp.restserver.requests.IncomingRequest;
import pl.golomp.restserver.responses.IncomingResponse;

import java.util.List;

/**
 * Created by konrad on 26.01.15.
 */
@Controller
@RequestMapping("/incoming")
public class IncomingController {
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody IncomingResponse incoming(@RequestBody IncomingRequest incomingRequest) throws SessionNotValidException {
        GUser gUser = TokenUtil.validateToken(incomingRequest.getToken());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("select id from GMessage where recipient = :recipient and recvDate is null ");
        q.setParameter("recipient", gUser);
        List<Long> list = q.list();
        return new IncomingResponse(list);
    }
}
