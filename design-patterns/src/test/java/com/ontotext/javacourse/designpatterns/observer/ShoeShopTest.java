package com.ontotext.javacourse.designpatterns.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ontotext.javacourse.designpatterns.observer.observers.ShoesAvailable;
import com.ontotext.javacourse.designpatterns.observer.observers.ShoesSold;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoeShopTest {
  private ShoeShop shoeShop;

  @BeforeEach
  void setUp() {
    shoeShop = new ShoeShop();
  }

  @Test
  void addObserverAddsObserverToShop() {
    shoeShop.addObserver(new ShoesAvailable());
    shoeShop.addObserver(new ShoesSold());
    assertEquals(2, shoeShop.getShoesObserverList().size());
  }

  @Test
  void removeObserverRemovesObserverFromShop() {
    ShoesAvailable shoesAvailableObserver = new ShoesAvailable();
    ShoesSold shoesSoldObserver = new ShoesSold();
    shoeShop.addObserver(shoesAvailableObserver);
    shoeShop.addObserver(shoesSoldObserver);
    shoeShop.removeObserver(shoesSoldObserver);
    assertEquals(1, shoeShop.getShoesObserverList().size());
  }

  @Test
  void addShoeNotifiesShoesAvailableObserver() {
    ShoesAvailable shoesAvailableObserver = new ShoesAvailable();
    shoeShop.addObserver(shoesAvailableObserver);
    addShoesToStore();
    assertEquals(2, shoesAvailableObserver.getShoesAvailableCount());
  }

  @Test
  void sellShoeNotifiesBothObservers() {
    ShoesAvailable shoesAvailableObserver = new ShoesAvailable();
    ShoesSold shoesSoldObserver = new ShoesSold();
    shoeShop.addObserver(shoesAvailableObserver);
    shoeShop.addObserver(shoesSoldObserver);
    Shoe trainingShoe = new Shoe(40, "Nike", "Training");
    Shoe winterShoe = new Shoe(42, "Nike", "Winter");
    shoeShop.addShoe(trainingShoe);
    shoeShop.addShoe(winterShoe);
    shoeShop.sellShoe(trainingShoe);
    assertEquals(1, shoesAvailableObserver.getShoesAvailableCount());
    assertEquals(1, shoesSoldObserver.getShoesSoldCount());
  }

  @Test
  void sellShoeThrowsExceptionIfNoShoesAreAvailable() {
    assertThrows(IllegalStateException.class, () -> shoeShop.sellShoe(new Shoe(12, "a", "b")));
  }

  @Test
  void getAvailableShoesReturnsCorrectAmountOfShoes() {
    addShoesToStore();
    assertEquals(2, shoeShop.getAvailableShoes().size());
  }

  private void addShoesToStore() {
    shoeShop.addShoe(new Shoe(40, "Nike", "Training"));
    shoeShop.addShoe(new Shoe(42, "Nike", "Winter"));
  }
}
