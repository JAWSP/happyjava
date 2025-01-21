package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class st {
    public static void main(String[] args) {
        Service service = new Service();
        Method[] methods = service.getClass().getDeclaredMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(PrintAnnotation.class)){
                System.out.println("[[[[[[[[[["+method.getName()+"]]]]]]]]]]]]]]]]]");

                PrintAnnotation printAnnotaion =  method.getAnnotation(PrintAnnotation.class);

                for(int i = 0; i < printAnnotaion.number(); i++){
                    System.out.print(printAnnotaion.value());
                }
                System.out.println();
            }
            try {
                method.invoke(service);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
