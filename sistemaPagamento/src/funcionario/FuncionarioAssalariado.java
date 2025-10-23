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

public class FuncionarioAssalariado extends Funcionario {
    private double bonus;

    public FuncionarioAssalariado(String nome, String cpf, double salario, double bonus) {
        // CORREÇÃO: Passando o cargo fixo para o construtor da superclasse
        super(nome, cpf, salario, "Assalariado"); 
        this.bonus = bonus;
    }
    
    @Override
    public double calcularPagamento() {
        // Retorna o salário base (herdado) + o bônus
        return salario + bonus; 
    }
}