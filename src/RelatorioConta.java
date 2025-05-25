import java.util.List;

public class RelatorioConta implements Relatorio {
    private List<Conta> contas;

    public RelatorioConta(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String gerar() {
        return "Relatório de Contas:\n" +
               "Total em custódia: R$" + getTotalCustodia("TODOS") + "\n" +
               "Saldo médio: R$" + getSaldoMedio();
    }

    public double getTotalCustodia(String tipoConta) {
        return contas.stream()
                .filter(c -> tipoConta.equals("TODOS") || c.getClass().getSimpleName().equalsIgnoreCase(tipoConta))
                .mapToDouble(Conta::getSaldo)
                .sum();
    }

    public double getSaldoMedio() {
        return contas.stream()
                .mapToDouble(Conta::getSaldo)
                .average()
                .orElse(0.0);
    }
}