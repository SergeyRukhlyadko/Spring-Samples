package springt.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Builder {

    private String s;

    @Bean
    public void customize() {
        this.s = "Customized";
    }

    public String getS() {
        return s;
    }

    public String print() {
        return String.valueOf("Builder");
    }
}
