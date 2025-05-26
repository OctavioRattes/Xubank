public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente, double taxaRendimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
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
        saldo += valor;
        transacoes.add(new Transacao(valor, "DEPOSITO"));
    }

    @Override
    public double calcularRendimento() {
        return saldo * taxaRendimento;
    }
}