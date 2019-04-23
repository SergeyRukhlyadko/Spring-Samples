package springt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import springt.annotation.Basic;
import springt.annotation.BasicBean;
import springt.annotation.Builder;
import springt.annotation.CustomBean;
import springt.annotation.Factory;
import springt.xml.Data;
import springt.xml.ServiceInit;
import springt.xml.dependency_injection.ConstructorDI;
import springt.xml.dependency_injection.InstanceFactoryMethodDI;
import springt.xml.dependency_injection.SetterDI;
import springt.xml.dependency_injection.StaticFactoryMethodDI;
import springt.xml.instantiation.ConstructorInit;
import springt.xml.instantiation.InstanceFactoryMethodInit;
import springt.xml.instantiation.StaticFactoryMethodInit;
import util.SpaceAppender;

public class Main {

    public static void main(String... args) {
        SpaceAppender sa = new SpaceAppender();

        //Create Container
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        //XML
        System.out.println("--XML--");

        //Instantiation
        System.out.println(sa.appendBefore("*Instantiation with XML*", 1));
        ConstructorInit conInit = context.getBean("constructorInit", ConstructorInit.class);
        StaticFactoryMethodInit staticFMInit = context.getBean("staticFactoryMethodInit", StaticFactoryMethodInit.class);
        InstanceFactoryMethodInit instanceFMInit = context.getBean("instanceFactoryMethodInitBean", InstanceFactoryMethodInit.class);

        System.out.println(sa.appendBefore("#Constructor instantiation", 2));
        System.out.println(sa.appendBefore(conInit.toString(), 3));
        System.out.println(sa.appendBefore("#Static factory method instantiation", 2));
        System.out.println(sa.appendBefore(staticFMInit.toString(), 3));
        System.out.println(sa.appendBefore("#Instance factory method instantiation", 2));
        System.out.println(sa.appendBefore(instanceFMInit.toString(), 3));
        System.out.println();

        //Dependency injection
        System.out.println(sa.appendBefore("*Dependency injection with XML*", 1));
        ConstructorDI conDI = context.getBean("constructorDI", ConstructorDI.class);
        SetterDI setterDI = context.getBean("setterDI", SetterDI.class);
        StaticFactoryMethodDI staticFMDI = context.getBean("staticFactoryMethodDI", StaticFactoryMethodDI.class);
        InstanceFactoryMethodDI instanceFMDI = context.getBean("instanceFactoryMethodDIBean", InstanceFactoryMethodDI.class);

        System.out.println(sa.appendBefore("#Constructor-based dependency injection", 2));
        System.out.println(sa.appendBefore(conDI.toString(), 3));
        System.out.println(sa.appendBefore("#Setter-based dependency injection", 2));
        System.out.println(sa.appendBefore(setterDI.toString(), 3));
        System.out.println(sa.appendBefore("#Static factory method dependency injection", 2));
        System.out.println(sa.appendBefore(staticFMDI.toString(), 3));
        System.out.println(sa.appendBefore("#Instance factory method dependency injection", 2));
        System.out.println(sa.appendBefore(instanceFMDI.toString(), 3));
        System.out.println();



        //XML + ANNOTATIONS
        ServiceInit serviceInit = context.getBean("serviceInit", ServiceInit.class);
        System.out.println(serviceInit.toString());
        Data data = context.getBean("data", Data.class);
        System.out.println(data.getSex());
        context.getAutowireCapableBeanFactory().destroyBean(data);

        System.out.println();
        //ANNOTATIONS
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("springt.annotation");
        ctx.refresh();
        System.out.println("All beans");
        for(String s : ctx.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        System.out.println("------------------------------");
        Builder builder = ctx.getBean("builder", Builder.class);
        System.out.println(builder.print() + " " + builder.getS());
        Builder builderFromFactory = ctx.getBean("getInstance", Builder.class);
        System.out.println(builderFromFactory.print() + " " + builder.getS());
        Factory factory = ctx.getBean("factory", Factory.class);
        System.out.println(factory.getBuilder());
        System.out.println(factory + "\n" + builder + "\n" + builderFromFactory);
        Object o = ctx.getBean("customize");
        System.out.println(o);
        Basic basic = ctx.getBean("basic", Basic.class);
        System.out.println(basic.basicBean());
        BasicBean basicBean = ctx.getBean("basicBean", BasicBean.class);
        System.out.println(basicBean);
        CustomBean customBean = ctx.getBean("customBean", CustomBean.class);
        System.out.println(customBean + " " + basicBean.getCustomBean());
        CustomBean customBean2 = ctx.getBean("customBean", CustomBean.class);
        System.out.println(customBean2);
        BasicBean basicBeanAgain = ctx.getBean("basicBeanAgain", BasicBean.class);
        System.out.println(basicBeanAgain + " " + basicBeanAgain.getCustomBean());
        //Profiles
        Environment env = serviceInit.getEnv();
        for(String s : env.getDefaultProfiles()) {
            System.out.println(s);
        }
    }
}
