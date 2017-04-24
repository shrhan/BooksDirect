package org.books.direct.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User implements Serializable {

   private static final long serialVersionUID = -7478060895655595798L;

    @Id
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    private String phoneNumber;

    @NotNull
    private boolean active;

    @NotNull
    private Plan plan;

    @NotNull
    private LocalDate planStartDate;

    @NotNull
    private LocalDate packageEndDate;

    public User(String name, String userName, String password) {
        this.name = name;
        this.username = userName;
        this.password = password;
    }

    User(){

    }

   public String getUsername() {
      return username;
   }

   public String getName() {
      return name;
   }

   public String getPassword() {
      return password;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public LocalDate getPackageStartDate() {
      return planStartDate;
   }

   public void setPackageStartDate(LocalDate packageStartDate) {
      this.planStartDate = packageStartDate;
   }

   public LocalDate getPackageEndDate() {
      return packageEndDate;
   }

   public void setPackageEndDate(LocalDate packageEndDate) {
      this.packageEndDate = packageEndDate;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }
}
