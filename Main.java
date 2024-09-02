import modelos.Pagamento;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            // ATRIBUTOS
            String nomeFuncionario = "";
            float valorDescontoInss = 0;
            float valorDescontoIrpf = 0;
            int matriculaFuncionario = 0;
            int numeroDependentes = 0;
            float salarioBase = 0;
            float valorGratificao = 0;
            float salarioBruto = 0;
            float salarioliquido = 0;

            Pagamento pagamento = new Pagamento();
            pagamento.setNomeFuncionario(JOptionPane.showInputDialog("Digite o nome do funcionário:"));
            pagamento.setMatriculaFuncionario(Integer.parseInt(JOptionPane.showInputDialog("Digite matrícula do funcionário:")));
            pagamento.setNumeroDependentes(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dependentes:")));
            pagamento.setSalarioBase(Float.parseFloat(JOptionPane.showInputDialog("Digite o salário base do funcionário:")));

            // Gratificação = quantidade de itens vendidos
            pagamento.setValorGratificao(Float.parseFloat(JOptionPane.showInputDialog("Produção de quantos itens?:")));

            // Calcula o salário bruto do empregado
            pagamento.setSalarioBruto(pagamento.calcularSalarioBruto());

            // Calcula o valor do desconto do INSS com base no salário bruto
            pagamento.setValorDescontoInss(pagamento.calcularDescontoInss());

            // Calcula o valor do desconto do IRPF com base no salário bruto
            pagamento.setValorDescontoIrpf(pagamento.calcularDescontoIrpf());

            // Calcula o salário líquido subtraindo os descontos de INSS e IRPF do salário bruto
            pagamento.setSalarioliquido(pagamento.getSalarioBruto()
                    - pagamento.getValorDescontoInss()
                    - pagamento.getValorDescontoIrpf());

            String saida = "Pagamento GYN ALIMENTOS \n";
            saida += "DADOS DE PAGAMENTO \n";
            saida += "Nome funcionário: " + pagamento.getNomeFuncionario() + "\n";
            saida += "Matrícula funcionário: " + pagamento.getMatriculaFuncionario() + "\n";
            saida += "Número de dependentes: " + pagamento.getNumeroDependentes() + "\n";
            saida += "Valor gratificação: " +  String.format("%.2f",pagamento.calcularGratificacao()) + "\n";
            saida += "Salário Base: " + pagamento.getSalarioBase() + "\n";
            saida += "Valor salário bruto: " +  String.format("%.2f",pagamento.calcularSalarioBruto()) + "\n";
            saida += "Valor desconto do INSS: " + String.format("%.2f", pagamento.getValorDescontoInss()) + "\n";
            saida += "Valor desconto IRPF: " + String.format("%.2f" ,pagamento.getValorDescontoIrpf()) + "\n";
            saida += "Valor desconto por filhos: " + pagamento.calcularDescontoFilhos() + "\n";
            saida += "Salário líquido: " + String.format("%.2f", pagamento.getSalarioliquido()) + "\n";


            // Instrução que vai exibir a interface com os valores
            JOptionPane.showMessageDialog(null, saida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
