package com.mytool.DesignPatterns.CreationalPatterns.SingletonPattern;

import java.io.Serializable;

/**
 * 单例模式
 * <p>
 * 优点：
 * <p>
 * 在内存中只有一个对象，节省内存空间；
 * <p>
 * 避免频繁的创建销毁对象，可以提高性能；
 * <p>
 * 避免对共享资源的多重占用，简化访问；
 * <p>
 * 为整个系统提供一个全局访问点。
 * <p>
 * 缺点：
 * <p>
 * 不适用于变化频繁的对象；
 * <p>
 * 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；
 * <p>
 * 如果实例化的对象长时间不被利用，系统会认为该对象是垃圾而被回收，这可能会导致对象状态的丢失；
 *
 * @author duankd
 * @ClassName SingletonPattern
 * @date 2021-06-02 10:19:57
 */
public class Singleton {

    /**
     * 饿汉式单例
     */
    public static class Singleton1 {

        // 指向自己实例的私有静态引用，主动创建
        private static Singleton1 instance = new Singleton1();

        // 私有的构造方法
        private Singleton1() {
        }

        // 以自己实例为返回值的静态的公有方法，静态工厂方法
        public static Singleton1 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式-线程安全
     */
    public static class Singleton2 implements Serializable, Cloneable {
        //默认是第一次创建
        private static volatile boolean isCreate = false;
        // 指向自己实例的私有静态引用，被动创建
        private static volatile Singleton2 instance = null;

        // 私有化构造方法
        private Singleton2() {
            if (isCreate) {
                throw new RuntimeException("已然被实例化一次，不能再实例化");
            }
            isCreate = true;
        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                synchronized (Singleton2.class) {
                    if (instance == null) {
                        instance = new Singleton2();
                    }
                }
            }
            return instance;
        }

        /**
         * 防止clone 破坏
         *
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return instance;
        }

        /**
         * 防止序列化破环
         *
         * @return
         */
        private Object readResolve() {
            return instance;
        }
    }

    /**
     * 使用静态内部类实现单例模式
     */
    public static class Singleton3 {
        private static class SingletonHolder {
            /**
             * 静态初始化器，由JVM来保证线程安全
             */
            private static Singleton3 instance = new Singleton3();
        }

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            Singleton3 instance = SingletonHolder.instance;
            return instance;
        }

    }

    /**
     * 使用枚举来实现单例
     */
    public enum Singleton4 {
        // 定义一个枚举的元素，它 就代表了Singleton的一个实例
        uniqueInstance;

        public void singletonOperation() {
            // 功能处理
            System.err.println("功能处理");
        }
    }
}
