package org.books.direct.utils;

import java.io.IOException;

import org.books.direct.web.exception.custom.UnserializableException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class JsonUtil {

   private static final ObjectReader reader = new ObjectMapper().reader();

   public static Object deserializeJson(final String json, Class clazz) throws IOException {
      try {
         return reader.forType(clazz).readValue(json);
       } catch (JsonProcessingException ex) {
         throw new UnserializableException(ex);
       }
   }

}
