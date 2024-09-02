# Documentação do Programa de Pagamento

## Descrição

Este programa em Java calcula e exibe o pagamento de um funcionário com base em diversos fatores, incluindo salário base, gratificação, descontos de INSS e IRPF, e o número de dependentes. O cálculo do salário bruto, descontos e salário líquido é realizado e exibido em uma caixa de diálogo.

## Funcionalidade

1. **Entrada de Dados:**
    - Nome do Funcionário
    - Matrícula do Funcionário
    - Número de Dependentes
    - Salário Base
    - Quantidade de Itens Vendidos (usado para calcular a gratificação)

2. **Cálculos:**
    - Salário Bruto: Salário Base + Gratificação
    - Desconto de INSS: Calculado com base no salário bruto
    - Desconto de IRPF: Calculado com base no salário bruto
    - Salário Líquido: Salário Bruto - Descontos de INSS e IRPF - Desconto por Dependentes

3. **Saída:**
    - Exibe uma caixa de diálogo com os dados formatados do pagamento, incluindo nome do funcionário, matrícula, número de dependentes, gratificação, salário base, salário bruto, descontos e salário líquido.
