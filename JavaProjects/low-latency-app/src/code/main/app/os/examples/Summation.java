package code.main.app.os.examples;

public class Summation implements Runnable {

    private int upperLimit;
    private Sum sumValue;

    public Summation(int upperLimit, Sum sumValue) {
        this.upperLimit = upperLimit;
        this.sumValue = sumValue;
    }

    public Summation(int limit, Integer value) {
        this.upperLimit = limit;
        this.sumValue = new Sum(value);
    }

    @Override
    public void run() {
        int sum = 0;
        System.out.format("{%s} calculating sum...\n", Thread.currentThread().getName());
        for (int i = 0; i < upperLimit; i++) {
            sum += i;
        }
        sumValue.setSum(sum);
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Sum getSumValue() {
        return sumValue;
    }

    public void setSumValue(Sum sumValue) {
        this.sumValue = sumValue;
    }
}
