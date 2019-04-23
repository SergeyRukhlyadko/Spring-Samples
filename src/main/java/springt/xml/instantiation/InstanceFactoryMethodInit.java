package springt.xml.instantiation;

//Instantiation by using an instance factory method
public class InstanceFactoryMethodInit {

    private static InstanceFactoryMethodInit instance = new InstanceFactoryMethodInit();

    public InstanceFactoryMethodInit createInstance() { return instance; }

}
