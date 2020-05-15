# Análise OO #
O processo de construção do modelo de domínio é baseado nos casos de uso, em especial os substantivos utilizados, e na descrição do enunciado.
## Racional para identificação de classes de domínio ##
Para a identificação de classes de domínio usa-se a lista de categorias das aulas TP (sugeridas no livro). Como resultado temos a seguinte tabela de conceitos (ou classes, mas não de software) por categoria.

### _Lista de Categorias_ ###

**Transações (do negócio)**

* __Anúncio__
* __Processo de Seriação__
* __Candidatura__

---

**Linhas de transações**

* __Classificacao__

---

**Produtos ou serviços relacionados com transações**

*  Tarefa

---


**Registos (de transações)**

*

---  


**Papéis das pessoas**

* Administrativo
* Freelancer
* Colaborador (de Organização)
* Gestor (de Organização)
* Utilizador
* Utilizador Não Registado

---


**Lugares**

*  Endereço Postal
*  Plataforma

---

**Eventos**

* __Processo de Seriação__
* __Candidatura__

---


**Objectos físicos**

*

---


**Especificações e descrições**

*  Área de Atividade
*  Competência Técnica
*  Categoria (de Tarefa)
*  Tarefa
*  __Tipo Regimento__
*  __Grau Proficiência__
*  __Habilitação Académica__
*  __Reconhecimento de Competência Técnica__
---


**Catálogos**

*

---


**Conjuntos**

* Lista de Competência Técnica Requeridas

---


**Elementos de Conjuntos**

*  Caráter de Competência Técnica Requerida

---


**Organizações**

*  T4J (Plataforma)
*  Organização

---

**Outros sistemas (externos)**

*  (Componente Gestão Utilizadores)
*  Algoritmo (Externo) Gerador de Passwords

---


**Registos (financeiros), de trabalho, contractos, documentos legais**

*  __Tipo Regimento__

---


**Instrumentos financeiros**

*

---


**Documentos referidos/para executar as tarefas/**

*

---



## **Racional sobre identificação de associações entre classes** ##

Uma associação é uma relação entre instâncias de objetos que indica uma conexão relevante e que vale a pena recordar, ou é derivável da Lista de Associações Comuns:

+ A é fisicamente (ou logicamente) parte de B
+ A está fisicamente (ou logicamente) contido em B
+ A é uma descrição de B
+ A é conhecido/capturado/registado por B
+ A usa ou gere B
+ A está relacionado com uma transação de B
+ etc.



| Conceito (A) 		|  Associação   		|  Conceito (B) |
|----------	   		|:-------------:		|------:       |
| Administrativo  	| define    		 	| Área de Atividade  |
|   					| define            | Competência Técnica  |
|   					| trabalha para     | Plataforma  |
|						| atua como			| Utilizador |
| Plataforma			| tem registadas    | Organização  |
|						| tem/usa    			| Freelancer  |
|						| tem     			| Administrativo  |
| 						| possui     			| Competência Técnica  |
| 						| possui     			| Área de Atividade  |
| 						| possui     			| Categoria (de Tarefa)  |
|                       | recorre a         | Algoritmo (Externo) Gerador Passwords |
|                       | publicita         | Anuncio   |
|                       | suporta           | Tipo de Regimento|
| Competência Técnica| referente a       | Área de Atividade  |
|                    | aplica            | Grau Proficiência|
| Categoria (de Tarefa)| enquadra-se em | Área de Atividade  |
|						| tem 					| Lista de Competência Técnica Requeridas
| Lista de Competência Técnica Requeridas | tem | Caráter de Competência Técnica Requerida
| Caráter de Competência Técnica Requerida |  é referente a | Competência Técnica
|                                          | exige (como minimo)| Grau de Proficiência|
| Organização			| localizada em 	   | Endereço Postal  |
|						| tem gestor     	| Colaborador |
|						| tem		     		| Colaborador |
|						| possui		     	| Tarefa |
| Tarefa		    	| enquadra-se	em 		| Categoria |
| Tarefa		    	| especificada por 	| Colaborador |
|                       | dá origem         | Anuncio  |
| Anuncio               | publicita         | Tarefa |
|                       | rege-se           | Tipo de Regimento|
|                       | espoleta          | Processo de Seriação|
|                       | possui           | Candidatura|
|                       | publicado           | Colaborador|
| Processo de Seriação  | decorre em concordância com | Tipo de Regimento|
|                       | resulta            | Classificacao|
|                       | realizado por      | Colaborador|
| Classificacao         | referente a        | Candidatura|
| Candidatura           | realizado por       | Freelancer|
|                       | tem/recebe          | Classificacao|
| Gestor (de Organização)| é um (papel de)| Colaborador |
| Freelancer			| atua como			| Utilizador |
|                       | tem               | Habilitação Académica|
|                       | recebe(u)         | Reconhecimento de Competência Técnica |
|                       | tem               | Endereço Postal| 
|                       | efetua            | Candidatura| 
|Reconhecimento de Competência Técnica| relativo a| Competência Técnica|
|                                     | reconhece| Grau Proficiência|
| Colaborador			| atua como			| Utilizador |
|                       | participa em      | Processo de Seriacao|
| Algoritmo (Externo) Gerador Passwords | gera password de | Utilizador |


## Modelo de Domínio

De seguida apresentam-se várias alternativas, todas elas aceitáveis.

**Nota: os tipos de dados considerados básicos/primitivos (e.g. String, Double, Integer, Boolean) apresentados são meramente indicativos e de caráter opcional.** É ainda de salientar que estes tipos de dados não representam nem pretendem representar qualquer conceito de negócio. Caso contrário, deveriam estar representados como tal, i.e. através de um conceito (i.e. classe conceptual).

### Alternativa 1

![MD.svg](MD.svg)

### Alternativa 2

Apresenta uma variação na associações entre "Candidatura", "Processo Seriação" e "Classificação".

![MD_a2.svg](MD_a2.svg)
### Alternativa 3

Apresenta uma variação nas associações entre "Plataforma", "Anúncio" e  "Tarefa".

![MD_a3.svg](MD_a3.svg)


### Sumário

Um Modelo de Domínio representa uma visão parcial e aproximada do problema/negócio em mãos.

Pretendeu-se com isto demonstrar mais uma vez que não existe apenas um Modelo de Domínio correto.
Outros podem existir e serem aceitáveis.
Também não se pretendeu ser exaustivo nas possíveis alternativas e, portanto, podem existir ainda outras alternativas aceitáveis.

O importante é que este capture (sem falhas) os principais conceitos e associações existentes entre conceitos.

Salienta-se ainda que se introduziu a notação UML relativa a classes associativas.

Para a atividade de Design adotar-se-á a **alternativa 1**.
