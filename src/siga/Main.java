package siga;

/**
 * Demonstra os dois problemas e, ao final, roda a VerificacaoRapida.
 *
 * Voce VAI precisar alterar a montagem abaixo quando resolver o Problema 1
 * - e so isso. O resto do arquivo pode ficar como esta.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Emprestimo da Biblioteca - Prova Pratica ===");
        System.out.println();

        AcervoLegadoWS legado = new AcervoLegadoWS();
        CatalogoExemplares catalogo = new CatalogoExemplares(legado);
        RelatorioColecao relatorio = new RelatorioColecao(legado);

        System.out.println("1) O mesmo dado, convertido em dois lugares");
        System.out.println("   Disponiveis segundo o catalogo:");
        for (Exemplar item : catalogo.listarDisponiveis()) {
            System.out.println("     " + item);
        }
        relatorio.imprimir();

        System.out.println();
        System.out.println("2) O ciclo de vida em condicionais");
        Emprestimo registro = new Emprestimo(
                new Leitor("Bruno Lima", "PROFESSOR"),
                new Exemplar("TOM-2001", "Clean Code"));
        System.out.println("   situacao inicial: " + registro.getSituacao());
        registro.emprestar();
        System.out.println("   apos emprestar: " + registro.getSituacao());
        registro.restituir();
        System.out.println("   apos restituir: " + registro.getSituacao());
        try {
            registro.anular();
        } catch (IllegalStateException erro) {
            System.out.println("   [erro] " + erro.getMessage());
        }

        VerificacaoRapida.verificar(catalogo, relatorio);
    }
}
