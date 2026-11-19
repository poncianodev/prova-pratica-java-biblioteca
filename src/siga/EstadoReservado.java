package siga;

public class EstadoReservado implements EstadoEmprestimo {

    @Override
    public String getSituacao() {
        return "RESERVADO";
    }

    @Override
    public void emprestar(Emprestimo emprestimo) {
        emprestimo.alterarEstado(new EstadoEmprestado());
    }

    @Override
    public void restituir(Emprestimo emprestimo) {
        throw new IllegalStateException("Nao e possivel restituir em " + getSituacao() + ".");
    }

    @Override
    public void anular(Emprestimo emprestimo) {
        emprestimo.alterarEstado(new EstadoEncerrado());
    }
}