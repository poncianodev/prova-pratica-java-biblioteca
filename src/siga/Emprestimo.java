package siga;

public class Emprestimo {

    private final Leitor solicitante;
    private final Exemplar item;
    private EstadoEmprestimo estado;

    public Emprestimo(Leitor solicitante, Exemplar item) {
        this.solicitante = solicitante;
        this.item = item;
        this.estado = new EstadoReservado();
    }

    void alterarEstado(EstadoEmprestimo novoEstado) {
        this.estado = novoEstado;
    }

    public String getSituacao() {
        return estado.getSituacao();
    }

    public void emprestar() {
        estado.emprestar(this);
    }

    public void restituir() {
        estado.restituir(this);
    }

    public void anular() {
        estado.anular(this);
    }

    public Leitor getSolicitante() {
        return solicitante;
    }

    public Exemplar getExemplar() {
        return item;
    }
}
