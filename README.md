# petshop-mvc-java

# Sistema de Pet Shop - Java MVC

Projeto final da disciplina de **Desenvolvimento de Software**, desenvolvido em grupo utilizando **Java puro** e conceitos de **Programação Orientada a Objetos**.

## Objetivo do Projeto

O sistema tem como objetivo simular o gerenciamento básico de um Pet Shop, permitindo o cadastro de tutores, funcionários, pets, serviços, agendamentos, pagamentos, histórico de atendimentos e emissão de relatórios.

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
* Registro de logs;
* Organização em camadas;
* Clean Code.

## Funcionalidades Principais

O sistema contempla os seguintes módulos:

* Cadastro de tutores;
* Cadastro de funcionários;
* Cadastro de pets;
* Cadastro de serviços;
* Criação de agendamentos;
* Registro de pagamentos;
* Consulta de histórico dos pets;
* Geração de relatórios;
* Salvamento e carregamento dos dados em arquivo `.dat`;
* Registro automático de logs em arquivo `.txt`.

## Fluxo Principal do Sistema

O fluxo principal do sistema segue a lógica:

```text
Tutor -> Pet -> Serviço -> Agendamento -> Pagamento -> Histórico/Relatório
```

Ou seja, o sistema permite cadastrar um tutor, cadastrar pets, criar serviços disponíveis no Pet Shop, gerar agendamentos relacionando pets e serviços, registrar pagamentos e consultar históricos e relatórios.

## Estrutura do Projeto

A estrutura do projeto segue o padrão MVC, com separação entre modelos, controladores, visualizações e classes utilitárias:

```text
src/
├── Main.java
├── model/
├── controller/
├── view/
└── util/
```

## Organização das Camadas

### Main

O `Main` é o ponto de entrada do sistema.

Ele é responsável por:

* Iniciar o sistema;
* Carregar os dados salvos;
* Criar as Views principais;
* Entregar os Controllers necessários para cada View;
* Exibir o menu principal;
* Direcionar o usuário para o módulo escolhido;
* Solicitar o salvamento dos dados ao encerrar ou ao escolher a opção de salvar.

O `Main` não concentra mais diretamente a lógica de persistência, pois essa responsabilidade foi separada no `PersistenciaController`.

### Model

Contém as classes que representam os dados e entidades principais do sistema.

Exemplos:

* `EstadoSistema`
* `Pessoa`
* `Tutor`
* `Funcionario`
* `Animal`
* `Cachorro`
* `Gato`
* `Servico`
* `Agendamento`
* `Pagamento`
* `Historico`
* `Relatorio`
* `LogRegistro`

O `Model` define e representa os dados do sistema, como atributos, construtores, getters, setters e comportamentos específicos de cada entidade.

### Controller

Contém as classes responsáveis por controlar as operações do sistema, como cadastrar, listar, alterar, buscar, remover dados e organizar regras de execução.

Exemplos:

* `TutorController`
* `FuncionarioController`
* `PetController`
* `ServicoController`
* `AgendamentoController`
* `PagamentoController`
* `HistoricoController`
* `RelatorioController`
* `PersistenciaController`

O `Controller` é responsável por manipular os dados e executar as ações solicitadas pelas Views.

### View

Contém as classes responsáveis pela interação com o usuário via terminal.

Exemplos:

* `TutorView`
* `FuncionarioView`
* `PetView`
* `ServicoView`
* `AgendamentoView`
* `PagamentoView`
* `HistoricoView`
* `RelatorioView`

A `View` mostra menus, recebe informações digitadas pelo usuário e chama os Controllers responsáveis por executar as ações.

### Util

Contém classes auxiliares do sistema, usadas como ferramentas de apoio.

Exemplos:

* `ArquivoUtil`
* `LogUtil`

Essas classes não representam entidades principais do sistema, mas ajudam em tarefas específicas, como salvar arquivos e registrar logs.

## Persistência de Dados

O sistema possui persistência de dados para evitar que as informações sejam perdidas ao encerrar o programa.

A persistência funciona a partir das seguintes classes:

### EstadoSistema

A classe `EstadoSistema` centraliza os Controllers principais do sistema.

