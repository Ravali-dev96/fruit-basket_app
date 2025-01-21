package org.example;

public class Fruit {
    private String fruitType;
    private int ageInDays;
    private String characteristic1;
    private String characteristic2;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        if (!fruitType.equals(fruit.fruitType)) return false;
        if (!characteristic1.equals(fruit.characteristic1)) return false;
        return characteristic2.equals(fruit.characteristic2);
    }

    @Override
    public int hashCode() {
        int result = fruitType.hashCode();
        result = 31 * result + characteristic1.hashCode();
        result = 31 * result + characteristic2.hashCode();
        return result;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getAgeInDays() {
        return ageInDays;
    }

    public void setAgeInDays(int ageInDays) {
        this.ageInDays = ageInDays;
    }

    public String getCharacteristic1() {
        return characteristic1;
    }

    public void setCharacteristic1(String characteristic1) {
        this.characteristic1 = characteristic1;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    public void setCharacteristic2(String characteristic2) {
        this.characteristic2 = characteristic2;
    }
}


    // Fields
