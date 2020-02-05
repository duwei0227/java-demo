package top.probiecoder.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        // 使用MyClassLoader加载HelloWorld
        Class<?> clazz = myClassLoader.loadClass("top.probiecoder.classloader.HelloWorld");
        System.out.println(clazz.getClassLoader());

        Object helloWorld = clazz.getDeclaredConstructor().newInstance();
        System.out.println(helloWorld);
        Method method = clazz.getMethod("welcome");
        String result = (String) method.invoke(helloWorld);
        System.out.println("Result:" + result);
    }
}
