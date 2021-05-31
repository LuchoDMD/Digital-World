package App;

import java.util.ArrayList;
import java.util.List;

public class Mochila<T> {

    private List<T> bolsillo;

    public Mochila() {
        bolsillo = new ArrayList<>();
    }

    public void agregarItems(T item){
        bolsillo.add(item);
    }

    @Override
    public String toString() {
        return "Mochila [" +
                "Contenido: " + bolsillo +
                ']';
    }


}
