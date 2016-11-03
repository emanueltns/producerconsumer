package devforfun.com.producerconsumer.run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author emanueltanasa Date: 11/3/16.
 */
public class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant(){
        executorService.execute(waitPerson);
        executorService.execute(chef);
    }
}
