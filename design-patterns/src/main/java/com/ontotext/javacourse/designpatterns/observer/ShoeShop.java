package com.ontotext.javacourse.designpatterns.observer;

import com.ontotext.javacourse.designpatterns.observer.observers.ShoesObserver;
import com.ontotext.javacourse.designpatterns.observer.observers.StateChange;
import java.util.ArrayList;
import java.util.List;

/**
 * The ShoeShop class is a subject that contains observers and notifies them if a shoe is sold or if
 * a new shoe is added to the store.
 */
public class ShoeShop implements ShoeShopSubject {
  private final List<ShoesObserver> shoesObserverList = new ArrayList<>();
  private final List<Shoe> shoes = new ArrayList<>();

  @Override
  public void addObserver(ShoesObserver observer) {
    shoesObserverList.add(observer);
  }

  @Override
  public void removeObserver(ShoesObserver observer) {
    shoesObserverList.remove(observer);
  }

  /**
   * Adds a shoe to the shoe shop and notifies the observers.
   *
   * @param shoe the shoe to add to the shop
   */
  public void addShoe(Shoe shoe) {
    shoes.add(shoe);
    notifyObservers(StateChange.SHOE_ADDED);
  }

  /**
   * Sells a shoe from the store and notifies the observers. If there are no available shoes an
   * IllegalStateException is thrown.
   *
   * @param shoe the shoe to sell
   */
  public void sellShoe(Shoe shoe) {
    if (this.shoes.isEmpty()) {
      throw new IllegalStateException("There are no shoes in the store!");
    }
    shoes.remove(shoe);
    notifyObservers(StateChange.SHOE_SOLD);
  }

  public List<Shoe> getAvailableShoes() {
    return this.shoes;
  }

  public List<ShoesObserver> getShoesObserverList() {
    return this.shoesObserverList;
  }

  private void notifyObservers(StateChange stateChange) {
    for (ShoesObserver observer : shoesObserverList) {
      observer.update(stateChange);
    }
  }
}
