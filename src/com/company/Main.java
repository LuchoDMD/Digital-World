package com.company;

public class Main {

    public static void main(String[] args) {
        Enemy charizard = new Enemy(5, 500,200,50,25,100, 100, "charizard");
        Partner pikachu = new Partner(5,300,500,100,10,50, "pikachu");

        Batalla battle1 = new Batalla(pikachu, charizard);
        battle1.comenzarBatalla();

    }
}
