package org.books.direct.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class JsonUtil {

   private static final ObjectReader reader = new ObjectMapper().reader();

   public static Object deserializeJson(final String json, Class clazz) throws IOException {
      return reader.forType(clazz).readValue(json);
   }

}
