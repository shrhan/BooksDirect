package org.books.direct.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "oauth")
public class OAuthConfig {

  private String key;
  private String secret;

  public String getKey() {
    return key;
  }

  public void setKey(final String key) {
    this.key = key;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(final String secret) {
    this.secret = secret;
  }
}
