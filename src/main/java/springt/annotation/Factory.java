package springt.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.inject.Inject;

@Configuration
public class Factory {

    private Builder builder;

    @Bean
    public Builder getInstance() {
        return new Builder();
    }

    @Inject
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Builder getBuilder() {
        return builder;
    }
}
