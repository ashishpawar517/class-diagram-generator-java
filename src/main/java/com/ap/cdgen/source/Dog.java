package src.main.java.com.ap.cdgen.source;

import src.main.java.com.ap.cdgen.annotations.ChildClass;

@ChildClass(superClass = "Animal")
public class Dog implements Animal {

  @Override
  public String getName() {
    return "Dog";
  }

  public void jump() {}

  public void bark() {}

  public void sleep() {}
}
