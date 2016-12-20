package AnimalInheritance;

/**
 * Created by xm39 on 20/12/2016.
 */
public class AnimalApp {

    public static void main(String[] args) {

        // create an array of animals.
        Animal[] a = new Animal[10];

        // create some random animals.
        for (int x = 0; x < 10; x++) {
            int y=(int) Math.round((Math.random() * 5));
            switch (y) {
                case 0:
                    a[x] = new Cat();
                    break;
                case 1:
                    a[x] = new Dog();
                    break;
                case 2:
                    a[x] = new Hippo();
                    break;
                case 3:
                    a[x] = new Lion();
                    break;
                case 4:
                    a[x] = new Tiger();
                    break;
                case 5:
                    a[x] = new Wolf();
                    break;
                default:
                    a[x] = new Animal();
                    break;
            }
        }

        // display the type of animal that was created, along with it's own noise.
        for (Animal element:a) {
            System.out.println("'" + element.makeNoise() +
                    "' goes the " + element.getClass().getName().replaceFirst("AnimalInheritance.",""));
            if ( element.getClass().getName() == "AnimalInheritance.Dog") {
                System.out.println("       ......... alternatively " + new Dog().makeNoise(1));
            }
        }

    }
}
