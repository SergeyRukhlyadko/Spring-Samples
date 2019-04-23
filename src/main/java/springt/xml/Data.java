package springt.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Data {

    @Autowired
    @Qualifier("w")
    private Sex sex;

    public String getSex() {
        return sex.getSex();
    }

    @PostConstruct
    public void sexConstruct() {
        System.out.println("Sex constructed");
    }

    @PreDestroy
    public void sexDestroy() {
        System.out.println("Sex destroyed");
    }
}
