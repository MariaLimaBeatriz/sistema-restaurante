package cardapio;


public class Lanche implements ItemCardapio {

    private double preco;
    private String nomeLanche;
    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

    public void setQueijo(boolean queijo) {
        this.queijo = queijo;
    }

    public void setAlface(boolean alface) {
        this.alface = alface;
    }

    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }

    public String getNomeLanche() {
        return nomeLanche;
    }

    public boolean isQueijo() {
        return queijo;
    }

    public boolean isAlface() {
        return alface;
    }

    public boolean isTomate() {
        return tomate;
    }

    public boolean isCebola() {
        return cebola;
    }

    public Lanche(String nomeLanche, double preco) {
        setNomeLanche(nomeLanche);
        setPreco(preco);
    }

    @Override
    public String getDescricao() {
        String desc = nomeLanche;

        if (!queijo) desc += " sem queijo";

        if (!alface) desc += " sem alface";

        if (!tomate) desc += " sem tomate";

        if (!cebola) desc += " sem cebola";
        return desc;

    }

    public double getPreco() {
        return preco;
    }

    public void setNomeLanche(String nomeLanche) {
        if (nomeLanche == null || nomeLanche.trim().isEmpty()) {
            throw new IllegalArgumentException("nome do lanche não pode ser nulo ou vazio");
        }
        this.nomeLanche = nomeLanche;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo!");
        }
        this.preco = preco;
    }


}

