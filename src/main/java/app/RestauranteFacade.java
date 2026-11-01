package app;

import Pedidos.GerenciadorPedidos;
import Pedidos.Pedidos;
import cardapio.Lanche;

import java.util.HashMap;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();


    public Lanche criarLanche(int opcao) {
        switch (opcao) {

            case 1:
                return new Lanche("X -Burger", 16.00);

            case 2:
                return new Lanche("X-Salada", 18.00);

            case 3:

                return new Lanche("X- Bacon", 22);

            default:
                throw new IllegalArgumentException("Opção de lanche inválida: " + opcao);


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
