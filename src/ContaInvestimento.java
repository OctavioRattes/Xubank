public class ContaInvestimento extends Conta {
    private double taxaAdministracao;

    public ContaInvestimento(Cliente cliente, double taxaAdministracao) {
        super(cliente);
        this.taxaAdministracao = taxaAdministracao;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao(valor, "SAQUE"));
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor - (valor * taxaAdministracao); // Cobra taxa sobre o valor depositado
        transacoes.add(new Transacao(valor, "DEPOSITO"));
    }

    @Override
    public double calcularRendimento() {
        return saldo * 0.01; // Rendimento fixo de 1% para simplificar
    }
}