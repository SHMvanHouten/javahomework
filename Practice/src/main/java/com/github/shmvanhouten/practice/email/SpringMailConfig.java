package com.github.shmvanhouten.practice.email;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Collections;


@Component
public class SpringMailConfig {

    @Bean
    public TemplateEngine emailTemplateEngine(){
         SpringTemplateEngine templateEngine = new SpringTemplateEngine();
         templateEngine.addTemplateResolver(htmlTemplateResolver());
         return templateEngine;
    }

    private ITemplateResolver htmlTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        return templateResolver;
    }
}
