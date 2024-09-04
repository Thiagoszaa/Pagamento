import modelos.Pagamento;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            Pagamento pagamento = new Pagamento();
            pagamento.setNomeFuncionario(JOptionPane.showInputDialog("Digite o nome do funcionário:"));
            pagamento.setMatriculaFuncionario(Integer.parseInt(JOptionPane.showInputDialog("Digite a matrícula do funcionário:")));
            pagamento.setNumeroDependentes(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dependentes:")));
            pagamento.setSalarioBase(Float.parseFloat(JOptionPane.showInputDialog("Digite o salário base do funcionário:")));
            pagamento.setProducaoItem(Float.parseFloat(JOptionPane.showInputDialog("Produção de quantos itens?:")));

            String saida = "Pagamento GYN ALIMENTOS \n";
            saida += "DADOS DE PAGAMENTO \n";
            saida += "Nome funcionário: " + pagamento.getNomeFuncionario() + "\n";
            saida += "Matrícula funcionário: " + pagamento.getMatriculaFuncionario() + "\n";
            saida += "Número de dependentes: " + pagamento.getNumeroDependentes() + "\n";
            saida += "Salário Base: " + String.format("%.2f", pagamento.getSalarioBase()) + "\n";
            saida += "Valor gratificação: " + String.format("%.2f", pagamento.calcularGratificacao()) + "\n";
            saida += "Salário bruto: " + String.format("%.2f", pagamento.calcularSalarioBruto()) + "\n";
            saida += "Valor desconto por filhos: " + String.format("%.2f", pagamento.calcularDescontoDependentes()) + "\n";
            saida += "Valor desconto do INSS: " + String.format("%.2f", pagamento.calcularDescontoInss()) + "\n";
            saida += "Valor desconto IRPF: " + String.format("%.2f", pagamento.calcularDescontoIrpf()) + "\n";
            saida += "Salário líquido: " + String.format("%.2f", pagamento.calcularSalarioLiquido()) + "\n";

            JOptionPane.showMessageDialog(null, saida);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

