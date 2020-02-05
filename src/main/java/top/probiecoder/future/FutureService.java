package top.probiecoder.future;

public interface FutureService<IN, OUT> {
    // 提交不需要返回值的任务
    Future<?> submit(Runnable runnable);

    // 提交需要返回值的任务,Task接口代替了Runnable接口
    Future<?> submit(Task<IN, OUT> task , IN input);

    // 使用静态方法创建一个实现
    static <T, R> FutureService<T, R> newService() {
        return new FutureServiceImpl();
    }
}
