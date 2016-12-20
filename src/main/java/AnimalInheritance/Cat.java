package AnimalInheritance;

/**
 * Created by xm39 on 20/12/2016.
 */
public class Cat extends Feline implements Pet{

    public String makeNoise(){
        return "meow";
    }
    public void eat(){}

    public void roam(){
        super.roam();
    }


    public void play() {

    }

    public void beFriendly() {
        System.out.println("i am being friendly !!");

    }
}
