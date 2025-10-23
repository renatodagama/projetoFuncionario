// Classe para Funcionário Comissionado (Herda de Funcionario).
public class FuncionarioComissionado extends Funcionario {
    private double totalVendas;
    private double taxaComissao;

    public FuncionarioComissionado(String nome, String cpf, double totalVendas, double taxaComissao) {
        // Salário base 0.0, pois é calculado por comissão
        super(nome, cpf, 0.0, "Comissionado");
        this.totalVendas = totalVendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularPagamento() {
        // recebe com base no total de vendas realizadas e na taxa de comissão.
        return totalVendas * taxaComissao;
    }
}