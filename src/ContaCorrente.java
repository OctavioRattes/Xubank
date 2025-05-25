public class ContaCorrente extends Conta {
    private double limiteCredito;
    private final double taxaNegativo = 0.03;
    private final double tarifaFixa = 10.0;

    public ContaCorrente(Cliente cliente, double limiteCredito) {
        super(cliente);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limiteCredito) {
            saldo -= valor;
            transacoes.add(new Transacao(valor, "SAQUE"));
        } else {
            throw new IllegalArgumentException("Saldo + limite insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        if (saldo < 0) {
            double taxa = Math.abs(saldo) * taxaNegativo + tarifaFixa;
            valor -= taxa;
        }
        saldo += valor;
        transacoes.add(new Transacao(valor, "DEPOSITO"));
    }

    @Override
    public double calcularRendimento() {
        return 0; // Conta corrente não tem rendimento
    }
}