package springt.xml.dependency_injection;

//Instance factory method dependency injection
public class InstanceFactoryMethodDI {

    private static InstanceFactoryMethodDI instance = new InstanceFactoryMethodDI();
    private static ObjectForDI obj;

    public InstanceFactoryMethodDI createInstance(ObjectForDI o) {
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
