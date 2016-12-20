package AnimalInheritance;

import java.util.Arrays;

/**
 * Created by xm39 on 20/12/2016.
 */
public abstract class Animal {

    private String picture;
    private String food;
    private int hunger;
    private int[] boundaries;
    private int[] location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (hunger != animal.hunger) return false;
        if (picture != null ? !picture.equals(animal.picture) : animal.picture != null) return false;
        if (food != null ? !food.equals(animal.food) : animal.food != null) return false;
        if (!Arrays.equals(boundaries, animal.boundaries)) return false;
        return Arrays.equals(location, animal.location);

    }

    @Override
    public int hashCode() {
        int result = picture != null ? picture.hashCode() : 0;
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + hunger;
        result = 31 * result + Arrays.hashCode(boundaries);
        result = 31 * result + Arrays.hashCode(location);
        return result;
    }

    public String makeNoise(){ return "whisper" ;}
    public void eat(){}

    public void sleep(){

    }

    public void roam(){

    }

    public abstract void poo(boolean doIt);

}
