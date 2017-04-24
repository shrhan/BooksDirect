package org.books.direct.domain.entities.appdirect;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubscriptionUser implements Serializable {

   private static final long serialVersionUID = -4388942997865606326L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String email;

   private String firstName;

   private String language;

   private String lastName;

   private String locale;

   private String openId;

   private String uuid;

   @ManyToOne
   @JoinColumn(name = "subscription_account")
   private SubscriptionAccount subscription;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLanguage() {
      return language;
   }

   public void setLanguage(String language) {
      this.language = language;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   public String getOpenId() {
      return openId;
   }

   public void setOpenId(String openId) {
      this.openId = openId;
   }

   public String getUuid() {
      return uuid;
   }

   public void setUuid(String uuid) {
      this.uuid = uuid;
   }

   public SubscriptionAccount getSubscription() {
      return subscription;
   }

   public void setSubscription(SubscriptionAccount subscription) {
      this.subscription = subscription;
   }

}
