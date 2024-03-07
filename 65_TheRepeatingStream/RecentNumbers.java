import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RecentNumbers {
    private int[] numbers = new int[2];
    private final Lock lock = new ReentrantLock();
    
    public void add(int number) {
        lock.lock();
        try {
            numbers[0] = numbers[1];
            numbers[1] = number;
        } finally {
            lock.unlock();
        }
    }

    public boolean lastTwoNumbersAreTheSame() {
        lock.lock();
        try {
            return numbers[0] == numbers[1];
        } finally {
            lock.unlock();
        }
    }
}

