package devforfun.com.producerconsumer.run;

import java.util.concurrent.TimeUnit;

/**
 * @author emanueltanasa Date: 11/3/16.
 */

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this){
                    while (restaurant.meal != null) {
                        wait();//...for the meal to be taken
                    }
                }
            }

            if(++count == 10) {
                System.out.print("Out of food. Closing");
                restaurant.executorService.shutdownNow();
            }

            System.out.print("Order Up!");
            synchronized (restaurant.waitPerson) {
                restaurant.meal = new Meal(count);
                restaurant.waitPerson.notifyAll();
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (InterruptedException e) {
            System.out.print("Chef interupted");
        }
    }
}
