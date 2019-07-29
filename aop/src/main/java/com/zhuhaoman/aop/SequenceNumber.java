package com.zhuhaoman.aop;

/**
 * @ClassName SequenceNumber
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/29 14:20
 **/
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sequenceNumber = new SequenceNumber();
        TestClient t1 = new TestClient(sequenceNumber);
        TestClient t2 = new TestClient(sequenceNumber);
        TestClient t3 = new TestClient(sequenceNumber);

        t1.start();
        t2.start();
        t3.start();

    }

    private static class TestClient extends Thread {
        private SequenceNumber sn;

        TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3 ; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + sn.getNextNum());
            }
        }
    }
}
