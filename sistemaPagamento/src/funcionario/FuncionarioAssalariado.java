

// Classe para Funcionário Assalariado (Herda de Funcionario).
public class FuncionarioAssalariado extends Funcionario {
    private double bonus;

    public FuncionarioAssalariado(String nome, String cpf, String cargo, double salario, double bonus) {
        // Salário é passado para a superclasse
        super(nome, cpf, salario, "Assalariado"); 
        this.bonus = bonus;
    }
    
    @Override
    public double calcularPagamento() {
        // salário fixo mensal acrescido de um bônus adicional.
        return salario + bonus; 
    }
}