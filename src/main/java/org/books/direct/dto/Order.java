package org.books.direct.dto;

import java.util.List;

public class Order {

   private String editionCode;

   private String addonOfferingCode;

   private String pricingDuration;

   private List<Item> items;

   public String getEditionCode() {
      return editionCode;
   }
   public void setEditionCode(String editionCode) {
      this.editionCode = editionCode;
   }
   public String getAddonOfferingCode() {
      return addonOfferingCode;
   }
   public void setAddonOfferingCode(String addonOfferingCode) {
      this.addonOfferingCode = addonOfferingCode;
   }
   public String getPricingDuration() {
      return pricingDuration;
   }
   public void setPricingDuration(String pricingDuration) {
      this.pricingDuration = pricingDuration;
   }
   public List<Item> getItems() {
      return items;
   }
   public void setItems(List<Item> items) {
      this.items = items;
   }

}
