package devforfun.com.producerconsumer.presenters;

import devforfun.com.producerconsumer.interactors.MainInteractor;
import devforfun.com.producerconsumer.view.MainView;

/**
 * @author emanueltanasa Date: 10/31/16.
 */

public class MainPresenter {

    MainInteractor mainInteractor;
    MainView view;

    public MainPresenter(MainInteractor mainInteractor, MainView view) {
        this.mainInteractor = mainInteractor;
        this.view = view;
    }

    public void onStartProduction() {
        mainInteractor.startProduction();
    }
}
