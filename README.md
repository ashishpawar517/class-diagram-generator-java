# Class Diagram generator In Java
Create UML Class diagram using Java Annotations.

just add `@SuperClass` and `@ChildClass` above the class declaration.

<table>
  <tr>
    <th>@SuperClass</th>
    <th>@ChildClass</th>
  </tr>
  <tr>
    <td>
      
```java 
 @SuperClass
 public interface Animal {
 }
```   
     
</td>
 <td>
 
 ```java 
@ChildClass(superClass = "Animal")
public class Cat implements Animal {
}
``` 
   
</td>
</tr>
</table>

this will create UML class diagrams for you in mermaid markdown file.


