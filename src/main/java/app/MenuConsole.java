package app;

import Pedidos.Pedidos;
import cardapio.Lanche;

import java.util.HashMap;
import java.util.Scanner;

public class MenuConsole {
     private Scanner scanner = new Scanner(System.in);

     public void exibirMenu() {
         System.out.println(" === RESTAURANTE === ");
         System.out.println(" Opção 1 - Registrar novo pedido ");
         System.out.println(" Opção 2 - listar pedidos do dia ");
         System.out.println(" Opção 3 - Fechar restaurante ");
         System.out.println(" Caso queira sair - opção 0 ");
         System.out.println(" Qual opção deseja? ");
     }

    public void exibirCardapio() {
        System.out.println("=== CARDÁPIO ===");
        System.out.println("1 - X-Burger: R$ 16,00");
        System.out.println("2 - X-Salada: R$ 18,00");
        System.out.println("3 - X-Bacon: R$ 22,00");
        System.out.print("Qual lanche deseja? ");

    }

     public String lerNomeCliente(){
         System.out.println("O nome do cliente: ");
         String nomeCliente = scanner.nextLine();
         return nomeCliente;
     }

     public void exibirMensagem(String texto){
         System.out.println(texto);
     }

     public int lerOpcao(){
         int opcao = scanner.nextInt();
         scanner.nextLine();
         return opcao;
     }

     public int  lerOpcaoLanche(){
         int opcao = scanner.nextInt();
         scanner.nextLine();
         return opcao;
     }

     public void exibirPedido( Pedidos pedidos){
         System.out.println( "Pedido nº: " + pedidos.getNumeroIdentificador());
         System.out.println(" Cliente:  " + pedidos.getNomeCliente());

         for(Lanche lanche : pedidos.getItens()) {
             System.out.printf("- %s: R$ %.2f%n ", lanche.getNome(), lanche.getPreco());
         }
         System.out.printf("Total: R$ %.2f%n", pedidos.calcularTotal());
     }

     public boolean querAdicionarMaisItens() {
         System.out.println("Deseja adicionar mais itens ao pedido? s/n: ");
         String respostaCliente = scanner.nextLine();
         return respostaCliente.equalsIgnoreCase("S");
     }

    public void exibirPedidos(HashMap<Integer, Pedidos> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado hoje.");
            return;
        }

        for (Pedidos pedido : pedidos.values()) {
            exibirPedido(pedido);
            System.out.println();
        }
    }
     public void exibirFechamentoDoDia(double total){
         System.out.printf("O fechamento do dia é: R$ %.2f%n", total);
     }
}
