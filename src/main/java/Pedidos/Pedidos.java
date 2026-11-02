package Pedidos;

import cardapio.ItemCardapio;

import java.util.ArrayList;

public class Pedidos {
    private int numeroIdentificador;

    private ArrayList<ItemCardapio> itens = new ArrayList<>();
    private String nomeCliente;

    public Pedidos(int numero, String nomeCliente) {
        this.numeroIdentificador = numero;
        setNomeCliente(nomeCliente);
        this.itens = new ArrayList<>();
    }

    public Pedidos() {
    }

    private void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException(" nome do cliente não pode ser nulo ou vazio");
        }
        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem( ItemCardapio item){
       itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCardapio item  : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public String getnomeCliente() {
        return nomeCliente;
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }
}
