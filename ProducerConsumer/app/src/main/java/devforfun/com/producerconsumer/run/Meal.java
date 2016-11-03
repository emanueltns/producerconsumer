package devforfun.com.producerconsumer.run;

/**
 * @author emanueltanasa Date: 11/3/16.
 */

public class Meal {

    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal "+orderNum;
    }
}
