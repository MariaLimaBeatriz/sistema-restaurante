package app;

import Pedidos.Pedidos;
import cardapio.ItemCardapio;
import cardapio.Lanche;

public class Main {
    public static void main(String[] args) {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistemaRestaurante = new RestauranteFacade();

        int opcao = -1;
        while (opcao != 0) {

            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {
                case 1: {
                    try {
                        String nome = menu.lerNomeCliente();
                        Pedidos pedidos = sistemaRestaurante.criarPedido(nome);

                        boolean querAdicionarmais = true;
                        while (querAdicionarmais) {
                            menu.exibirCardapio();
                            int opcaoLanche = menu.lerOpcaoLanche();


                            Lanche lanche = (Lanche) sistemaRestaurante.criarLanche(opcaoLanche);


                            int opcaoRemocao = -1;
                            while (opcaoRemocao != 0) {
                                menu.exibirMenuRemocao();
                                opcaoRemocao = menu.lerOpcao();

                                if (opcaoRemocao != 0) {
                                    sistemaRestaurante.removerIngrediente(lanche, opcaoRemocao);
                                    menu.exibirMensagem("Ingrediente removido!");
                                }
                            }

                            ItemCardapio item = lanche;
                            int opcaoAdicional = -1;
                            while (opcaoAdicional != 0) {
                                menu.exibirMenuAdicionais();
                                opcaoAdicional = menu.lerOpcao();

                                if (opcaoAdicional != 0) {
                                    item = sistemaRestaurante.aplicarAdicional(item, opcaoAdicional);
                                    menu.exibirMensagem("Adicional incluído ao seu pedido!");
                                }
                            }

                            pedidos.adicionarItem(item);

                            querAdicionarmais = menu.querAdicionarMaisItens();
                        }

                        menu.exibirPedido(pedidos);
                    } catch (IllegalArgumentException e) {
                        menu.exibirMensagem("Erro: " + e.getMessage());
                    }
                    break;
                }
                case 2:
                    menu.exibirPedidos(sistemaRestaurante.listarPedidos());
                    break;

                case 3:
                    double total = sistemaRestaurante.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total);
                    break;

                case 0:
                    menu.exibirMensagem("Saindo do menu");
                    break;
                default:
                    menu.exibirMensagem("Opção inválida.");
            }

        }
    }
}