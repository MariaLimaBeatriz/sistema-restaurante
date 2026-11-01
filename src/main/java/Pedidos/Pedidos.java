package Pedidos;

import cardapio.Lanche;

import java.util.ArrayList;

public class Pedidos {
    private int numeroIdentificador;
    private String NomeCliente;

    private ArrayList<Lanche> itens = new ArrayList<>();

    public Pedidos(int numero, String nomeCliente) {
        this.numeroIdentificador = numero;
        setNomeCliente(nomeCliente);
        this.itens = new ArrayList<>();
    }


    private void setNomeCliente(String NomeCliente) {
        if (NomeCliente == null || NomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException(" nome não pode ser nulo ou vazio");
        }
        this.NomeCliente = NomeCliente;
    }

    public void adicionarItem( Lanche lanche){
       itens.add(lanche);
    }

    public double calcularTotal() {
        double total = 0;
        for (Lanche lanche : itens) {
            total += lanche.getPreco();
        }
        return total;
    }

    public int getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public ArrayList<Lanche> getItens() {
        return itens;
    }
}
