import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando o banco
        Banco meuBanco = new Banco();
        meuBanco.setNome("Banco Digital DIO");

        // Criando clientes
        Cliente kebler = new Cliente();
        kebler.setNome("Kebler");

        Cliente joao = new Cliente();
        joao.setNome("João");

        // Criando contas
        IConta cc = new ContaCorrente(kebler);
        IConta poupanca = new ContaPoupanca(joao);

        // Adicionando contas ao banco
        List<Conta> contas = new ArrayList<>();
        contas.add((Conta) cc);
        contas.add((Conta) poupanca);
        meuBanco.setContas(contas);

        // Realizando operações
        cc.depositar(100);
        System.out.println("--- Operações na Conta Corrente de " + kebler.getNome() + " ---");
        cc.imprimirExtrato();

        System.out.println("\n--- Transferência de CC para Poupança ---");
        cc.transferir(50, poupanca);

        System.out.println("\n--- Extratos Após Transferência ---");
        cc.imprimirExtrato();
        System.out.println();
        poupanca.imprimirExtrato();

        // Testando validações
        System.out.println("\n--- Testando Saque Inválido ---");
        cc.sacar(100);
        cc.imprimirExtrato();
    }
}