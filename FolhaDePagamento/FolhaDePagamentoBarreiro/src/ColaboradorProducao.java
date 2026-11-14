public class ColaboradorProducao extends Colaborador {
    public int quantidadePecas;
    public double valorPeca;

    public ColaboradorProducao() {
        tipo = "Produção";
    }

    public double calcularProdutividade() {
        return quantidadePecas * valorPeca;
    }

    public double calcularSalarioFinal() {
        return salarioBase + calcularProdutividade();
    }

    public void exibirFolha() {
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Quantidade de Peças: " + quantidadePecas);
        System.out.println("Valor por Peça: R$ " + valorPeca);
        System.out.println("Produtividade: R$ " + calcularProdutividade());
        System.out.println("Salário Final: R$ " + calcularSalarioFinal());
    }
}