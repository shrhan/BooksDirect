package org.books.direct.web.appdirect;

import java.io.IOException;
import java.net.MalformedURLException;

import org.books.direct.dto.Event;
import org.books.direct.dto.EventResponse;
import org.books.direct.service.appdirect.EventService;
import org.books.direct.service.appdirect.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@RestController
@RequestMapping(value = { "/appdirect/v1/subscription/" }, produces = MediaType.APPLICATION_JSON_VALUE)
public class SubscriptionController {

   @Autowired
   private SubscriptionService subscriptionService;

   @Autowired
   private EventService eventService;


   /**
    * Creates new subscription
    * @param eventUrl url to retrieve the event informartion
    * @return EventResponse containing id of the created subscription
    * @throws MalformedURLException
    * @throws OAuthMessageSignerException
    * @throws OAuthExpectationFailedException
    * @throws OAuthCommunicationException
    * @throws IOException
    */
   @RequestMapping(value = "create", method = RequestMethod.GET)
   public ResponseEntity<EventResponse> createSubscription(@RequestParam(value = "eventUrl", required = true) String eventUrl) throws MalformedURLException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {
      Event event = eventService.retrieveEvent(eventUrl);

      return new ResponseEntity<EventResponse>(subscriptionService.createSubscription(event), HttpStatus.OK);
   }

   /**
    * Changes existing subscription
    * @param eventUrl url to retrieve the event informartion
    * @return EventResponse true if the subscription change is successful
    * @throws MalformedURLException
    * @throws OAuthMessageSignerException
    * @throws OAuthExpectationFailedException
    * @throws OAuthCommunicationException
    * @throws IOException
    */
   @RequestMapping(value = "change", method = RequestMethod.GET)
   public ResponseEntity<EventResponse> changeSubscription(@RequestParam(value = "eventUrl", required = true) String eventUrl) throws MalformedURLException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {
      Event event = eventService.retrieveEvent(eventUrl);

      return new ResponseEntity<EventResponse>(subscriptionService.changeSubscription(event), HttpStatus.OK);
   }

   /**
    * Changes existing subscription
    * @param eventUrl url to retrieve the event informartion
    * @return EventResponse true if the subscription cancel is successful
    * @throws MalformedURLException
    * @throws OAuthMessageSignerException
    * @throws OAuthExpectationFailedException
    * @throws OAuthCommunicationException
    * @throws IOException
    */
   @RequestMapping(value = "cancel", method = RequestMethod.GET)
   public ResponseEntity<EventResponse> cancelSubscription(@RequestParam(value = "eventUrl", required = true) String eventUrl) throws MalformedURLException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {
      Event event = eventService.retrieveEvent(eventUrl);

      return new ResponseEntity<EventResponse>(subscriptionService.cancelSubscription(event), HttpStatus.OK);
   }

}
