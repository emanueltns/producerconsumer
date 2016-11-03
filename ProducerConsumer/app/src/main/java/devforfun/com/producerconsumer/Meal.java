package devforfun.com.producerconsumer;

/**
 * @author emanueltanasa Date: 11/2/16.
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
