package sg.ctx.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import sg.ctx.commons.exception.model.ExceptionResponse;

import java.util.Date;
import java.util.UUID;

/**
 * @author yu.miao
 */

@ControllerAdvice
public class ExceptionHandel {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandel.class);

    private static final String ERROR_404 = "whoops, the resource you're looking for isn't here";
    private static final String ERROR_500 = "the server encountered an unexpected";

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse e404() {
        var response = new ExceptionResponse();
        response.setId(UUID.randomUUID().toString());
        response.setTimestamp(new Date());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(ERROR_404);
        return response;
    }


    /**
     * @param exception exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse e500(Exception exception) {
        var id = UUID.randomUUID().toString();
        logger.error(String.format("Exception Id: ", id), exception);

        var response = new ExceptionResponse();
        response.setId(id);
        response.setTimestamp(new Date());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage(ERROR_500);
        return response;
    }
}
