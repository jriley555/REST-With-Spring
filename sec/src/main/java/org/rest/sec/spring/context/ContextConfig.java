package org.rest.sec.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ImportResource("classpath*:secContextConfig.xml")
@ComponentScan({ "org.rest.sec.model" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource({ "classpath:persistence-${persistenceTarget:h2}.properties", "classpath:env-${envTarget:dev}.properties", "classpath:web-${webTarget:dev}.properties" })
public class ContextConfig {

    public ContextConfig() {
        super();
    }

    // beans

    /**/@Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        // pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;
    }

    /*@Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setCacheSeconds(10);
        return null;
    }*/

}
