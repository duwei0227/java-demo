package top.probiecoder.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get("/Users/duwei/Workspace");
    private final Path classDir;

    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classPath) {
        super();
        this.classDir = Paths.get(classPath);
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classPath, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 读取class的二进制文件
        byte[] classBytes = this.readClassBytes(name);
        // 如果数据为null,或者没有读到任何信息,则抛出ClassNotFoundException异常
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("Can not load the class " + name);
        }
        // 调用defineClass方法定义class
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        // 将包名分隔符转换为路径分隔符
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The class " + name + " not found.");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class " + name + " occur error.", e);
        }
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }
}
