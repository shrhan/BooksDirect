package org.books.direct.web.exception;

import javax.servlet.http.HttpServletRequest;

import org.books.direct.dto.EventResponse;
import org.books.direct.enums.appdirect.EventErrorCodeEnum;
import org.books.direct.web.exception.custom.AuthorizationException;
import org.books.direct.web.exception.custom.ForbiddenOperationException;
import org.books.direct.web.exception.custom.UnserializableException;
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
  public EventResponse HandleIncorrectUpdateSemanticsDataAccess(final HttpServletRequest req, final Exception ex) {
     LOGGER.error(req.getRequestURL().toString(), ex);
     return new EventResponse(false,EventErrorCodeEnum.FORBIDDEN,ex.getMessage());
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(AuthorizationException.class)
  @ResponseBody
  public EventResponse handleAuthorizationException(final HttpServletRequest req, final Exception ex) {
     LOGGER.error(req.getRequestURL().toString(), ex);
     return new EventResponse(false,EventErrorCodeEnum.UNAUTHORIZED,ex.getMessage());
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(UnserializableException.class)
  @ResponseBody
  public EventResponse handleUnSerializableException(final HttpServletRequest req, final Exception ex) {
     LOGGER.error(req.getRequestURL().toString(), ex);
     return new EventResponse(false,EventErrorCodeEnum.UNKNOWN_ERROR,ex.getLocalizedMessage());
  }
}
