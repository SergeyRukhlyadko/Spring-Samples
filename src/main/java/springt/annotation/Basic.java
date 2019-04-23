package springt.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Basic {

    @Bean
    public BasicBean basicBean() {
        return new BasicBean(customBean());
    }

    @Bean
    public BasicBean basicBeanAgain() {
        return new BasicBean(customBean());
    }

    @Bean
    public CustomBean customBean() {
        return new CustomBean();
    }
}
