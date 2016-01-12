package com.thoughtworks.videoclub;

public enum Price {
  CHILDREN {
    @Override
    public double charge(int daysRented) {
      return 1.5 + Math.max(daysRented - 3, 0) * 1.5;
    }
  },
  REGULAR {
    @Override
    public double charge(int daysRented) {
      return 2 + Math.max(daysRented - 2, 0) * 1.5;
    }
  },
  NEW_RELEASE {
    @Override
    public double charge(int daysRented) {
      return daysRented * 3.0;
    }
  };

  public abstract double charge(int daysRented);
}
