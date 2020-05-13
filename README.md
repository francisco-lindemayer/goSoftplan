# Desafio técnico Softplan Unic

## Exercício 1
### Pontos negativos do código legado

**1. Variáveis que não são claras quanto a sua intenção**

*Exemplos:*

  *Integer c*

  *String s*

  *List lista (não explicita do que se refere a lista)*

**2. Métodos com nomenclatura pouco semântica não deixando claro o que realizad de fato**

**3. Variáveis declaradas e não utilizadas**


## Exercício 2

### Tecnologias utilizadas
- Java 11
- JUnit 5.7.0-M1
- VsCode
- Java Extesion Pack(VsCode)
- Apache Maven 3.6.0

### Decisões tomadas

<strong>Confesso que apanhei relativamente bastante para entregar este desafio.
Até o desafio ser lançado meu conhecimento nas tecnologias utilizadas era absolutamente zero.
Poderia ter implementado com Node, mas não resistí a tentação de um desafio de algo totalmente desconhecido.

Desde a instalação foi preciso pesquisa. :D
Então foi muuuuuita leitura e um pouco de videos, mas na maior parte a pesquisa se concentrou
em artigos e documentação.

Procurei dividir as responsabilidades em classes e estrutura o código da melhor forma possível e isolar as responsabilidades.


Inicialmente utilizei o "org.json" mas após algum leitura optei por utilizar o Gson.
Percebi que possibilitava criar um mapeamento para classes de forma bastante dinâmica.

A lógica principal se concentra na classe "CostCalculatorService" e "RecursiveFinder".
Não consegui fugir de uma implementação recursiva. Foi uma abordagem que atendeu.</strong>

### Resumo das classes principais
- **CostCalculatorService** - *Classe de entrada pra processamento dos dados e calculo das composições;*
- **RecursiveFinder** - *Classe que faz busca recursiva de composições. Utilizada para itens que são do tipo "COMPOSICAO";*
- **FileToJSON** - *Realiza leitura do arquivo de dados de entrada e retorna um JsonArray;*
- **CompositionMapper** - *Mapeia elemento Json para a classe modelo Composition;*
- **ItemMapper** - *Mapeia elemento Json para a classe modelo Item;*
- **DoubleCustomAdapter** - *Classe para custom adapter para tratamento de valores Double em deserealização utilizando Gson;*
- **CompositionPrinter** - *Impressão de dados para o terminal*


Gostaria de ter implementado mais testes, mas não consegui a tempo. Consegui implementar apenas testes para validar os cálculos na classe de entrada.
Deixei a estrutura pra demais testes criada, mas não houve tempo hábil pára implementação.











