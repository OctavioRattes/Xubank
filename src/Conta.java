import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static int nextId = 1;
    
    protected int id;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.id = nextId++;
        this.cliente = cliente;
        cliente.adicionarConta(this);
    }

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract double calcularRendimento();

    public String getExtrato() {
        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato da Conta ").append(id).append("\n");
        for (Transacao t : transacoes) {
            extrato.append(t.toString()).append("\n");
        }
        extrato.append("Saldo atual: R$").append(saldo);
        return extrato.toString();
    }

    // Getters
    public int getId() { return id; }
    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
}