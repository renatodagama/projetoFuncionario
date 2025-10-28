/*
 * 
 * Cadastrar pessoas: Preencher os arrays com dados do usuário.
 * 
 * exibir todas as pessoas: Percorrer os arrays e mostrar todas as informações.
 * 
 * Ordenar pessoas por nome ou por valor numerico.
 * 
 * aplicar bonus ou acrecimos em valores numericos de algumas pessoas (simulando logica de pagamento ou pontuacao).
 * 
 * o uso de loops e condicionais é obrigatório para manipular os arrays e realizar calculos ou buscas
 * 
 */

import java.util.Scanner;

public class App {
    
    private static Scanner teclado = new Scanner(System.in);
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
            
            
            opcao = teclado.nextInt();
            teclado.nextLine(); 
            switch (opcao) {
                
                // --- CASO 1: ASSALARIADO ---
                case 1: { 
                    System.out.println("\n[Cadastro de Assalariado]");
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("Salário Fixo: R$ ");
                    double salario = teclado.nextDouble();
                    System.out.print("Bônus Adicional: R$ ");
                    double bonus = teclado.nextDouble();
                    teclado.nextLine(); 

                    FuncionarioAssalariado func = new FuncionarioAssalariado(nome, cpf, "", salario, bonus);
                    double pagamento = func.calcularPagamento(); 
                    
                    atualizarTotais(func, pagamento);
                    
                    break; 
                }
                
                // --- CASO 2: HORISTA ---
                case 2: {
                    System.out.println("\n[Cadastro de Horista]");
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("Valor da Hora: R$ ");
                    double valorHora = teclado.nextDouble();
                    System.out.print("Horas Trabalhadas: ");
                    int horas = teclado.nextInt();
                    teclado.nextLine(); // Consome o "Enter" pendente

                    FuncionarioHorista func = new FuncionarioHorista(nome, cpf, valorHora, horas);
                    double pagamento = func.calcularPagamento();
                    
                    atualizarTotais(func, pagamento);
                    
                    break; 
                }

                // --- CASO 3: COMISSIONADO ---
                case 3: {
                    System.out.println("\n[Cadastro de Comissionado]");
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("Total de Vendas no Mês: R$ ");
                    double vendas = teclado.nextDouble();
                    System.out.print("Taxa de Comissão (ex: 0.10 para 10%): ");
                    double comissao = teclado.nextDouble();
                    teclado.nextLine(); 
                    
                    FuncionarioComissionado func = new FuncionarioComissionado(nome, cpf, vendas, comissao);
                    double pagamento = func.calcularPagamento();
                    
                    atualizarTotais(func, pagamento);
                    
                    break; 
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
        teclado.close();
    }
    
    // Método auxiliar para atualizar os totais 
    private static void atualizarTotais(Funcionario func, double pagamento) {
        custoTotal += pagamento;
        
        System.out.printf("[CADASTRO REALIZADO] Pagamento individual de %s: R$ %.2f%n", func.getNome(), pagamento);
        
        // Verifica se é o maior pagamento
        if (pagamento > maiorPagamento) {
            maiorPagamento = pagamento;
            nomeMaisBemPago = func.getNome();
        }
    }
    
    private static void exibirResumo() {
        System.out.println("\n\n        RESUMO DA FOLHA DE PAGAMENTO         ");
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