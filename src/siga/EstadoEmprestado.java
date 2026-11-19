package siga;

public class EstadoEmprestado implements EstadoEmprestimo {

    @Override
    public String getSituacao() {
        return "EMPRESTADO";
    }

    @Override
    public void emprestar(Emprestimo emprestimo) {
        throw new IllegalStateException("Nao e possivel emprestar em " + getSituacao() + ".");
    }

    @Override
    public void restituir(Emprestimo emprestimo) {
        emprestimo.alterarEstado(new EstadoEncerrado());
    }

    @Override
    public void anular(Emprestimo emprestimo) {
        throw new IllegalStateException("Nao e possivel anular em " + getSituacao() + ".");
    }
}