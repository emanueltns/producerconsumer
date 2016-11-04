package devforfun.com.producerconsumer.run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import devforfun.com.producerconsumer.interactors.MainInteractor;

/**
 * @author emanueltanasa Date: 11/3/16.
 */
public class Restaurant {

    public interface RestaurantCallBack {
        void sendMessage(String message);
    }

    Meal meal;
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    WaitPerson waitPerson;
    Chef chef;

    public Restaurant(RestaurantCallBack callBack){
        waitPerson = new WaitPerson(this, callBack);
        chef = new Chef(this, callBack);
    }

    public void openRestaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }

}
