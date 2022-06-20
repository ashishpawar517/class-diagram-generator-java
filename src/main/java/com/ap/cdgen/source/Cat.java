package src.main.java.com.ap.cdgen.source;

import src.main.java.com.ap.cdgen.annotations.ChildClass;

@ChildClass(superClass = "Animal")
public class Cat implements Animal {

  private String furrType;

  @Override
  public String getName() {
    return "Cat";
  }

  public void jump() {}

  public void meow() {}

  public void sleep() {}
}
