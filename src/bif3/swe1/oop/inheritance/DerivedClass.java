package bif3.swe1.oop.inheritance;

public class DerivedClass extends BaseClass {
    // override baseclass method
    @Override
    public void method1() {
        System.out.println("method1 DerivedClass");
    }

    // try to hide baseclass method...
    // ... does not work in java (but would do with the new-modifyer in C#)
    //public void method2() {
    //    System.out.println("method2 DerivedClass");
    //}

    // different types of string interpolation
    public void method2(String parameterString) {
        System.out.println("method2 param DerivedClass " + parameterString);
    }

    @Override
    public void method3() {
        System.out.println("method3 DerivedClass - before");
        super.method3();
        System.out.println("method3 DerivedClass - after");
    }
}
