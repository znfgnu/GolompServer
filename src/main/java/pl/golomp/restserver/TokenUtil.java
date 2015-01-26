package pl.golomp.restserver;

import org.hibernate.Query;
import org.hibernate.Session;
import pl.golomp.restserver.entities.GToken;
import pl.golomp.restserver.entities.GUser;
import pl.golomp.restserver.exceptions.SessionNotValidException;

/**
 * Created by konrad on 26.01.15.
 */
public class TokenUtil {
    public static GUser validateToken(String tokenString) throws SessionNotValidException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from GToken where token = :token and loggedOut = false ");
        q.setParameter("token", tokenString);
        GToken gToken = (GToken) q.uniqueResult();
        if (gToken == null) throw new SessionNotValidException();
        return gToken.getgUser();
    }
}
