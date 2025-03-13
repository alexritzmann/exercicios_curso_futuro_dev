package classeanimal;

public class Main
{
    public static void main(String[] args)
    {

        Animal animal1 = new Animal("Leao","savana","uurrrhh","carnivoro");
        Animal animal2 = new Animal("zebra","Africa","iihhuuubbllrrr","herbivoro");
        Animal animal3 = new Animal("Tigre","savana","miau","carnivoro");
        Animal animal4 = new Animal("Formiga","mata","bla","herbivoro");

        animal1.alimentar(animal1.getTipoDeAlimentacao());
        animal2.alimentar(animal2.getTipoDeAlimentacao());
        animal3.alimentar(animal3.getTipoDeAlimentacao());
        animal4.alimentar(animal4.getTipoDeAlimentacao());

        animal1.emitirSom(animal1);
        animal2.emitirSom(animal2);
        animal3.emitirSom(animal3);
        animal4.emitirSom(animal4);

        animal1.mover(animal1);
        animal2.mover(animal2);
        animal3.mover(animal3);
        animal4.mover(animal4);


    }
}
