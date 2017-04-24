package org.books.direct.web.exception;

import javax.servlet.http.HttpServletRequest;

import org.books.direct.web.exception.custom.AuthorizationException;
import org.books.direct.web.exception.custom.ForbiddenOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
class GlobalControllerExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler({ IncorrectUpdateSemanticsDataAccessException.class, ForbiddenOperationException.class })
  @ResponseBody
  public ErrorInfo HandleIncorrectUpdateSemanticsDataAccess(final HttpServletRequest req, final Exception ex) {
    return new ErrorInfo(req.getRequestURL().toString(), ex);
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(AuthorizationException.class)
  @ResponseBody
  public ErrorInfo handleAuthorizationException(final HttpServletRequest req, final Exception ex) {
    LOGGER.error(req.getRequestURL().toString(), ex);
    return new ErrorInfo(req.getRequestURL().toString(), ex);
  }
}
