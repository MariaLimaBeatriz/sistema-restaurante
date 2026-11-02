package cardapio;

public class LancheFactory {

    public static Lanche xBurger() {
        return new Lanche("X-Burger", 16.00);
    }

    public static Lanche xSalada() {
        return new Lanche("X-Salada", 18.00);
    }

    public static Lanche xBacon(){
        return new Lanche("X-Bacon", 22.00);
    }

    public static ItemCardapio comCheddar(ItemCardapio item){
        return new ComCheddar(item);
    }

    public static ItemCardapio comBacon(ItemCardapio item){
        return new ComBaconExtra(item);
    }

}
