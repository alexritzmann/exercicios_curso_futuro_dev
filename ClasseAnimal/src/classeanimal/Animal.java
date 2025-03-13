package classeanimal;

import java.util.Objects;

public class Animal
{
    private final String nome;
    private final String habitat;
    private final String som;
    private final String tipoDeAlimentacao;

    public Animal(String nome, String habitat, String som, String tipoDeAlimentacao)
    {
        this.nome = nome;
        this.habitat = habitat;
        this.som = som;
        this.tipoDeAlimentacao = tipoDeAlimentacao;
    }

    public String getTipoDeAlimentacao() {
        return tipoDeAlimentacao;
    }

    public String getSom() {
        return som;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getNome() {
        return nome;
    }

    public void mover(Animal animal)
    {
        System.out.println("O " + animal.getNome() + " se move pela " + animal.getHabitat());
    }

    public void emitirSom(Animal animal)
    {
        System.out.println("O " + animal.getNome() + " faz " + animal.getSom());
    }

    public void alimentar(String animal)
    {
        if (Objects.equals(animal, "herbivoro"))
        {
            System.out.println("Herbivoros comem plantas e folhas");
        }else if (Objects.equals(animal, "carnivoro"))
        {
            System.out.println("Carnivoros se alimentam de carnes e outros animais");
        }
    }


}
