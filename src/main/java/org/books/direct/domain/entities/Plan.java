package org.books.direct.domain.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.books.direct.enums.PlanType;

@Entity
@Table(name="plans")
public class Plan implements Serializable {

   private static final long serialVersionUID = 8721160364588259720L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @NotNull
   @Enumerated(EnumType.STRING)
   private PlanType planType;

   @NotNull
   private double price;

   private String description;

   private boolean active;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public PlanType getPlanType() {
      return planType;
   }

   public void setPlanType(PlanType planType) {
      this.planType = planType;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }
}
