public class Diretoria {
    private RelatorioConta relatorioConta;
    private RelatorioCliente relatorioCliente;

    public Diretoria(RelatorioConta relatorioConta, RelatorioCliente relatorioCliente) {
        this.relatorioConta = relatorioConta;
        this.relatorioCliente = relatorioCliente;
    }

    public String gerarRelatorioConsolidado() {
        return relatorioConta.gerar() + "\n\n" + relatorioCliente.gerar();
    }
}