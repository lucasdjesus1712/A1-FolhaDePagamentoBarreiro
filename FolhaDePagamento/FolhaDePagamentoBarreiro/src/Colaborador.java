public class Colaborador {
    public String nome;
    public String matricula;
    public String tipo = "Padrão";
    public double salarioBase = 2000.00;

    public double calcularSalarioFinal() {
        return salarioBase;
    }

    public void exibirFolha() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Salário Final: R$ " + calcularSalarioFinal());
    }

    public void exibirFolhaResumo() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Final: R$ " + calcularSalarioFinal());
    }
}