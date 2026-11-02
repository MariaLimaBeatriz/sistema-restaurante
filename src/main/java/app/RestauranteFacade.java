package app;

import Pedidos.GerenciadorPedidos;
import Pedidos.Pedidos;
import cardapio.*;

import java.util.HashMap;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();


    public ItemCardapio criarLanche(int opcao) {
        switch (opcao) {

            case 1:
                return LancheFactory.xBurger();

            case 2:
                return LancheFactory.xSalada();

            case 3:

                return LancheFactory.xBacon();

            default:
                throw new IllegalArgumentException("Opção de lanche inválida: " + opcao);


        }
    }


    public ItemCardapio aplicarAdicional(ItemCardapio item, int opcaoAdicional) {

        switch (opcaoAdicional) {
            case 1:
                return new ComCheddar(item);
            case 2:
                return new ComBaconExtra(item);
            default:
                return item;
        }
    }

    public void removerIngrediente(Lanche lanche, int opcaoRemocao) {
        switch (opcaoRemocao) {
            case 1 -> lanche.setQueijo(false);
            case 2 -> lanche.setAlface(false);
            case 3 -> lanche.setTomate(false);
            case 4 -> lanche.setCebola(false);
            default -> throw new IllegalArgumentException("Opção de remoção inválida: " + opcaoRemocao);
        }
    }

    public Pedidos criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);

    }

     public void adicionarLanche(Pedidos pedido, int opcao) {
        pedido.adicionarItem(criarLanche(opcao));
    }

    public HashMap<Integer, Pedidos> listarPedidos() {
        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }
}