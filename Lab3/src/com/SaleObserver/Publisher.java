package com.SaleObserver;


public class Publisher extends Observable {

    public Publisher() {
        super();
    }

    @Override
    public void notifyAllObservers() {
        /*
         * lines of code to upload a video
         */
        for (int i=0 ; i<this.getAllObservers().size() ; i++){
            getAllObservers().get(i).getNotified();
        }
    }
}