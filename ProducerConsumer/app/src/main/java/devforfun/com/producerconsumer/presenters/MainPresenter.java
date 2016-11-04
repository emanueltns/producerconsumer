package devforfun.com.producerconsumer.presenters;

import java.util.ArrayList;
import java.util.List;

import devforfun.com.producerconsumer.interactors.MainInteractor;
import devforfun.com.producerconsumer.run.Restaurant;
import devforfun.com.producerconsumer.view.MainView;

/**
 * @author emanueltanasa Date: 10/31/16.
 */

public class MainPresenter implements Restaurant.RestaurantCallBack {

    Restaurant restaurant;
    MainView view;
    List<String> items;

    public MainPresenter(MainView view) {
        restaurant = new Restaurant(this);
        this.view = view;
        items = new ArrayList<>();
    }

    public void onStartProduction() {
        restaurant.openRestaurant();
    }

    @Override
    public void sendMessage(String message) {
        items.add(message);

        view.update(items);
    }
}
