package org.books.direct.service.appdirect;

import java.util.List;

import org.books.direct.domain.entities.appdirect.SubscriptionAccount;
import org.books.direct.domain.repository.appdirect.SubscriptionAccountRepository;
import org.books.direct.dto.Account;
import org.books.direct.dto.Event;
import org.books.direct.dto.EventResponse;
import org.books.direct.dto.Item;
import org.books.direct.enums.appdirect.AccountStatusEnum;
import org.books.direct.enums.appdirect.EventErrorCodeEnum;
import org.books.direct.enums.appdirect.EventTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

   @Autowired
   private SubscriptionAccountRepository subscriptionAccountRepository;

   /**
    * Creates subscription
    * @param event Event details
    * @return EventResponse containing success or error information
    */
   public EventResponse createSubscription(Event event) {
      if ( event == null || event.getType() != EventTypeEnum.SUBSCRIPTION_ORDER ) {
         return new EventResponse(false, EventErrorCodeEnum.INVALID_RESPONSE, "Event type is not valid.");
      }

      SubscriptionAccount customerAccount = new SubscriptionAccount();
      customerAccount.setCompanyName(event.getPayload().getCompany().getName());
      customerAccount.setCompanyUuid(event.getPayload().getCompany().getUuid());
      customerAccount.setCreatorEmail(event.getCreator().getEmail());
      customerAccount.setCreatorUuid(event.getCreator().getUuid());
      customerAccount.setStatus(AccountStatusEnum.ACTIVE);
      customerAccount.setPricingDuration(event.getPayload().getOrder().getPricingDuration());
      customerAccount.setUserCount(getUserCount(event.getPayload().getOrder().getItems(),"USER"));
      customerAccount.setBytes(getUserCount(event.getPayload().getOrder().getItems(),"GIGABYTE"));
      subscriptionAccountRepository.save(customerAccount);

      return new EventResponse(true, customerAccount.getAccountIdentifier());
   }

   /**
    * Modifies subscription
    * @param event Event details
    * @return EventResponse containing success or error information
    */
   public EventResponse changeSubscription(Event event) {
      Account account = event.getPayload().getAccount();
      if ( event == null || event.getType() != EventTypeEnum.SUBSCRIPTION_CHANGE || account == null) {
         return new EventResponse(false, EventErrorCodeEnum.INVALID_RESPONSE, "Event type is not valid.");
      }

      SubscriptionAccount customerAccount = subscriptionAccountRepository.findOne(account.getAccountIdentifier());
      if ( customerAccount == null ) {
         return new EventResponse(false, EventErrorCodeEnum.ACCOUNT_NOT_FOUND, "Subscription account not found.");
      }

      customerAccount.setPricingDuration(event.getPayload().getOrder().getPricingDuration());
      customerAccount.setUserCount(getUserCount(event.getPayload().getOrder().getItems(),"USER"));
      customerAccount.setBytes(getUserCount(event.getPayload().getOrder().getItems(),"GIGABYTE"));
      customerAccount.setPricingDuration(event.getPayload().getOrder().getPricingDuration());
      subscriptionAccountRepository.save(customerAccount);

      return new EventResponse(true);
   }

   /**
    * Cancels subscription
    * @param event Event details
    * @return EventResponse containing success or error information
    */
   public EventResponse cancelSubscription(Event event) {
      Account account = event.getPayload().getAccount();
      if ( event == null || event.getType() != EventTypeEnum.SUBSCRIPTION_CANCEL || account == null) {
         return new EventResponse(false, EventErrorCodeEnum.INVALID_RESPONSE, "Event type is not valid.");
      }

      SubscriptionAccount customerAccount = subscriptionAccountRepository.findOne(account.getAccountIdentifier());
      if ( customerAccount == null ) {
         return new EventResponse(false, EventErrorCodeEnum.ACCOUNT_NOT_FOUND, "Subscription account not found.");
      }

      customerAccount.setStatus(AccountStatusEnum.CANCELLED);
      subscriptionAccountRepository.save(customerAccount);

      return new EventResponse(true);
   }

   /**
    * Returns the count of param specified in unit.
    * @param items List of order items
    * @param unit Unit to retrieve count from.
    * @return unit count
    */
   private int getUserCount(List<Item> items, String unit) {
      for(Item item : items) {
         if(unit.matches(item.getUnit()))
            return item.getQuantity();
      }
      return 0;
   }

}
