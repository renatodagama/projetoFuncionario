// Classe para Funcionário Horista (Herda de Funcionario).
public class FuncionarioHorista extends Funcionario {
    private double valorHora;
    private int horasTrabalhadas;

    public FuncionarioHorista(String nome, String cpf, double valorHora, int horasTrabalhadas) {
        // Salário base 0.0, pois é calculado por hora
        super(nome, cpf, 0.0, "Horista");
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularPagamento() {
        double pagamento = valorHora * horasTrabalhadas;
        
        // Caso ultrapasse 160 horas no mês, deve receber um bônus de 10%.
        if (horasTrabalhadas > 160) {
            pagamento *= 1.10; // Adiciona bônus de 10%
        }
        return pagamento;
    }
}