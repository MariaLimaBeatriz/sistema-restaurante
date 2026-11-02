package cardapio;


public class Lanche implements ItemCardapio {

    private double preco;
    private String nomeLanche;

    public Lanche(String nomeLanche, double preco) {
        setNomeLanche(nomeLanche);
        setPreco(preco);
    }

    @Override
    public String getDescricao() {
        return nomeLanche;
    }

    public double getPreco() {
        return preco;
    }

    public void setNomeLanche(String nomeLanche) {
     if (nomeLanche == null || nomeLanche.trim().isEmpty()) {
         throw new IllegalArgumentException(" nome do lanche não pode ser nulo ou vazio");
     }
      this.nomeLanche = nomeLanche;
    }

    public void setPreco(double preco) {
        if(preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo!.");
        }
        this.preco = preco;
    }



}

