package org.books.direct.dto;

import org.books.direct.enums.appdirect.EventErrorCodeEnum;

public class EventResponse {

   private String accountIdentifier;

   private String userIdentifier;

   private EventErrorCodeEnum errorCode;

   private String message;

   private boolean success;

   public EventResponse() {

   }

   public EventResponse(boolean success, EventErrorCodeEnum errorCode, String message) {
      this.success = success;
      this.errorCode = errorCode;
      this.message = message;
   }

   public EventResponse(boolean success){
      this.success = success;
   }

   public EventResponse(boolean success, String accountIdentifier){
      this.success = success;
      this.accountIdentifier = accountIdentifier;
   }

   public String getAccountIdentifier() {
      return accountIdentifier;
   }
   public void setAccountIdentifier(String accountIdentifier) {
      this.accountIdentifier = accountIdentifier;
   }
   public String getUserIdentifier() {
      return userIdentifier;
   }
   public void setUserIdentifier(String userIdentifier) {
      this.userIdentifier = userIdentifier;
   }
   public EventErrorCodeEnum getErrorCode() {
      return errorCode;
   }
   public void setErrorCode(EventErrorCodeEnum errorCode) {
      this.errorCode = errorCode;
   }
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
   public boolean isSuccess() {
      return success;
   }
   public void setSuccess(boolean success) {
      this.success = success;
   }

}
