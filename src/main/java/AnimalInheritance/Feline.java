package AnimalInheritance;

/**
 * Created by xm39 on 20/12/2016.
 */
public abstract class Feline extends Animal {

    public void roam(){
        System.out.println("around and around ....");
    }

    public void poo(boolean doIt){
        if ( doIt) {System.out.println("plop plop !");}
    }

}
