package bif3.swe1.oop.classes;

import lombok.Getter;
import lombok.Setter;

/*
    PLS NOTE THAT THESE ARE ONLY GUIDELINES.
    THEY MAY VARY FROM COMPANY TO COMPANY!

    - Use pascal casing for members (fields and methods)
    - Keep your variables in order:
        declare all member variables at the top of a class, with static variables at the very top
        first public, then private
    - group by type
        const/static/readonly
        properties
        class variables
 */

public class ClassWithMembers {
    // constant values are not changeable
    public static final float CONSTANT_VALUE = 3.14f;
    // static values are the same value over all instances
    // can only be changed in static methods
    public static String STATIC_STRING = "Value";
    // final can only be set here or in constructor
    public final int readOnlyInt = 0;
    public final int readOnlyInt2;

    // property with getters & setters
    private int intProperty;

    public int getIntProperty() {
        return intProperty;
    }

    public void setIntProperty(int intProperty) {
        this.intProperty = intProperty;
    }

    // full auto property - thx to lombok-library
    @Getter
    @Setter
    private int nicerIntProperty;

    // property without setter but with default value
    private int readProperty;

    public int getReadProperty() {
        return readProperty;
    }

    // auto property with lombok
    @Getter
    private int nicerReadProperty = 0;

    // only accessable in derived classes
    protected String protectedString = "default";

    // only accessable in this class
    private int privateVariable = 7;

    // default constructor
    public ClassWithMembers() {
        readOnlyInt2 = 0;
    }

    // overloaded constructor
    public ClassWithMembers(int x, int y) {
        readOnlyInt2 = privateVariable;
        changeValue(x, y);
    }

    // public member methods
    public void changeSomeValues(int newValue) {
        privateVariable = newValue;
        readProperty = newValue;    // or introduce and use private void setReadProperty(...)
    }

    public void writeSomething() {
        System.out.println("Write Something");
    }

    private void changeValue(int x, int y) {
        privateVariable = x + y;
    }

}
