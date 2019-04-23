package springt.xml.instantiation;

//Instantiation with a static factory method
public class StaticFactoryMethodInit {

    private static StaticFactoryMethodInit instance = new StaticFactoryMethodInit();

    private StaticFactoryMethodInit() {}

    public static StaticFactoryMethodInit createInstance() { return instance; }
}
