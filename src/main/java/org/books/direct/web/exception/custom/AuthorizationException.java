package org.books.direct.web.exception.custom;

public class AuthorizationException extends RuntimeException {

  private static final long serialVersionUID = 7234461506198757125L;

  public AuthorizationException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public AuthorizationException(String msg) {
     super(msg);
   }
}
