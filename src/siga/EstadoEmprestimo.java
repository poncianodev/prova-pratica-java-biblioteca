package siga;

public interface EstadoEmprestimo {
    String getSituacao();

    void emprestar(Emprestimo emprestimo);

    void restituir(Emprestimo emprestimo);

    void anular(Emprestimo emprestimo);
}