import java.util.Date;

public class Transacao {
    private Date data;
    private double valor;
    private String tipo; // "SAQUE" ou "DEPOSITO"

    public Transacao(double valor, String tipo) {
        this.data = new Date();
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: R$%.2f", data, tipo, valor);
    }
}