package com.litsynp.demo;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/** Disable default Spring Security */
@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public LocaleResolver localeResolver() {
    AcceptHeaderLocaleResolver ahlr = new AcceptHeaderLocaleResolver();
    ahlr.setDefaultLocale(Locale.US);
    return ahlr;
  }

}
