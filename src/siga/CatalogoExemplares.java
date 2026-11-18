package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * PROBLEMA 1 (parte A) - a conversao do formato legado feita aqui dentro,
 * e a dependencia da CLASSE CONCRETA do acervo central.
 *
 * Esta classe conhece o formato da matriz: que a coluna 0 e o codigo, a 1 e
 * a descricao e a 2 e a situacao em letra. Esse conhecimento deveria existir
 * em um unico lugar do sistema - e nao existe (ver RelatorioColecao).
 */
public class CatalogoExemplares {

    private final AcervoLegadoWS legado;

    public CatalogoExemplares(AcervoLegadoWS legado) {
        this.legado = legado;
    }

    public List<Exemplar> listarDisponiveis() {
        List<Exemplar> disponiveis = new ArrayList<>();
        for (String[] linha : legado.consultarExemplares()) {
            Exemplar item = new Exemplar(linha[0], linha[1]);
            // atencao: aqui so se reconhece a letra maiuscula
            item.setDisponivel("D".equals(linha[2]));
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }
}
