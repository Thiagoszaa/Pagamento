package modelos;

public class Pagamento {

    private String nomeFuncionario = "";
    private int matriculaFuncionario = 0;
    private int numeroDependentes = 0;
    private float salarioBase = 0;
    private float producaoItem = 0;

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

    public float getProducaoItem() {
        return producaoItem;
    }

    public void setProducaoItem(float producaoItem) throws Exception {
        if (producaoItem < 0) throw new Exception("Valor da produção negativo");
        this.producaoItem = producaoItem;
    }

    public float calcularGratificacao() {
        if (producaoItem <= 1000) return 500.0f;
        if (producaoItem <= 2000) return 1250.0f;
        return 2250.0f;
    }

    public float calcularSalarioBruto() {
        return salarioBase + calcularGratificacao();
    }

    public float calcularDescontoInss() {
        float salarioBruto = calcularSalarioBruto();

        if (salarioBruto <= 1412.00f) return salarioBruto * 0.075f;
        if (salarioBruto <= 2666.68f) return salarioBruto * 0.09f;
        if (salarioBruto <= 4000.03f) return salarioBruto * 0.12f;
        return salarioBruto * 0.14f;
    }

    public float calcularDescontoIrpf() {
        float salarioBruto = calcularSalarioBruto();

        if (salarioBruto < 2259.20f) return 0;
        if (salarioBruto <= 2826.65f) return salarioBruto * 0.075f;
        if (salarioBruto <= 3751.05f) return salarioBruto * 0.15f;
        if (salarioBruto <= 4664.68f) return salarioBruto * 0.225f;
        return salarioBruto * 0.275f;
    }

    public float calcularDescontoDependentes() {
        return numeroDependentes * 123;
    }

    public float calcularSalarioLiquido() {
        return calcularSalarioBruto() - calcularDescontoInss() - calcularDescontoIrpf() + calcularDescontoDependentes();
    }

}
