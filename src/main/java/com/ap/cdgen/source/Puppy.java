package src.main.java.com.ap.cdgen.source;

import src.main.java.com.ap.cdgen.annotations.ChildClass;

@ChildClass(superClass = "Dog")
public class Puppy extends Dog {

  public String id;

  private String getPuppyName() {
    return "puppy";
  }

  public void jumpPuppy() {}
}
