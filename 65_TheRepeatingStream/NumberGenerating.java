public class NumberGenerating implements Runnable {
    private RecentNumbers recentNumbers;
    private volatile boolean stopRequested = false;
    
    public NumberGenerating(RecentNumbers recentNumbers) {
        this.recentNumbers = recentNumbers;
    }
    
    Random random = new Random();
    
    @Override
    public void run() {
        while (!stopRequested) {
        int number = random.nextInt(9);
        System.out.println(number);
        recentNumbers.add(number);
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stopThread() {
        stopRequested = true;
    }
}
