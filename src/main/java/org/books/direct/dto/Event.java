package org.books.direct.dto;

import org.books.direct.enums.appdirect.EventFlagEnum;
import org.books.direct.enums.appdirect.EventTypeEnum;

public class Event {

   private EventTypeEnum type;
   private MarketPlace marketplace;
   private String applicationUuid;
   private EventFlagEnum flag;
   private String returnUrl;
   private Creator creator;
   private Payload payload;
   public EventTypeEnum getType() {
      return type;
   }
   public void setType(EventTypeEnum type) {
      this.type = type;
   }
   public MarketPlace getMarketplace() {
      return marketplace;
   }
   public void setMarketplace(MarketPlace marketPlace) {
      this.marketplace = marketPlace;
   }
   public String getApplicationUuid() {
      return applicationUuid;
   }
   public void setApplicationUuid(String applicationUuid) {
      this.applicationUuid = applicationUuid;
   }
   public EventFlagEnum getFlag() {
      return flag;
   }
   public void setFlag(EventFlagEnum flag) {
      this.flag = flag;
   }
   public String getReturnUrl() {
      return returnUrl;
   }
   public void setReturnUrl(String returnUrl) {
      this.returnUrl = returnUrl;
   }
   public Creator getCreator() {
      return creator;
   }
   public void setCreator(Creator creator) {
      this.creator = creator;
   }
   public Payload getPayload() {
      return payload;
   }
   public void setPayload(Payload payload) {
      this.payload = payload;
   }


}
