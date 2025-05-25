import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Cliente> clientes;
    private Diretoria diretoria;
    private Scanner scanner;
    private Cliente clienteLogado;

    public Menu(List<Cliente> clientes) {
        this.clientes = clientes;
        this.diretoria = new Diretoria(
            new RelatorioConta(clientes.stream().flatMap(c -> c.getContas().stream()).toList()),
            new RelatorioCliente(clientes)
        );
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            if (clienteLogado == null) {
                exibirMenuPrincipal();
            } else {
                exibirMenuCliente();
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n=== XUBANK ===");
        System.out.println("1. Login");
        System.out.println("2. Cadastrar cliente");
        System.out.println("3. Relatórios (Diretoria)");
        System.out.println("4. Sair");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        switch (opcao) {
            case 1 -> fazerLogin();
            case 2 -> cadastrarCliente();
            case 3 -> exibirRelatorios();
            case 4 -> System.exit(0);
            default -> System.out.println("Opção inválida!");
        }
    }

    private void exibirMenuCliente() {
        System.out.println("\n=== BEM-VINDO, " + clienteLogado.getNome() + " ===");
        System.out.println("1. Minhas contas");
        System.out.println("2. Abrir nova conta");
        System.out.println("3. Realizar operação");
        System.out.println("4. Extrato");
        System.out.println("5. Logout");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> listarContas();
            case 2 -> abrirConta();
            case 3 -> realizarOperacao();
            case 4 -> exibirExtrato();
            case 5 -> logout();
            default -> System.out.println("Opção inválida!");
        }
    }

    private void fazerLogin() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        clienteLogado = clientes.stream()
            .filter(c -> c.getCpf().equals(cpf) && c.getSenha().equals(senha))
            .findFirst()
            .orElse(null);

        if (clienteLogado == null) {
            System.out.println("CPF ou senha incorretos!");
        }
    }

    private void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        clientes.add(new Cliente(nome, cpf, senha));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void exibirRelatorios() {
        System.out.println("\n=== RELATÓRIOS ===");
        System.out.println(diretoria.gerarRelatorioConsolidado());
    }

    private void listarContas() {
        System.out.println("\n=== SUAS CONTAS ===");
        clienteLogado.getContas().forEach(c -> 
            System.out.println(c.getClass().getSimpleName() + " - Saldo: R$" + c.getSaldo())
        );
    }

    private void abrirConta() {
        System.out.println("\nTipos de conta:");
        System.out.println("1. Corrente");
        System.out.println("2. Poupança");
        System.out.println("3. Renda Fixa");
        System.out.println("4. Investimento");
        System.out.print("Escolha: ");
        
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Conta novaConta = switch (tipo) {
            case 1 -> {
                System.out.print("Limite de crédito: ");
                double limite = scanner.nextDouble();
                yield new ContaCorrente(clienteLogado, limite);
            }
            case 2 -> {
                System.out.print("Taxa de rendimento (%): ");
                double rendimento = scanner.nextDouble() / 100;
                yield new ContaPoupanca(clienteLogado, rendimento);
            }
            case 3 -> {
                System.out.print("Taxa de rendimento (%): ");
                double rendimento = scanner.nextDouble() / 100;
                yield new ContaRendaFixa(clienteLogado, rendimento, new Date());
            }
            case 4 -> {
                System.out.print("Taxa de administração (%): ");
                double taxa = scanner.nextDouble() / 100;
                yield new ContaInvestimento(clienteLogado, taxa);
            }
            default -> throw new IllegalArgumentException("Tipo inválido");
        };

        clienteLogado.adicionarConta(novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    private void realizarOperacao() {
        Conta conta = selecionarConta();
        if (conta == null) return;

        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.print("Escolha: ");
        
        int opcao = scanner.nextInt();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        try {
            if (opcao == 1) {
                conta.depositar(valor);
                System.out.println("Depósito realizado!");
            } else if (opcao == 2) {
                conta.sacar(valor);
                System.out.println("Saque realizado!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private Conta selecionarConta() {
        if (clienteLogado.getContas().isEmpty()) {
            System.out.println("Você não tem contas!");
            return null;
        }

        listarContas();
        System.out.print("Número da conta: ");
        int id = scanner.nextInt();
        
        return clienteLogado.getContas().stream()
            .filter(c -> c.getId() == id)
            .findFirst()
            .orElse(null);
    }

    private void exibirExtrato() {
        Conta conta = selecionarConta();
        if (conta != null) {
            System.out.println(conta.getExtrato());
        }
    }

    private void logout() {
        clienteLogado = null;
        System.out.println("Logout realizado com sucesso!");
    }
}