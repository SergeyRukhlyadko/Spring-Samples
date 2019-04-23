package springt.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ServiceInit {

    @Autowired
    private Environment env;

    private Name name;
    private Age age;
    private Sex sex;
    private Names names;

    public ServiceInit(Name name, Age age, Names names) {
        this.name = name;
        this.age = age;
        this.names = names;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + ": " + names.getProperties().get("name.din") + " " + age + " " + sex.getSex();
    }

    public Environment getEnv() {
        return env;
    }
}
