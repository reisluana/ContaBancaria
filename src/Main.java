import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Beyoncé";
        String tipoConta = "Corrente";

        double valor = 1567.99;
        Locale localeBR = new Locale("pt","BR");
        NumberFormat saldoAtual = NumberFormat.getCurrencyInstance(localeBR);

        int inputAcao = 0;


        String dadosDoCliente = """
                ***********************************************   
                Dados iniciais do cliente:
                
                Nome: %s
                Tipo de conta: %s 
                """.formatted(nome, tipoConta);

        System.out.println(dadosDoCliente + "Saldo Atual: " + saldoAtual.format(valor) +
                "\n***********************************************");

        String operacoes = """
                *** Operações ***
                
                1 - Consultar saldo
                2 - Receber valor 
                3 - Transferir valor
                4 - Sair
                
                Digite a opção desejada:
                """;

        Scanner leitura = new Scanner(System.in);

        while (inputAcao != 4) {
            System.out.println(operacoes);
            inputAcao = leitura.nextInt();
            break;
        }

        if (inputAcao == 1) {
            System.out.println("Seu saldo atual é: " + saldoAtual.format(valor));
        } else if (inputAcao == 3) {
            System.out.println("Digite o valor que deseja transferir");
            double transferido = leitura.nextDouble();
                if (transferido > valor) {
                    System.out.println("Saldo insuficiente");
                } else {
                    valor = valor - transferido;
                    System.out.println("Transferência realizada! Seu saldo atual é " + saldoAtual.format(valor));
                }
        } else if (inputAcao == 2) {
            System.out.println("Digite o valor a ser recebido");
            double recebido = leitura.nextDouble();
            valor = valor + recebido;
            System.out.println("Recebimento confirmado! Seu saldo atual é: " + saldoAtual.format(valor));
        } else if (inputAcao < 1 || inputAcao > 4) {
            System.out.println("Opção inválida");
        } else if (inputAcao == 4) {
            System.out.println("Operação encerrada");
        }

    }
}