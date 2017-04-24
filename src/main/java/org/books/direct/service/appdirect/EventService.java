package org.books.direct.service.appdirect;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.books.direct.config.OAuthConfig;
import org.books.direct.dto.Event;
import org.books.direct.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@Service
public class EventService {

   @Autowired
   private OAuthConfig oauthConfig;

   public Event retrieveEvent(String eventUrl) throws MalformedURLException, IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException{

      OAuthConsumer consumer = new DefaultOAuthConsumer(oauthConfig.getKey(), oauthConfig.getSecret());

      HttpURLConnection request = (HttpURLConnection) new URL(eventUrl).openConnection();
      consumer.sign(request);
      request.connect();

      return (Event) JsonUtil.deserializeJson(IOUtils.toString(request.getInputStream()), Event.class);
   }
}
