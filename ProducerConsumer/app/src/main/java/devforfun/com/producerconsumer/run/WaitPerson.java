package devforfun.com.producerconsumer.run;

/**
 * @author emanueltanasa Date: 11/3/16.
 */

public class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {

        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while(restaurant.meal == null){
                        wait();//...for the chef to produce a meal
                    }
                }
            }
            System.out.print("Wait person got " + restaurant.meal);

            synchronized (restaurant.chef) {
                restaurant.meal = null;
                restaurant.chef.notifyAll(); // Ready for another
            }
        } catch (InterruptedException e) {
            //print this
            System.out.print( "Wait person interupted");
        }

    }
}
