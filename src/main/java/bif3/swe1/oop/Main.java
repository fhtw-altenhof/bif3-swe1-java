package bif3.swe1.oop;

import bif3.swe1.oop.classes.ClassWithMembers;
import bif3.swe1.oop.inheritance.BaseClass;
import bif3.swe1.oop.inheritance.DerivedClass;
import bif3.swe1.oop.polymorphism.abstractbaseclass.AbstractShape;
import bif3.swe1.oop.polymorphism.abstractbaseclass.DerivedCircle;
import bif3.swe1.oop.polymorphism.abstractbaseclass.DerivedCompoundShape;
import bif3.swe1.oop.polymorphism.abstractbaseclass.DerivedLine;
import bif3.swe1.oop.polymorphism.interfacebasedshapes.BetterCircle;
import bif3.swe1.oop.polymorphism.interfacebasedshapes.BetterCompoundShape;
import bif3.swe1.oop.polymorphism.interfacebasedshapes.BetterLine;
import bif3.swe1.oop.polymorphism.interfacebasedshapes.BetterShapeCompositionInterface;
import bif3.swe1.oop.polymorphism.optimizedsolution.Circle;
import bif3.swe1.oop.polymorphism.optimizedsolution.CompoundShape;
import bif3.swe1.oop.polymorphism.optimizedsolution.Line;
import bif3.swe1.oop.polymorphism.optimizedsolution.ShapeCompositionInterface;
import bif3.swe1.oop.shapestackgit.ShapeStack;
import bif3.swe1.oop.shapestackgit.ShapeStackInterface;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // different types of string concatenation & interpolation
        String someStringValue = "some value";
        String anotherStringValue = "another value";
        String differentStringValue = "different value";

        String doNotConcatStringLikeThis = "Use this to format " + someStringValue + " with " + anotherStringValue + " and " + differentStringValue;
        String concatString = someStringValue.concat( anotherStringValue.concat(differentStringValue) );
        String concatStringBetter = new StringBuilder().append(someStringValue).append(anotherStringValue).append(differentStringValue).toString();
        String formatString = String.format("Use this to format %s with %s and %s", someStringValue, anotherStringValue, differentStringValue );

        System.out.println("-----");

        // class members
        System.out.println(ClassWithMembers.STATIC_STRING);
        ClassWithMembers classWithMembers = new ClassWithMembers();
        classWithMembers.changeSomeValues(10);
        classWithMembers.writeSomething();

        System.out.println("-----");

        // Inheritance & Basic Polymorphism
        BaseClass bc = new BaseClass();
        DerivedClass dc = new DerivedClass();
        BaseClass bcdc = new DerivedClass();

        bc.method1();
        bc.method2();

        dc.method1();
        dc.method2();

        // runtime polymorphism
        // calls method1 of derived class because of implicit-virtual/override
        bcdc.method1();
        // remark: no method-hiding here
        // calls overloaded method2 of derived class because of casting
        ((DerivedClass)bcdc).method2("sdf");

        // runtime polymorphism
        // calls method3 of derived class because of implicit-virtual/override
        bcdc.method3();

        System.out.println("-----");

        // Polymorphism with abstract base class
        AbstractShape abstractLine = new DerivedLine(0, 1,1, 1);
        abstractLine.showOrigin();
        double abstractLinePerimeter = abstractLine.getPerimeter();

        AbstractShape abstractCircle = new DerivedCircle(5, 5, 3);
        abstractCircle.showOrigin();
        double abstractCircleArea = abstractCircle.getArea();

        DerivedCompoundShape derivedCompound = new DerivedCompoundShape(7, 7);
        derivedCompound.add(abstractLine);
        derivedCompound.add(abstractCircle);
        derivedCompound.add(new DerivedLine(3, 4, 5, 6));
        derivedCompound.showOrigin();
        derivedCompound.printShapeType();

        // casting works in IDE, but will throw an error at runtime if "line" is something else than a Line object
        //AbstractShape shape = new DerivedCircle(0, 0, 1);
        //DerivedLine line3 = (DerivedLine)shape;

        System.out.println("-----");

        // Polymorphism with interfaces
        BetterShapeCompositionInterface betterLine = new BetterLine(0, 1, 1, 1);
        betterLine.showOrigin();
        double betterLinePerimeter = betterLine.getPerimeter();

        BetterShapeCompositionInterface betterCircle = new BetterCircle(5, 5, 3);
        double betterCircleArea = betterCircle.getArea();
        betterCircle.showOrigin();

        BetterCompoundShape betterCompound = new BetterCompoundShape(7, 7);
        betterCompound.add(betterLine);
        betterCompound.add(betterCircle);
        betterCompound.add(new BetterLine(3, 4, 5, 6));
        betterCompound.showOrigin();
        betterCompound.printShapeType();

        System.out.println("-----");

        // Very good solution for this usecase - Polymorphism with interfaces and a base class
        Line line = new Line(0, 1, 1, 1);
        line.showOrigin();
        double linePerimeter = line.getPerimeter();

        Circle circle = new Circle(5, 5, 3);
        double circleArea = betterCircle.getArea();
        betterCircle.showOrigin();

        CompoundShape compoundShape = new CompoundShape(7, 7);
        compoundShape.add(line);
        compoundShape.add(circle);
        compoundShape.add(new Line(3, 4, 5, 6));
        compoundShape.showOrigin();
        compoundShape.printShapeType();

        System.out.println("-----");

        ShapeStackInterface shapeStack = new ShapeStack(5);
        shapeStack.push(line);
        System.out.printf("Is empty? %s\n", shapeStack.isEmpty());

        if( !shapeStack.isEmpty()) {
            shapeStack.describeStack();
        }

        System.out.println("-----");

        ShapeCompositionInterface poppedShape = shapeStack.pop();
        System.out.println("Following shape was popped from stack:");
        poppedShape.printShapeType();
        System.out.printf("Is stack empty? %s\n", shapeStack.isEmpty());

        System.out.println("-----");
    }
}
