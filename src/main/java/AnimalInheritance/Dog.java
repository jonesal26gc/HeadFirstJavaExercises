package AnimalInheritance;

/**
 * Created by xm39 on 20/12/2016.
 */
public class Dog extends Canine {

    // because the dog has a parameter, the polymorphic call does not apply.
    public String makeNoise(int a){
        return "woof";
    }
    public void eat(){}

}
