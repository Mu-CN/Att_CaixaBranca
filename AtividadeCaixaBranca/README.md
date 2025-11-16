#  Sistema de Login com JDBC — Análise e Testes

Este projeto consiste em um sistema simples de autenticação utilizando Java e JDBC para verificar um usuário cadastrado em banco de dados MySQL.  

O objetivo desta atividade é aplicar técnicas de análise, calcular complexidade ciclomática, caminhos básicos e documentar os resultados conforme boas práticas de QA.

---

##  Estrutura do Repositório

/src
└─ User.java → Código analisado

PlanilhaAttCaixaBranca.xlsx → Planilha de caixa branca estática utilizada
README.md → Documentação do projeto

---

##  Código Avaliado

O código analisado nesta atividade foi o arquivo:

User.java

Ele contém os métodos responsáveis pela conexão com o banco de dados e pela verificação de login e senha.

---

##  Resultados da Análise Estática

A planilha de validação utilizada no processo de revisão está armazenada neste repositório como:

PlanilhaAttCaixaBranca.xlsx

Ela contém as respostas referentes aos critérios avaliados (documentação, tratamento de erros, inicialização de variáveis, arquitetura e outros requisitos).

---

##  Grafo de Fluxo do Código


      (1) Início
         |
      (2) Criar SQL e conectar
         |
      (3) Executar consulta
         |
      (4) Existe resultado?
      |            \
   (Sim)            (Não)
      |               \
     (5) Definir usuário válido
      |               |
      \______________ |
                |
              (6) Retorno do método

---

##  Complexidade Ciclomática

#### Fórmula utilizada:

M = E – N + 2

Onde:  
- **N (Nós)** = 6  
- **E (Arestas)** = 7  

#### Cálculo:

M = 7 - 6 + 2 = 3


 **Complexidade Ciclomática Final: _3_**

---

##  Caminhos Básicos Identificados

Como a complexidade ciclomática é `3`, existem três caminhos independentes:

| Caminho | Fluxo |
|---------|-------|
| **C1** | 1 → 2 → 3 → 4 → 6 |
| **C2** | 1 → 2 → 3 → 4 → 5 → 6 |
| **C3** | 1 → 2 → 3 → 4 (erro/exceção) → 6 |

---

##  Resultados dos Testes Lógicos

| Cenário Testado | Resultado Esperado | Resultado Obtido | Status |
|----------------|-------------------|------------------|--------|
| Usuário válido | `true` | `true` | ✔ |
| Usuário inexistente | `false` | `false` | ✔ |
| Senha incorreta | `false` | `false` | ✔ |
| Banco indisponível | Mensagem de erro | Apenas retorno `false` | ⚠ |
| SQL Injection | Rejeitar entrada | Login aceito | ⚠ Vulnerável |

> ⚠ Apesar de funcional, o código apresenta falhas de segurança e ausência de boas práticas.

---

##  Melhorias Recomendadas

- Usar **PreparedStatement** para evitar SQL Injection  
- Fechar `Connection`, `ResultSet` e `Statement` (try-with-resources)
- Validar entradas nulas ou vazias
- Melhorar nomes de variáveis e padrão de código
- Implementar logs apropriados no tratamento de exceções

---

##  Autor

- **Nome:** _Murilo Castro Nóbrega de Almeida_
- **Data:** _15/11/2025_

---

##  Link do Repositório Público

https://github.com/Mu-CN/Att_CaixaBranca


