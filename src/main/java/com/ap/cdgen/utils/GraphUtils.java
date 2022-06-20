package src.main.java.com.ap.cdgen.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import src.main.java.com.ap.cdgen.annotations.ChildClass;
import src.main.java.com.ap.cdgen.annotations.SuperClass;

public class GraphUtils {

  @SuppressWarnings("unchecked")
  public static String createGraph(String packagePath) {
    Map<String, List<String>> adjList = new HashMap<>();

    Set<Class> classes = ClassUtils.findAllClassesUsingClassLoader(packagePath);
    List<Class> listOfClasses = new ArrayList<>();

    for (Class c : classes) {
      listOfClasses.add(c);
      if (c.getAnnotation(SuperClass.class) != null) {
        if (!adjList.containsKey(c.getSimpleName())) {
          adjList.put(c.getSimpleName(), new ArrayList<>());
        }
      } else if (c.getAnnotation(ChildClass.class) != null) {
        ChildClass childClass = (ChildClass) c.getAnnotation(ChildClass.class);
        // adjList.get(childClass.superClass()).add(c.getSimpleName());
        if (adjList.containsKey(childClass.superClass())) {
          adjList.get(childClass.superClass()).add(c.getSimpleName());
        } else {
          adjList.put(childClass.superClass(), new ArrayList<>());
          adjList.get(childClass.superClass()).add(c.getSimpleName());
        }
      }
    }
    return createMermaidGraph(adjList, listOfClasses);
  }

  public static String createMermaidGraph(
    Map<String, List<String>> adjList,
    List<Class> listOfClasses
  ) {
    StringBuilder res = new StringBuilder();
    res.append("```mermaid\n");
    res.append("classDiagram");
    res.append("\n");

    for (Entry<String, List<String>> entry : adjList.entrySet()) {
      String superClass = entry.getKey();
      for (String child : entry.getValue()) {
        res.append(superClass + " <|-- " + child);

        res.append("\n");
      }
    }

    for (Class clasz : listOfClasses) {
      res.append("class " + clasz.getSimpleName() + "{\n");
      if (clasz.isInterface()) {
        res.append("<<interface>>\n");
      }
      for (Field field : clasz.getDeclaredFields()) {
        char viz = Modifier.toString(field.getModifiers()).equals("public")
          ? '+'
          : '-';
        res.append(
          viz + field.getType().getSimpleName() + " " + field.getName() + "\n"
        );
      }
      for (Method method : clasz.getDeclaredMethods()) {
        if (method.getDeclaringClass() == Object.class) continue;
        char viz = Modifier.toString(method.getModifiers()).equals("public")
          ? '+'
          : '-';
        res.append(viz + method.getName() + "()\n");
      }
      res.append("}\n");
    }
    res.append("\n");
    res.append("```");
    return res.toString();
  }
}
