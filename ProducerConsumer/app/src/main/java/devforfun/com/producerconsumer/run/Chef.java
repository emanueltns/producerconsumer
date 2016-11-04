package devforfun.com.producerconsumer.run;

import android.util.Log;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author emanueltanasa Date: 11/3/16.
 */

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;
    private Restaurant.RestaurantCallBack callBack;

    public Chef(Restaurant restaurant, Restaurant.RestaurantCallBack callBack){
        this.restaurant = restaurant;
        this.callBack = callBack;
    }

    @Override
    public void run() {
        Log.d("msg","chef");
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();//...for the meal to be taken
                    }
                }

                if (++count == 10) {
                    callBack.sendMessage("Out of food. Closing");
                    restaurant.executorService.shutdownNow();
                }

                callBack.sendMessage("Order Up!");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.print("Chef interupted");
        }
    }
}
