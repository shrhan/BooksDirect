package org.books.direct.dto;

import java.util.List;
import java.util.Map;

public class Payload {

   private User user;

   private Account account;

   private Company company;

   private AddonInstance addonInstance;

   private AddonBinding addonBinding;

   private Notice notice;

   private Order order;

   private List<Map<String,String>> configuration;

   public User getUser() {
      return user;
   }
   public void setUser(User user) {
      this.user = user;
   }
   public Account getAccount() {
      return account;
   }
   public void setAccount(Account account) {
      this.account = account;
   }
   public Company getCompany() {
      return company;
   }
   public void setCompany(Company company) {
      this.company = company;
   }
   public AddonInstance getAddonInstance() {
      return addonInstance;
   }
   public void setAddonInstance(AddonInstance addonInstance) {
      this.addonInstance = addonInstance;
   }
   public AddonBinding getAddonBinding() {
      return addonBinding;
   }
   public void setAddonBinding(AddonBinding addonBinding) {
      this.addonBinding = addonBinding;
   }
   public Notice getNotice() {
      return notice;
   }
   public void setNotice(Notice notice) {
      this.notice = notice;
   }
   public Order getOrder() {
      return order;
   }
   public void setOrder(Order order) {
      this.order = order;
   }

   public List<Map<String, String>> getConfiguration() {
      return configuration;
   }

   public void setConfiguration(List<Map<String, String>> configuration) {
      this.configuration = configuration;
   }

}
