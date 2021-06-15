package com.mygdx.game.App;
import java.util.ArrayList;
import java.util.List;


public class Mochila
{
    private List<Bolsillo> bolsillos;
    private static int limite=50;
    
    public Mochila()
    {
        this.bolsillos=new ArrayList<>();
    }

    public void agregarItem(Item i)
    {
        if(bolsillos.contains(i))
        {
            bolsillos.get(bolsillos.indexOf(i)).setCantidad(bolsillos.get(bolsillos.indexOf(i)).getCantidad()+1);
        }else
            {
                Bolsillo b=new Bolsillo(i);
                b.setCantidad(1);
                bolsillos.add(b);
            }
    }

    public void quitarItem(Item item){
        bolsillos.remove(item);
    }

    public void itemVacio(Item i)
    {
        if(bolsillos.get(bolsillos.indexOf(i)).getCantidad()==0)
        {
            bolsillos.remove(i);
        }
    }

    public Bolsillo getBolsillos(int index) {
        if (!this.bolsillos.isEmpty()){
            return bolsillos.get(index);
        }
        return null;
    }

    public void setBolsillos(List<Bolsillo> bolsillos) {
        this.bolsillos = bolsillos;
    }

    public List<Bolsillo> getListaBolsillo(){
        return this.bolsillos;
    }

    public class Bolsillo implements Acciones
    {
        private Item item;
        private int cantidad;
        
        public Bolsillo(Item item)
        {
            this.item=item;
            this.cantidad=0;
        }

        public void setCantidad(int cant)
        {
            if((cant<100)&&(cantidad+cant<100))
            {    
                this.cantidad=cant;
            }else
            {
                this.cantidad=99;
            }
        }

        public int getCantidad()
        {
            return cantidad;
        }


        public Item getItem()
        {
            return item;
        }

        public boolean estaVacio(){
            if (cantidad == 0){
                return true;
            }
            return false;
        }

        @Override
        public void usar(Compa partner, int index)
        {
            if(cantidad>0)
            {
                if(item instanceof Pocion)
                {
                    if (partner.getVida()+item.getCantRestauracion()>partner.getHp())
                    {
                        partner.setVida(partner.getHp());
                    }else
                    {
                        partner.setVida(partner.getVida()+item.getCantRestauracion());
                    }
                }
                if(item instanceof Elixir)
                {
                    if (partner.getMana()+item.getCantRestauracion()>partner.getMp())
                    {
                        partner.setMana(partner.getMp());
                    }else
                    {
                        partner.setMana(partner.getMana()+item.getCantRestauracion());
                    }
                }
                System.out.println("Utilizaste " + getBolsillos(index).toString());
                bolsillos.remove(getBolsillos(index));
            }
        }

        @Override
        public void tirar(int cantidad)
        {
            if(getCantidad() == 1)
            {
                bolsillos.remove(item);
            }else
            {
                setCantidad(getCantidad()-cantidad);
            }
        }

        @Override
        public String toString()
        {
            return item+" \t\tx"+cantidad;
        }
    }
}

/*

    @Override
    public void usar(Item item, Compa partner){
        if (item instanceof Pocion){
            if (partner.getVida() + cantRestauracion > partner.getHp()){
                partner.setVida(partner.getHp());
            } else {
                partner.setVida(partner.getVida() + cantRestauracion);
            }
            stock--;
        }
        if (item instanceof Elixir){
            if (partner.getMana() + cantRestauracion > partner.getMp()){
                partner.setMana(partner.getMp());
            } else {
                partner.setMana(partner.getMana() + cantRestauracion);
            }
            stock--;
        }
    }

    @Override
    public void tirar(int cantidad) {
        if (cantidad > this.stock) {
            this.stock = 0;
        } else {
            this.stock = this.stock - cantidad;
        }
    }
* */