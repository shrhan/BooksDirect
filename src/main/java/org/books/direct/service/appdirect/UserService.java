package org.books.direct.service.appdirect;

import org.books.direct.domain.entities.appdirect.SubscriptionAccount;
import org.books.direct.domain.entities.appdirect.SubscriptionUser;
import org.books.direct.domain.repository.appdirect.SubscriptionAccountRepository;
import org.books.direct.domain.repository.appdirect.SubscriptionUserRepository;
import org.books.direct.dto.Account;
import org.books.direct.dto.Event;
import org.books.direct.dto.EventResponse;
import org.books.direct.enums.appdirect.EventErrorCodeEnum;
import org.books.direct.enums.appdirect.EventTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
   private SubscriptionAccountRepository subscriptionAccountRepository;

   @Autowired
   private SubscriptionUserRepository subscriptionUserRepository;


   /**
    * Assigns user to a subscription account
    * @param event Event details
    * @return EventResponse containing success or error information
    */
   public EventResponse assignUser(Event event) {

      Account account = event.getPayload().getAccount();
      if ( event == null || event.getType() != EventTypeEnum.USER_ASSIGNMENT || account == null) {
         return new EventResponse(false, EventErrorCodeEnum.INVALID_RESPONSE, "Event type is not valid.");
      }

      SubscriptionAccount subscription = subscriptionAccountRepository.findOne(account.getAccountIdentifier());
      if ( subscription == null ) {
         return new EventResponse(false, EventErrorCodeEnum.ACCOUNT_NOT_FOUND, "Subscription account not found.");
      }

      SubscriptionUser user = new SubscriptionUser();
      user.setFirstName(event.getPayload().getUser().getFirstName());
      user.setLastName(event.getPayload().getUser().getLastName());
      user.setEmail(event.getPayload().getUser().getEmail());
      user.setLocale(event.getPayload().getUser().getLocale());
      user.setOpenId(event.getPayload().getUser().getOpenId());
      user.setUuid(event.getPayload().getUser().getUuid());
      user.setSubscription(subscription);

      subscriptionUserRepository.save(user);

      return new EventResponse(true);
   }

   /**
    * Unassigns user from a subscription account
    * @param event Event details
    * @return EventResponse containing success or error information
    */
   public EventResponse unassignUser(Event event) {

      Account account = event.getPayload().getAccount();
      if ( event == null || event.getType() != EventTypeEnum.USER_UNASSIGNMENT || account == null) {
         return new EventResponse(false, EventErrorCodeEnum.INVALID_RESPONSE, "Event type is not valid.");
      }

      SubscriptionUser subscriptionUser = subscriptionUserRepository.findByEmailAndSubscriptionAccountIdentifier(event.getPayload().getUser().getEmail(), account.getAccountIdentifier());
      if ( subscriptionUser == null ) {
         return new EventResponse(false, EventErrorCodeEnum.ACCOUNT_NOT_FOUND, "User account not found.");
      }
      subscriptionUser.setSubscription(null);

      subscriptionUserRepository.save(subscriptionUser);

      return new EventResponse(true);
   }

}
