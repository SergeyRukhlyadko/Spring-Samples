package springt.xml.dependency_injection;

import java.beans.ConstructorProperties;

//Constructor-based dependency injection
public class ConstructorDI {

    private ObjectForDI obj;
    private String str;
    private int day;
    private int month;
    private int year;

    @ConstructorProperties({"obj", "str", "day", "month", "year"})
    public ConstructorDI(ObjectForDI obj, String str, int day, int month, int year) {
        this.obj = obj;
        this.str = str;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(super.toString())
                                  .append(": ")
                                  .append(obj.toString())
                                  .append(", ")
                                  .append(str)
                                  .append(", ")
                                  .append(day)
                                  .append(".")
                                  .append(month)
                                  .append(".")
                                  .append(year)
                                  .toString();
    }
}
