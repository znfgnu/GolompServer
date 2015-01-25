package pl.golomp.restserver.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.golomp.restserver.responses.GreetingResponse;

import java.io.Serializable;

/**
 * Created by konrad on 24.01.15.
 */
@Controller
@RequestMapping("/greetings")
public class GreetingController implements Serializable {
    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public @ResponseBody GreetingResponse pozdro() {
        return new GreetingResponse("Yo!");
    }
}
