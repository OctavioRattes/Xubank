import java.util.List;

public class RelatorioCliente implements Relatorio {
    private List<Cliente> clientes;

    public RelatorioCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String gerar() {
        return "Relatório de Clientes:\n" +
               "Cliente com maior saldo: " + getClienteMaiorSaldo().getNome() + "\n" +
               "Cliente com menor saldo: " + getClienteMenorSaldo().getNome();
    }

    public Cliente getClienteMaiorSaldo() {
        return clientes.stream()
                .max((c1, c2) -> Double.compare(c1.getSaldoTotal(), c2.getSaldoTotal()))
                .orElse(null);
    }

    public Cliente getClienteMenorSaldo() {
        return clientes.stream()
                .min((c1, c2) -> Double.compare(c1.getSaldoTotal(), c2.getSaldoTotal()))
                .orElse(null);
    }
}