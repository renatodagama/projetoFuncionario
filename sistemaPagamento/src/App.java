/*  
 * 
 * Enunciado — Sistema de Pagamento de
Funcionários
Uma empresa está enfrentando dificuldades para realizar corretamente os pagamentos de
seus funcionários.
Atualmente, existem três tipos de funcionários na empresa, e cada um possui uma
forma diferente de cálculo de pagamento.
O objetivo é organizar o fluxo de pagamento e criar um sistema que realize
automaticamente o cálculo correto da remuneração de cada tipo de funcionário, conforme
suas regras específicas:
● Funcionário Horista: recebe de acordo com o número de horas trabalhadas e o
valor da hora. Caso ultrapasse 160 horas no mês, deve receber um bônus de 10%.
● Funcionário Comissionado: recebe com base no total de vendas realizadas e na
taxa de comissão estabelecida.
● Funcionário Assalariado: recebe um salário fixo mensal acrescido de um bônus
adicional.

O sistema deve permitir o cadastro dos funcionários via teclado, exibir o pagamento
individual de cada um, calcular o total pago pela empresa e indicar qual funcionário
recebeu o maior valor no mês.

Projeto Java — Sistema de Pagamento
de Funcionários

Objetivo
Desenvolver um sistema em Java para o cálculo de pagamento de funcionários, utilizando
conceitos de interfaces, classes abstratas, herança, polimorfismo e entrada de dados
via teclado (Scanner).

Requisitos do Projeto
Interface de Pagamento
● Criar uma interface que defina o método para calcular o pagamento de um
funcionário.
● Todas as classes concretas deverão implementar essa interface.
 */


import java.util.Scanner;


public class App {
    
    // As variáveis "globais" continuam aqui, para guardar o resumo
    private static Scanner scanner = new Scanner(System.in);
    private static double custoTotal = 0.0;
    private static double maiorPagamento = 0.0;
    private static String nomeMaisBemPago = "Nenhum";

    public static void main(String[] args) {
        
        int opcao;

        do {
            System.out.println("\n--- Menu de Cadastro de Funcionários ---");
            System.out.println("1. Cadastrar Funcionário Assalariado");
            System.out.println("2. Cadastrar Funcionário Horista");
            System.out.println("3. Cadastrar Funcionário Comissionado");
            System.out.println("4. Exibir Resumo e Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                
                // --- CASO 1: ASSALARIADO ---
                case 1: { // Usamos {chaves} para isolar as variáveis deste caso
                    System.out.println("\n[Cadastro de Assalariado]");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Salário Fixo: R$ ");
                    double salario = scanner.nextDouble();
                    System.out.print("Bônus Adicional: R$ ");
                    double bonus = scanner.nextDouble();
                    scanner.nextLine(); // Consome o "Enter" pendente

                    // 1. Cria o objeto
                    FuncionarioAssalariado func = new FuncionarioAssalariado(nome, cpf, salario, bonus);
                    
                    // 2. Calcula o pagamento (ele mesmo sabe como fazer)
                    double pagamento = func.calcularPagamento();
                    
                    // 3. Atualiza os totais
                    custoTotal += pagamento;
                    
                    System.out.printf("[CADASTRO REALIZADO] Pagamento individual de %s: R$ %.2f%n", func.getNome(), pagamento);
                    
                    // 4. Verifica se é o maior pagamento
                    if (pagamento > maiorPagamento) {
                        maiorPagamento = pagamento;
                        nomeMaisBemPago = func.getNome();
                    }
                    
                    break; // Fim do case 1
                }
                
                // --- CASO 2: HORISTA ---
                case 2: {
                    System.out.println("\n[Cadastro de Horista]");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Valor da Hora: R$ ");
                    double valorHora = scanner.nextDouble();
                    System.out.print("Horas Trabalhadas: ");
                    int horas = scanner.nextInt();
                    scanner.nextLine(); // Consome o "Enter" pendente

                    // 1. Cria o objeto
                    FuncionarioHorista func = new FuncionarioHorista(nome, cpf, valorHora, horas);
                    
                    // 2. Calcula o pagamento
                    double pagamento = func.calcularPagamento();
                    
                    // 3. Atualiza os totais
                    custoTotal += pagamento;
                    
                    System.out.printf("[CADASTRO REALIZADO] Pagamento individual de %s: R$ %.2f%n", func.getNome(), pagamento);

                    // 4. Verifica se é o maior pagamento
                    if (pagamento > maiorPagamento) {
                        maiorPagamento = pagamento;
                        nomeMaisBemPago = func.getNome();
                    }
                    
                    break; // Fim do case 2
                }

                // --- CASO 3: COMISSIONADO ---
                case 3: {
                    System.out.println("\n[Cadastro de Comissionado]");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Total de Vendas no Mês: R$ ");
                    double vendas = scanner.nextDouble();
                    System.out.print("Taxa de Comissão (ex: 0.10 para 10%): ");
                    double comissao = scanner.nextDouble();
                    scanner.nextLine(); // Consome o "Enter" pendente
                    
                    // 1. Cria o objeto
                    FuncionarioComissionado func = new FuncionarioComissionado(nome, cpf, vendas, comissao);
                    
                    // 2. Calcula o pagamento
                    double pagamento = func.calcularPagamento();
                    
                    // 3. Atualiza os totais
                    custoTotal += pagamento;
                    
                    System.out.printf("[CADASTRO REALIZADO] Pagamento individual de %s: R$ %.2f%n", func.getNome(), pagamento);

                    // 4. Verifica se é o maior pagamento
                    if (pagamento > maiorPagamento) {
                        maiorPagamento = pagamento;
                        nomeMaisBemPago = func.getNome();
                    }
                    
                    break; // Fim do case 3
                }
                
                // --- CASO 4: SAIR E RESUMO ---
                case 4:
                    exibirResumo();
                    break;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        } while (opcao != 4);

        System.out.println("Encerrando sistema...");
        scanner.close();
    }
    
    // O método de exibir o resumo pode continuar separado,
    // pois ele só é chamado uma vez e é bem simples.
    private static void exibirResumo() {
        System.out.println("\n=============================================");
        System.out.println("         RESUMO DA FOLHA DE PAGAMENTO        ");
        System.out.println("=============================================");
        
        System.out.printf("  Custo Total da Empresa: R$ %.2f%n", custoTotal);
        
        if (custoTotal > 0) {
            System.out.printf("  Funcionário Mais Bem Pago: %s%n", nomeMaisBemPago);
            System.out.printf("  Valor do Maior Pagamento: R$ %.2f%n", maiorPagamento);
        } else {
             System.out.println("  Nenhum funcionário foi cadastrado.");
        }
        
        System.out.println("=============================================");
    }
}