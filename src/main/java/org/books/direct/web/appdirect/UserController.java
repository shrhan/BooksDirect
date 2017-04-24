package org.books.direct.web.appdirect;

import java.io.IOException;
import java.net.MalformedURLException;

import org.books.direct.dto.Event;
import org.books.direct.dto.EventResponse;
import org.books.direct.service.appdirect.EventService;
import org.books.direct.service.appdirect.UserService;
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
@RequestMapping(value = { "/appdirect/v1/user/" }, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

   @Autowired
   private EventService eventService;

   @Autowired
   private UserService userService;

   /**
    * @param eventUrl url to retrieve the event informartion
    * @return
    * @throws MalformedURLException
    * @throws OAuthMessageSignerException
    * @throws OAuthExpectationFailedException
    * @throws OAuthCommunicationException
    * @throws IOException
    */
   @RequestMapping(value = "assign", method = RequestMethod.GET)
   public ResponseEntity<EventResponse> assignUser(@RequestParam(value = "eventUrl", required = true) String eventUrl) throws MalformedURLException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {
      Event event = eventService.retrieveEvent(eventUrl);

      return new ResponseEntity<EventResponse>(userService.assignUser(event), HttpStatus.OK);
   }

   /**
    * @param eventUrl url to retrieve the event informartion
    * @return
    * @throws MalformedURLException
    * @throws OAuthMessageSignerException
    * @throws OAuthExpectationFailedException
    * @throws OAuthCommunicationException
    * @throws IOException
    */
   @RequestMapping(value = "unassign", method = RequestMethod.GET)
   public ResponseEntity<EventResponse> unassignUser(@RequestParam(value = "eventUrl", required = true) String eventUrl) throws MalformedURLException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {
      Event event = eventService.retrieveEvent(eventUrl);

      return new ResponseEntity<EventResponse>(userService.assignUser(event), HttpStatus.OK);
   }

}
