package siga;

import java.util.ArrayList;
import java.util.List;

public class AcervoLegadoAdapter implements RepositorioAcervo {

    private final AcervoLegadoWS legado;

    public AcervoLegadoAdapter(AcervoLegadoWS legado) {
        this.legado = legado;
    }

    @Override
    public List<Exemplar> listarExemplares() {
        List<Exemplar> exemplares = new ArrayList<>();
        for (String[] linha : legado.consultarExemplares()) {
            Exemplar item = new Exemplar(linha[0], linha[1]);
            item.setDisponivel("D".equalsIgnoreCase(linha[2]));
            exemplares.add(item);
        }
        return exemplares;
    }
}