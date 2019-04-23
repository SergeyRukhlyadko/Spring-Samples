package springt.xml.dependency_injection;

//Static factory method dependency injection
public class StaticFactoryMethodDI {

    private static StaticFactoryMethodDI instance = new StaticFactoryMethodDI();
    private static ObjectForDI obj;

    private StaticFactoryMethodDI() {}

    public static StaticFactoryMethodDI createInstance(ObjectForDI o) {
        obj = o;
        return instance;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                                  .append(": ")
                                  .append(obj)
                                  .toString();
    }
}
