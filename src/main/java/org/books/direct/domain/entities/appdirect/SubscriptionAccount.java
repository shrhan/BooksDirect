package org.books.direct.domain.entities.appdirect;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.books.direct.enums.appdirect.AccountStatusEnum;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class SubscriptionAccount implements Serializable {

   private static final long serialVersionUID = 4190704826030611835L;

   @Id
   @GeneratedValue(generator="system-uuid")
   @GenericGenerator(name="system-uuid", strategy = "uuid2")
   private String accountIdentifier;

   private AccountStatusEnum status;

   private String creatorEmail;

   private String creatorUuid;

   private String companyName;

   private String companyUuid;

   private String pricingDuration;

   private int bytes;

   private int userCount;

   @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
   private Set<SubscriptionUser> subscriptionUsers = new HashSet<SubscriptionUser>();

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

   public String getCreatorEmail() {
      return creatorEmail;
   }

   public void setCreatorEmail(String creatorEmail) {
      this.creatorEmail = creatorEmail;
   }

   public String getCreatorUuid() {
      return creatorUuid;
   }

   public void setCreatorUuid(String creatorUuid) {
      this.creatorUuid = creatorUuid;
   }

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   public String getCompanyUuid() {
      return companyUuid;
   }

   public void setCompanyUuid(String companyUuid) {
      this.companyUuid = companyUuid;
   }

   public String getPricingDuration() {
      return pricingDuration;
   }

   public void setPricingDuration(String pricingDuration) {
      this.pricingDuration = pricingDuration;
   }

   public int getBytes() {
      return bytes;
   }

   public void setBytes(int bytes) {
      this.bytes = bytes;
   }

   public int getUserCount() {
      return userCount;
   }

   public void setUserCount(int userCount) {
      this.userCount = userCount;
   }

   public Set<SubscriptionUser> getSubscriptionUsers() {
      return subscriptionUsers;
   }

   public void setSubscriptionUsers(Set<SubscriptionUser> subscriptionUsers) {
      this.subscriptionUsers = subscriptionUsers;
   }

}
