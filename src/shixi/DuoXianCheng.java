package shixi;

import java.util.concurrent.Semaphore;

public class DuoXianCheng {

        public static void main(String[] args) throws InterruptedException {
            new ThreadA(1).start();
            new ThreadB(1).start();
            new ThreadC(1).start();
        }

        //以A开始的信号量,初始信号量数量为1
        private static Semaphore A = new Semaphore(1);
        //B、C信号量,A完成后开始,初始信号数量为0
        private static Semaphore B = new Semaphore(0);
        private static Semaphore C = new Semaphore(0);


        static class ThreadA extends Thread {
            private int count;
            public ThreadA(int count) {
                //super();
                this.count = count;
            }
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 2; i++) {
                        A.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                        for (int j = 0; j < count; j++) {
                            System.out.print("A");
                        }

                        B.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        static class ThreadB extends Thread {
            private int count;
            public ThreadB(int count) {
                super();
                this.count = count;
            }
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 2; i++) {
                        B.acquire();
                        for (int j = 0; j < count; j++) {
                            System.out.print("B");
                        }
                        C.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        static class ThreadC extends Thread {
            private int count;
            public ThreadC(int count) {
                super();
                this.count = count;
            }
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 2; i++) {
                        C.acquire();
                        for (int j = 0; j < count; j++) {
                            System.out.println("C");
                        }
                        A.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

