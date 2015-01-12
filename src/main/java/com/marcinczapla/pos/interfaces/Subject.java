package com.marcinczapla.pos.interfaces;

/**
 * Created by Marcin on 2015-01-12.
 */
public interface Subject {

    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}
