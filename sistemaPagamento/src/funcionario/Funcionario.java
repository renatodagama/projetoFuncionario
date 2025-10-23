// Uma classe abstrata que implemente a interface e defina a estrutura básica.
public abstract class Funcionario implements PagamentoCalculavel {
    protected String nome;
    protected String cpf;
    protected double salario; // Usado só pelo Assalariado
    protected String cargo;

    public Funcionario(String nome, String cpf, double salario, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    /*  
        O método calcularPagamento é obrigatório pela interface, mas é abstrato
        aqui para ser implementado pelas subclasses específicas.
    */
    @Override
    public abstract double calcularPagamento();
}