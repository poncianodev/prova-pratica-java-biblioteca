package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * PROBLEMA 1 (parte B) - a MESMA conversao, escrita de novo, em outro lugar.
 *
 * Aqui alguem percebeu que a situacao as vezes vem em minuscula e corrigiu.
 * A correcao nao chegou ao CatalogoExemplares: as duas versoes ja divergem, e o
 * mesmo Exemplar aparece indisponivel em um lugar e disponivel no outro.
 */
public class RelatorioColecao {

    private final AcervoLegadoWS legado;

    public RelatorioColecao(AcervoLegadoWS legado) {
        this.legado = legado;
    }

    public List<Exemplar> listarTodos() {
        List<Exemplar> todos = new ArrayList<>();
        for (String[] linha : legado.consultarExemplares()) {
            Exemplar item = new Exemplar(linha[0], linha[1]);
            // aqui a minuscula foi tratada
            item.setDisponivel("D".equalsIgnoreCase(linha[2]));
            todos.add(item);
        }
        return todos;
    }

    public void imprimir() {
        System.out.println("   Situacao segundo o relatorio:");
        for (Exemplar item : listarTodos()) {
            System.out.println("     " + item + " - "
                    + (item.isDisponivel() ? "disponivel" : "baixado"));
        }
    }
}
