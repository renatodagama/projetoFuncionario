

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;   
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

    public abstract double calcularPagamento();
}
