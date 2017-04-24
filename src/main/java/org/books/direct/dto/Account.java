package org.books.direct.dto;

import org.books.direct.enums.appdirect.AccountStatusEnum;

public class Account {

   private String accountIdentifier;

   private AccountStatusEnum status;

   private String parentAccountIdentifier;

   public String getAccountIdentifier() {
      return accountIdentifier;
   }

   public void setAccountIdentifier(String accountIdentifier) {
      this.accountIdentifier = accountIdentifier;
   }

   public AccountStatusEnum getStatus() {
      return status;
   }

   public void setStatus(AccountStatusEnum status) {
      this.status = status;
   }

   public String getParentAccountIdentifier() {
      return parentAccountIdentifier;
   }

   public void setParentAccountIdentifier(String parentAccountIdentifier) {
      this.parentAccountIdentifier = parentAccountIdentifier;
   }

}