Ela guarda os controladores responsáveis pelos dados de tutores, funcionários, pets, serviços, agendamentos, pagamentos e históricos.

Dessa forma, o sistema consegue salvar e carregar o estado geral da aplicação em um único objeto.

### PersistenciaController

A classe `PersistenciaController` é responsável por organizar o processo de salvar e carregar os dados do sistema.

Ela utiliza o `ArquivoUtil` para gravar e recuperar o objeto `EstadoSistema`.

Suas principais responsabilidades são:

* Carregar os dados salvos ao iniciar o sistema;
* Criar um novo `EstadoSistema` caso não exista arquivo salvo;
* Salvar o estado atual do sistema;
* Criar a pasta de dados quando necessário;
* Registrar logs relacionados ao carregamento e salvamento.

### ArquivoUtil

A classe `ArquivoUtil` é uma classe utilitária responsável pela leitura e escrita de objetos em arquivo.

Ela utiliza serialização para salvar e carregar objetos Java em um arquivo `.dat`.

O arquivo de dados utilizado pelo sistema é:

```text
dados/sistema_petshop.dat
```

Esse arquivo é usado internamente pelo sistema para manter os dados salvos entre uma execução e outra.

## Log do Sistema

O sistema possui registro de logs em arquivo `.txt`.

A classe responsável por esse registro é o `LogUtil`.

O log registra acontecimentos importantes, como:

* Dados carregados com sucesso;
* Sistema iniciado sem dados salvos;
* Dados salvos com sucesso;
* Erros ao salvar dados.

O arquivo de log é criado em:

```text
logs/log.txt
```

Diferente do arquivo `.dat`, que armazena os dados internos do sistema, o arquivo `.txt` registra acontecimentos de forma legível.

## Diferença entre `.dat` e `.txt`

```text
.dat -> arquivo interno de persistência dos dados do sistema
.txt -> arquivo de log com registros de ações e eventos
```

O `.dat` guarda os objetos do sistema para que os cadastros não sejam perdidos.

O `.txt` funciona como um registro de acontecimentos importantes durante a execução.

## Divisão Geral do Grupo

Cada integrante ficou responsável por módulos específicos do sistema.

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

Essas classes representam estruturas genéricas que servem como base para classes mais específicas.

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

Em `Cachorro`, pode retornar:

```text
Au Au!
```

Em `Gato`, pode retornar:

```text
Miau!
```

Assim, o sistema pode tratar os objetos como `Animal`, mas cada classe filha responde de forma diferente.

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

A interface define um comportamento obrigatório para classes que a implementam.

### Encapsulamento

O sistema utiliza atributos privados e métodos públicos de acesso, como getters e setters.

Exemplo:

```java
private String nome;

public String getNome() {
    return nome;
}
```

Isso protege os dados e controla a forma como eles são acessados e alterados.

### Coleções

O sistema utiliza coleções para armazenar dados em memória.

Exemplos:

```java
ArrayList
List
```

Os Controllers utilizam listas para armazenar os objetos cadastrados durante a execução do sistema.

### Tratamento de Exceções

O projeto utiliza tratamento de exceções para evitar que o sistema seja encerrado inesperadamente.

Exemplos:

* Entrada inválida do usuário;
* Erros ao salvar dados;
* Erros ao carregar arquivos;
* Arquivo de dados inexistente.

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

## Salvamento dos Dados

Para salvar os dados durante a execução, utilize a opção:

```text
9 - Salvar Dados
```

Para salvar e encerrar o sistema, utilize:

```text
0 - Salvar e Sair
```

Ao salvar, o sistema grava os dados no arquivo `.dat` e também registra o acontecimento no arquivo de log `.txt`.

## Status do Projeto

Projeto em desenvolvimento para entrega final da disciplina de Desenvolvimento de Software.

## Uso de Inteligência Artificial

Durante o desenvolvimento, ferramentas de Inteligência Artificial foram utilizadas como apoio para organização da arquitetura, revisão de código, planejamento dos módulos, explicação de conceitos e melhoria da documentação.

A implementação, entendimento, testes e integração do sistema foram realizados pelo grupo, respeitando os requisitos definidos para o trabalho.
