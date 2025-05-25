import java.util.Date;

public class ContaRendaFixa extends Conta {
    private double taxaRendimento;
    private Date vencimento;
    private final double tarifa = 20.0;

    public ContaRendaFixa(Cliente cliente, double taxaRendimento, Date vencimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
        this.vencimento = vencimento;
    }

    @Override
    public void sacar(double valor) {
        if (new Date().before(vencimento)) {
            throw new IllegalArgumentException("Não pode sacar antes do vencimento");
        }
        if (valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao(valor, "SAQUE"));
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor - tarifa; // Cobra tarifa no depósito
        transacoes.add(new Transacao(valor, "DEPOSITO"));
    }

    @Override
    public double calcularRendimento() {
        return saldo * taxaRendimento;
    }
}