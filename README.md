# Xubank
Sistema simples de contas em banco.
Trabalho prático proposto na matéria de programação modular pelo professor Daniel Kansaon.

                          Trabalho Prático Final
  XuBank é uma nova fintech que está procurando se firmar no mercado. O primeiro passo
para isto é ter um sistema de informação confiável para controlar as contas de seus clientes e
prover, de forma ágil e simples, informações para clientes e diretoria. A equipe de produto
levantou os requisitos abaixo e seu time de desenvolvimento precisa implementar um sistema
que os atenda:
  - Os clientes são cadastrados com nome, CPF e senha. Um cliente pode ter várias contas
em seu nome/CPF
  - Existem quatro tipos de conta: conta corrente, poupança, renda fixa e investimento. Cada
tipo tem regras particulares de taxas e possibilidades de rendimento, de acordo com a
tabela presente no anexo
  - As contas têm operações de saque e depósito. As contas correntes possuem um limite de
crédito: o cliente pode sacar este valor além do saldo real. Por exemplo, um cliente com
R$200 de saldo em conta e R$100 de limite pode sacar até R$300
  - Em um depósito de conta corrente, se o saldo atual estiver negativo, é cobrada uma taxa
de 3% sobre o valor negativo, mais R$10 de tarifa fixa
  - Um cliente tem acesso total às suas contas, podendo ver a situação e um extrato do
último mês de cada uma
  - A direção do XuBank precisa saber o valor atual em custódia para cada tipo de conta, o
saldo médio das contas e os clientes extremos: o com maior valor de saldo total e o com
o menor valor (que pode até ser negativo)

                          Tarefas e regras:
  - Criar um diagrama de classes para o problema proposto
  - Realizar a implementação das classes segundo o diagrama e cumprindo os requisitos
apontados. O sistema deve ser modelado usando os conceitos estudados em sala.
  - Realizar uma desta duas tarefas:
- Implementar uma aplicação Java Application (console) que possibilite o uso do
banco e de todas as operações descritas. Ao rodar a aplicação, deve ser exibido
um menu com as opções onde o usuário pode realizar as operações descritas.
  - Implementar testes unitários para as funções saque e depósito.
 
          Conta Regras e Impostos
- Corrente: Sem impostos.
Sem rendimento.
Saque especial de acordo com a regra.
Tarifa de depósito segundo a regra
- Poupança: Sem impostos.
Rendimento de 0,60% mensal.
- Renda Fixa: 15% de imposto sobre o rendimento no momento do
saque.
Rendimento varia entre 0,50 e 0,85% a cada mês.
Cobra R$20 do cliente, mensalmente.
- Investimento: 22,5% de imposto sobre o rendimento no momento
do saque.
Rendimento varia entre -0,60 e 1,50% a cada mês.
Cobra 1% do rendimento mensal do cliente,
mensalmente, caso o rendimento seja positivo.
