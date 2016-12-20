package AnimalInheritance;

/**
 * Created by xm39 on 20/12/2016.
 */
public abstract class Canine extends Animal {

    public void roam(){
        System.out.println("roaming");
    }

    public void poo(boolean doIt){
        if ( doIt) {System.out.println("plop plop !");}
    }

}
