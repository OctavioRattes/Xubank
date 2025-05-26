import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public String getExtrato(Conta conta) {
        return conta.getExtrato();
    }

    public double getSaldoTotal() {
        return contas.stream()
                .mapToDouble(Conta::getSaldo)
                .sum();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getSenha() { return senha; }
    public List<Conta> getContas() { return contas; }

}