package top.probiecoder.concurrent;

import java.util.concurrent.ThreadLocalRandom;

public class GsGameThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_ENEMIES = 0;
    private static final Integer LIFE_VALUE = 10;
    private static final Integer TOTAL_PLAYERS = 10;

    // 随机数用来展示每个对象的不同的数据
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLED_NUMBER_THREADLOCAL
            = ThreadLocal.withInitial(() -> BULLET_NUMBER);

    private static final ThreadLocal<Integer> KILLED_ENEMIES_THREADLOCAL
            = ThreadLocal.withInitial(() -> KILLED_ENEMIES);

    private static final ThreadLocal<Integer> LIFE_VALUE_THREADLOCAL
            = ThreadLocal.withInitial(() -> LIFE_VALUE);

    private static class Player extends Thread {
        @Override
        public void run() {
            Integer bullets = BULLED_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killEnemies = KILLED_ENEMIES_THREADLOCAL.get() - RANDOM.nextInt(TOTAL_PLAYERS / 2);
            Integer lifeValue = LIFE_VALUE_THREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);
            System.out.println(getName() + ", BULLET_BUMBER is " + bullets);
            System.out.println(getName() + ", KILLED_ENEMIES is " + killEnemies);
            System.out.println(getName() + ", LIFE_VALUE is " + lifeValue);
            System.out.println();

            BULLED_NUMBER_THREADLOCAL.remove();
            KILLED_ENEMIES_THREADLOCAL.remove();
            LIFE_VALUE_THREADLOCAL.remove();

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }
}
