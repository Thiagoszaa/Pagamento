package modelos;

public class Pagamento {

    // atributos
    private String nomeFuncionario = "";
    private int matriculaFuncionario = 0;
    private int numeroDependentes = 0;
    private float salarioBase = 0;
    private float valorGratificao = 0;
    private float salarioBruto = 0;
    private float salarioliquido = 0;
    private float valorDescontoInss = 0;
    private float valorDescontoIrpf = 0;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(int matriculaFuncionario) throws Exception {
        if (matriculaFuncionario < 0) throw new Exception("Número de matrícula negativa");
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public float getValorDescontoInss() {
        return valorDescontoInss;
    }

    public void setValorDescontoInss(float valorDescontoInss) throws Exception {
        if (valorDescontoInss < 0) throw new Exception("Valor INSS negativo");
        this.valorDescontoInss = valorDescontoInss;
    }

    public float getValorDescontoIrpf() {
        return valorDescontoIrpf;
    }

    public void setValorDescontoIrpf(float valorDescontoIrpf) throws Exception {
        if (valorDescontoIrpf < 0) throw new Exception("Valor IRPF negativo");
        this.valorDescontoIrpf = valorDescontoIrpf;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) throws Exception {
        if (numeroDependentes < 0) throw new Exception("Número de dependentes negativo");
        this.numeroDependentes = numeroDependentes;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) throws Exception {
        if (salarioBase < 0) throw new Exception("Salário base negativo");
        this.salarioBase = salarioBase;
    }

    public float getValorGratificao() {
        return valorGratificao;
    }

    public void setValorGratificao(float valorGratificao) throws Exception {
        if (valorGratificao < 0) throw new Exception("Valor da gratificação negativo");
        this.valorGratificao = valorGratificao;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getSalarioliquido() {
        return salarioliquido;
    }

    public void setSalarioliquido(float salarioliquido) {
        this.salarioliquido = salarioliquido;
    }

    // Métodos


    public float calcularGratificacao() {
        if (valorGratificao <= 1000) {
            valorGratificao = 500.0f;
        }
        if (valorGratificao >= 1001 && valorGratificao <= 2000) {
            valorGratificao = 1250.0f;
        }
        if (valorGratificao > 2000) {
            valorGratificao = 2250.0f;
        }
        return valorGratificao;
    }

    public float calcularSalarioBruto() {
        return salarioBase + valorGratificao;
    }

    public float calcularDescontoFilhos() {
        return numeroDependentes * 123.0f;
    }

    public float calcularDescontoInss() {
        if (salarioBruto <= 1412.00f) {
            valorDescontoInss = salarioBruto * 0.075f;
        } else if (salarioBruto <= 2666.68f) {
            valorDescontoInss = salarioBruto * 0.09f;
        } else if (salarioBruto <= 4000.03f) {
            valorDescontoInss = salarioBruto * 0.12f;
        } else {
            valorDescontoInss = salarioBruto * 0.14f;
        }
        return valorDescontoInss;
    }

    public float calcularDescontoIrpf() {
        float salarioBruto = getSalarioBruto();
        float descontoIrpf = 0;

        if (salarioBruto <= 2259.20f) {
            descontoIrpf = 0; // Isento
        } else if (salarioBruto >= 2259.21f && salarioBruto <= 2826.65f) {
            descontoIrpf = salarioBruto * 0.075f; // 7,5%
        } else if (salarioBruto >= 2826.66f && salarioBruto <= 3751.05f) {
            descontoIrpf = salarioBruto * 0.15f; // 15%
        } else if (salarioBruto >= 3751.06f && salarioBruto <= 4664.68f) {
            descontoIrpf = salarioBruto * 0.225f; // 22,5%
        } else {
            descontoIrpf = salarioBruto * 0.275f; // 27,5%
        }

        return descontoIrpf;
    }

}
