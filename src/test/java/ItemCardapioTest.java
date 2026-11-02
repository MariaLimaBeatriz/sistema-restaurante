import cardapio.ComCheddar;
import cardapio.ItemCardapio;
import cardapio.Lanche;
import cardapio.LancheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemCardapioTest {

    @Test
    void xBaconComCheddarCusta26() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26.0, lanche.getPreco(), 0.001);
    }


    @Test
    void precoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Lanche("X-Teste", -5));
    }

    @Test
    void lancheSemCebolaMantemPrecoEAtualizaDescricao(){
        Lanche xBacon = LancheFactory.xBacon();
        xBacon.setCebola(false);

        assertEquals(22.0, xBacon.getPreco(),0.001);
        assertEquals("X-Bacon sem cebola", xBacon.getDescricao());
    }

    @Test
    void lanchePersonalizadoComAdicional() {
        Lanche lanche = LancheFactory.xSalada();
        lanche.setTomate(false);

        ItemCardapio comCheddar = new ComCheddar(lanche);

        assertEquals(22.0, comCheddar.getPreco(), 0.001);
        assertEquals("X-Salada sem tomate + cheddar", comCheddar.getDescricao());
    }
}
