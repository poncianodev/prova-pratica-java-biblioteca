package siga;

import java.util.List;

public class RelatorioColecao {

    private final RepositorioAcervo repositorio;

    public RelatorioColecao(RepositorioAcervo repositorio) {
        this.repositorio = repositorio;
    }

    public List<Exemplar> listarTodos() {
        return repositorio.listarExemplares();
    }

    public void imprimir() {
        System.out.println("   Situacao segundo o relatorio:");
        for (Exemplar item : listarTodos()) {
            System.out.println("     " + item + " - "
                    + (item.isDisponivel() ? "disponivel" : "baixado"));
        }
    }
}
