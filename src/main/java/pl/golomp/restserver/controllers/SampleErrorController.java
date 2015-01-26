package pl.golomp.restserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.golomp.restserver.exceptions.SampleException;
import pl.golomp.restserver.responses.ErrorResponse;

/**
 * Created by konrad on 25.01.15.
 */
@RestController
@RequestMapping("/error")
public class SampleErrorController {
    @RequestMapping
    public @ResponseBody String errorResponse() throws SampleException {
        if (666 == 666) throw new SampleException();
        return "To się nie wyświetli";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SampleException.class)
    public @ResponseBody ErrorResponse example() {
        System.out.println("Exception caught!");
        return new ErrorResponse(666, "yolo");
    }
}
