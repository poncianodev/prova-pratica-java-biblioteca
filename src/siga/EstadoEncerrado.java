package siga;

public class EstadoEncerrado implements EstadoEmprestimo {

    @Override
    public String getSituacao() {
        return "ENCERRADO";
    }

    @Override
    public void emprestar(Emprestimo emprestimo) {
        throw new IllegalStateException("Nao e possivel emprestar em " + getSituacao() + ".");
    }

    @Override
    public void restituir(Emprestimo emprestimo) {
        throw new IllegalStateException("Nao e possivel restituir em " + getSituacao() + ".");
    }

    @Override
    public void anular(Emprestimo emprestimo) {
        throw new IllegalStateException("Nao e possivel anular em " + getSituacao() + ".");
    }
}