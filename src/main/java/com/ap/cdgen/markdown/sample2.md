```mermaid
classDiagram
Animal <|-- Cat
Animal <|-- Dog
Dog <|-- Puppy
class Cat{
-String furrType
+meow()
+jump()
+getName()
+sleep()
}
class Animal{
<<interface>>
-getName()
}
class Dog{
+jump()
+bark()
+getName()
+sleep()
}
class Puppy{
+String id
-getPuppyName()
+jumpPuppy()
}

```