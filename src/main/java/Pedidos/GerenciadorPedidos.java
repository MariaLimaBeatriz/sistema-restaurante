package Pedidos;

import java.util.HashMap;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedidos> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedidos criarPedido(String nomeCliente) {
        Pedidos novo = new Pedidos(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumeroIdentificador(), novo);
        contadorPedidos++;
        return novo;
    }

    public Pedidos buscarPedidos(int numero) {
        return pedidos.get(numero);

    }

    public HashMap<Integer, Pedidos> getPedidos() {
        return pedidos;

    }

    public double calcularTotalDoDia(){
        double totalDoDia = 0;
        for (Pedidos pedido : pedidos.values()){
            totalDoDia += pedido.calcularTotal();
        }
     return totalDoDia;

    }

    }


