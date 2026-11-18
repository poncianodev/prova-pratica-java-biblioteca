package siga;

import java.util.ArrayList;
import java.util.List;

public class CatalogoExemplares {

    private final RepositorioAcervo repositorio;

    public CatalogoExemplares(RepositorioAcervo repositorio) {
        this.repositorio = repositorio;
    }

    public List<Exemplar> listarDisponiveis() {
        List<Exemplar> disponiveis = new ArrayList<>();
        for (Exemplar item : repositorio.listarExemplares()) {
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }
}
