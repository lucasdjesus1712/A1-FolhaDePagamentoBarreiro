import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    
    public static void gerarFolha(ArrayList<Colaborador> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        System.out.println("========== FOLHA DE PAGAMENTO ==========");
        for (Colaborador c : lista) {
            c.exibirFolha();
            System.out.println("----------------------------------------");
        }

        System.out.println("Quantidade de colaboradores: " + lista.size());
        System.out.println("TOTAL DA FOLHA: R$ " + calcularTotal(lista));
    }

   
    public static void exibirResumo(ArrayList<Colaborador> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        System.out.println("========== RESUMO DA FOLHA ==========");
        System.out.println("Quantidade de colaboradores: " + lista.size());
        System.out.println("Soma total da folha: R$ " + calcularTotal(lista));
        System.out.println("Média salarial: R$ " + calcularMedia(lista));
    }

    
    public static double calcularTotal(ArrayList<Colaborador> lista) {
        double total = 0.0;
        for (Colaborador c : lista) {
            total += c.calcularSalarioFinal();
        }
        return total;
    }

    public static double calcularMedia(ArrayList<Colaborador> lista) {
        if (lista.isEmpty()) {
            return 0.0;
        }
        return calcularTotal(lista) / lista.size();
    }

   
    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static double lerNumero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                double valor = Double.parseDouble(sc.nextLine().replace(",", "."));
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("O valor não pode ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void lerDadosBasicos(Colaborador c) {
        c.nome = lerTexto("Nome: ");
        c.matricula = lerTexto("Matrícula: ");
    }

    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        // Colaboradores iniciais
        ColaboradorProducao cp1 = new ColaboradorProducao();
        cp1.nome = "João";
        cp1.matricula = "123";
        cp1.quantidadePecas = 100;
        cp1.valorPeca = 5.0;
        colaboradores.add(cp1);

        ColaboradorComissionado cc1 = new ColaboradorComissionado();
        cc1.nome = "Maria";
        cc1.matricula = "456";
        cc1.valorVendas = 20000.0;
        cc1.percentualComissao = 10.0;
        colaboradores.add(cc1);

        ColaboradorPadrao cpadrao1 = new ColaboradorPadrao();
        cpadrao1.nome = "Carlos";
        cpadrao1.matricula = "789";
        colaboradores.add(cpadrao1);

     
        int opcao;

        do {
            System.out.println();
            System.out.println("========== MENU ==========");
            System.out.println("1 - Cadastrar colaborador padrão");
            System.out.println("2 - Cadastrar colaborador comissionado");
            System.out.println("3 - Cadastrar colaborador de produção");
            System.out.println("4 - Gerar folha de pagamento");
            System.out.println("5 - Exibir resumo da folha");
            System.out.println("0 - Sair do programa");
            opcao = (int) lerNumero("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    ColaboradorPadrao a = new ColaboradorPadrao();
                    lerDadosBasicos(a);
                    colaboradores.add(a);
                    break;
                case 2:
                    ColaboradorComissionado b = new ColaboradorComissionado();
                    lerDadosBasicos(b);
                    b.valorVendas = lerNumero("Valor das vendas: ");
                    b.percentualComissao = lerNumero("Percentual de comissão (ex: 10): ");
                    colaboradores.add(b);
                    break;
                case 3:
                    ColaboradorProducao c = new ColaboradorProducao();
                    lerDadosBasicos(c);
                    c.quantidadePecas = (int) lerNumero("Quantidade de peças: ");
                    c.valorPeca = lerNumero("Valor por peça: ");
                    colaboradores.add(c);
                    break;
                case 4:
                    gerarFolha(colaboradores);
                    break;
                case 5:
                    exibirResumo(colaboradores);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}