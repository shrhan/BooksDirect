package org.books.direct.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class TestUtils {

  /***
   * Disallow construction of this class. Must use static methods.
   */
  private TestUtils() {
  };

  /**
   * Read File content
   *
   * @param fileName : Name of File
   * @return : File content
   * @throws IOException
   */
  public static String readFile(final String fileName) throws IOException {
    InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
    return IOUtils.toString(inputStream);
  }
}
