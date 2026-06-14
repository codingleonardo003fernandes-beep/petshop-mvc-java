# petshop-mvc-java

# Sistema de Pet Shop - Java MVC

Projeto final da disciplina de **Desenvolvimento de Software**, desenvolvido em grupo utilizando **Java puro** e conceitos de **Programação Orientada a Objetos**.

## Objetivo do Projeto

O sistema tem como objetivo simular o gerenciamento básico de um Pet Shop, permitindo o cadastro de tutores, pets, serviços, agendamentos, pagamentos, histórico de atendimentos e relatórios.

O projeto foi desenvolvido com foco em aplicar os principais conceitos estudados durante o semestre, como:

* Programação Orientada a Objetos;
* Arquitetura MVC;
* Classes abstratas;
* Herança;
* Polimorfismo;
* Interfaces;
* Encapsulamento;
* Coleções;
* Tratamento de exceções;
* Persistência de dados;
* Log de ações;
* Clean Code.

## Funcionalidades Principais

O sistema contempla os seguintes módulos:

* Cadastro de tutores;
* Cadastro de funcionários;
* Cadastro de pets;
* Cadastro de serviços;
* Criação de agendamentos;
* Registro de pagamentos;
* Histórico de ações e atendimentos;
* Geração de relatórios;
* Persistência dos dados em arquivo;
* Registro de logs em arquivo `.txt`.

## Fluxo Principal do Sistema

O fluxo principal do sistema segue a lógica:

```text
Tutor -> Pet -> Serviço -> Agendamento -> Pagamento -> Histórico/Relatório
```

Ou seja, o sistema permite cadastrar um tutor, vincular pets a esse tutor, cadastrar serviços disponíveis no Pet Shop e criar agendamentos relacionando pets e serviços.

## Estrutura do Projeto

A estrutura do projeto segue o padrão MVC:

```text
src/
├── Main.java
├── model/
├── controller/
├── view/
└── util/
```

### Model

Contém as classes de entidade e regras principais do sistema.

Exemplos:

* Tutor
* Funcionario
* Animal
* Cachorro
* Gato
* Servico
* Agendamento
* Pagamento
* Historico
* Relatorio
* LogRegistro

### Controller

Contém as classes responsáveis por controlar as operações do sistema, como cadastrar, listar, alterar, buscar e remover dados.

Exemplos:

* TutorController
* FuncionarioController
* PetController
* ServicoController
* AgendamentoController
* PagamentoController
* HistoricoController
* RelatorioController
* PersistenciaController
* LogController

### View

Contém as classes responsáveis pela interação com o usuário via terminal.

Exemplos:

* TutorView
* FuncionarioView
* PetView
* ServicoView
* AgendamentoView
* PagamentoView
* HistoricoView
* RelatorioView
* PersistenciaView
* LogView

### Util

Contém classes auxiliares do sistema.

Exemplos:

* ArquivoUtil
* LogUtil

## Divisão Geral do Grupo

Cada integrante ficou responsável por dois módulos MVC do sistema.

| Integrante | Responsabilidade                               |
| ---------- | ---------------------------------------------- |
| Daniel     | Tutor e Funcionário                            |
| Eliseu     | Pet e Histórico                                |
| Felipe     | Serviço e Pagamento                            |
| Guilherme  | Agendamento e Relatório                        |
| Leonardo   | Persistência, Log/Auditoria, Main e Integração |

## Conceitos de POO Aplicados

### Classe Abstrata

O projeto utiliza classes abstratas como base para outras classes do sistema.

Exemplos:

* `Pessoa`
* `Animal`

### Herança

O sistema utiliza herança para reaproveitar atributos e métodos comuns.

Exemplos:

```java
Tutor extends Pessoa
Funcionario extends Pessoa
Cachorro extends Animal
Gato extends Animal
```

### Polimorfismo de Sobrescrita

As classes filhas podem sobrescrever métodos da classe mãe.

Exemplo:

```java
emitirSom()
```

Esse método pode ter comportamentos diferentes em `Cachorro` e `Gato`.

### Polimorfismo de Sobrecarga

O projeto utiliza métodos com o mesmo nome, mas com parâmetros diferentes.

Exemplo:

```java
calcularPreco()
calcularPreco(double taxaUrgencia)
calcularPreco(double taxaUrgencia, double desconto)
```

### Interface

O projeto utiliza interface para definir contratos que devem ser seguidos por determinadas classes.

Exemplo:

```java
BanhoTosa
```

### Coleções

O sistema utiliza coleções para armazenar dados em memória.

Exemplos:

```java
ArrayList
List
```

## Persistência de Dados

O sistema possui persistência para salvar e carregar dados em arquivo, evitando que as informações sejam perdidas ao encerrar o programa.

## Log do Sistema

O sistema possui registro de logs em arquivo `.txt`, permitindo acompanhar ações importantes e possíveis erros durante a execução.

## Como Executar o Projeto

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto em uma IDE Java, como IntelliJ IDEA ou VS Code.

3. Acesse o arquivo:

```text
src/Main.java
```

4. Execute o método `main`.

## Status do Projeto

Projeto em desenvolvimento para entrega final da disciplina de Desenvolvimento de Software.

## Uso de Inteligência Artificial

Durante o desenvolvimento, ferramentas de Inteligência Artificial foram utilizadas como apoio para organização da arquitetura, revisão de código, planejamento dos módulos e melhoria da documentação.

A implementação, entendimento e integração do sistema foram realizados pelo grupo, respeitando os requisitos definidos para o trabalho.
