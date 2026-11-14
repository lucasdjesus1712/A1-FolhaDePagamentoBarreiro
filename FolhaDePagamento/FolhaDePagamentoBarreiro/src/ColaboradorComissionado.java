public class ColaboradorComissionado extends Colaborador {
    public double valorVendas = 0.0;
    public double percentualComissao = 0.1;

    public ColaboradorComissionado() {
        tipo = "Comissionado";
    }

    public double calcularComissao() {
        return valorVendas * percentualComissao / 100;
    }

    public double calcularSalarioFinal() {
        return salarioBase + calcularComissao();
    }

    public void exibirFolha() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Valor de Vendas: R$ " + valorVendas);
        System.out.println("Percentual de Comissão: " + percentualComissao + "%");
        System.out.println("Comissão: R$ " + calcularComissao());
        System.out.println("Salário Final: R$ " + calcularSalarioFinal());
    }
}