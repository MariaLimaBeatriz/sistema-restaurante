package app;

import Pedidos.Pedidos;

public class Main {
    static void main() {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistemaRestaurante = new RestauranteFacade();

        int opcao = -1;
        while (opcao != 0)
        {

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
                            sistemaRestaurante.adicionarLanche(pedidos, opcaoLanche);
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
