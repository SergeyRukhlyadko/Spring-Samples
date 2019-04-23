package springt.xml.dependency_injection;

//Setter-based dependency injection
public class SetterDI {

    private ObjectForDI obj;
    private String str;

    public void setObjectForDI(ObjectForDI obj) { this.obj = obj; }

    public void setStringParameter(String str) { this.str = str; }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                                  .append(": ")
                                  .append(obj.toString())
                                  .append(", ")
                                  .append(str)
                                  .toString();
    }
}
