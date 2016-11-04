package devforfun.com.producerconsumer.run;

import android.util.Log;

import devforfun.com.producerconsumer.interactors.MainInteractor;

/**
 * @author emanueltanasa Date: 11/3/16.
 */

public class WaitPerson implements Runnable {

    private Restaurant restaurant;
    private Restaurant.RestaurantCallBack callBack;


    public WaitPerson(Restaurant restaurant, Restaurant.RestaurantCallBack callBack) {
        this.restaurant = restaurant;
        this.callBack = callBack;
    }

    @Override
    public void run() {
        Log.d("msg", "waitperson");
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();//...for the chef to produce a meal
                    }
                }

                callBack.sendMessage("Wait person got " + restaurant.meal);

                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
            }
        } catch (InterruptedException e) {
            //print this
            System.out.print("Wait person interupted");
        }

    }
}
