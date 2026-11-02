#  Sistema de Restaurante

Aplicação de console em **Java** desenvolvida para simular o gerenciamento de pedidos de uma hamburgueria, focada em boas práticas de programação orientada a objetos (POO), **princípios SOLID**, **padrões de projeto (GoF)** e **testes unitários com JUnit 5**.

---

##  Sumário
- [Sobre o Projeto](#-sobre-o-projeto)
- [Demonstração em Vídeo](#-demonstração-em-vídeo)
- [Funcionalidades por Nível](#-funcionalidades-por-n%C3%ADvel)
- [Padrões de Projeto Aplicados](#-padr%C3%B5es-de-projeto-aplicados)
- [Princípios SOLID](#-princ%C3%ADpios-solid)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Estratégia de Versionamento (Git Branches)](#-estrat%C3%A9gia-de-versionamento-git-branches)
- [Testes Automatizados](#-testes-automatizados)
- [Como Executar o Projeto](#-como-executar-o-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Autora](#-autora)

---

## --- Sobre o Projeto

O **Sistema de Restaurante** permite realizar o ciclo completo de pedidos de clientes:
1. Registro de novos pedidos com identificador sequencial único.
2. Escolha de lanches com valores e descrições pré-definidas.
3. Personalização do lanche (retirada de ingredientes sem alteração de preço).
4. Adição dinâmica de acompanhamentos extras (como Cheddar e Bacon Extra) acumulando preço e descrição.
5. Listagem detalhada de todos os pedidos realizados no dia.
6. Fechamento de caixa diário com cálculo do faturamento total acumulado.

---

## 🎥 Demonstração em Vídeo

Assista a uma breve explicação em vídeo sobre a arquitetura do sistema, organização de pacotes, padrões de projeto aplicados, demonstração do fluxo funcionando de ponta a ponta e execução dos testes unitários:

[![Vídeo de Apresentação](https://img.shields.io/badge/YouTube-Assistir%20V%C3%ADdeo%20Explicativo-red?style=for-the-badge&logo=youtube)](https://youtu.be/zUwdGdE3xJA)

👉 **Link direto:** [https://youtu.be/zUwdGdE3xJA](https://youtu.be/zUwdGdE3xJA)

---

## --- Funcionalidades por Nível

O projeto foi construído e evoluído incrementalmente em três marcos:

* **Nível 1 (Base)**:
  * Criação do fluxo de console CLI (menu interativo com `Scanner`).
  * Modelagem de `Lanche`, `Pedidos` e armazenamento em memória via `GerenciadorPedidos` (`HashMap`).
  * Cálculo de totais e fechamento do dia.
* **Nível 2 (Padrões de Projeto & Testes)**:
  * Introdução da interface `ItemCardapio`.
  * Implementação do padrão **Decorator** para adicionais (`ComCheddar`, `ComBaconExtra`).
  * Implementação do padrão **Simple Factory** (`LancheFactory`) para instanciar opções do cardápio.
  * Implementação do padrão **Facade** (`RestauranteFacade`) para desacoplar a interface da lógica de negócio.
  * Criação da suíte de testes unitários com JUnit 5.
* **Nível 3 (Personalização)**:
  * Customização de ingredientes na classe `Lanche` (queijo, alface, tomate, cebola).
  * Retirada de ingredientes com manutenção do preço base e reflexo automático no texto da descrição.
  * Integração completa da personalização com os decoradores adicionais.

---

## --- Padrões de Projeto Aplicados

### 1. **Decorator (GoF)**
* **Problema:** Evitar uma explosão de subclasses combinatórias (ex.: `XBaconComCheddar`, `XBaconComCheddarEComBaconExtra`).
* **Solução:** `ComCheddar` e `ComBaconExtra` implementam a interface `ItemCardapio` e recebem outro `ItemCardapio` no construtor. Em tempo de execução, envolvem o lanche base somando os preços e concatenando as descrições de forma dinâmica.

### 2. **Facade (GoF)**
* **Problema:** O ponto de entrada (`Main`) e a interface (`MenuConsole`) ficavam sobrecarregados conhecendo detalhes internos de múltiplos componentes.
* **Solução:** A classe `RestauranteFacade` atua como um ponto único de orquestração. Ela centraliza a criação de lanches, aplicação de adicionais, remoção de ingredientes e operações de fechamento.

### 3. **Simple Factory**
* **Problema:** Instanciação repetida de lanches com nomes e preços hardcoded espalhados pelo código.
* **Solução:** `LancheFactory` centraliza a criação padronizada de opções do menu (`xBurger()`, `xSalada()`, `xBacon()`).

---

## --- Princípios SOLID

* **SRP (Single Responsibility Principle - Responsabilidade Única):**
  * `MenuConsole` responde apenas pela interface de entrada e saída com o usuário.
  * `RestauranteFacade` responde exclusivamente pela orquestração das ações do restaurante.
  * `GerenciadorPedidos` cuida unicamente do armazenamento e totalização dos pedidos.
* **OCP (Open/Closed Principle - Aberto/Fechado):**
  * O cardápio está **aberto para extensão** (basta criar uma nova classe que implemente `ItemCardapio`, como `ComMaioneseCaseira`) e **fechado para modificação** (a classe `Lanche` original não precisa ser alterada).
* **DIP (Dependency Inversion Principle - Inversão de Dependência):**
  * As classes de pedidos e decoradores dependem da abstração `ItemCardapio`, não de classes concretas.

---



## --- Estratégia de Versionamento (Git Branches)

Para garantir segurança, estabilidade e rastreabilidade pedagógica do desenvolvimento, o repositório foi organizado em branches separadas por nível:

* `main`: Contém a versão estável do **Nível 1** (estrutura base funcional).
* `nivel2`: Implementação e refatoração para os **Design Patterns** (Decorator, Facade, Factory) e testes com JUnit.
* `nivel3`: Implementação da **Personalização de Ingredientes** (Requisito 3.1) e integração com a interface.

---

## 🧪 Testes Automatizados

Os testes unitários foram desenvolvidos utilizando o **JUnit 5** no arquivo `ItemCardapioTest.java`:

| Teste | Objetivo |
| :--- | :--- |
| `xBaconComCheddarCusta26()` | Valida se o decorator `ComCheddar` soma corretamente R$ 4,00 ao preço do lanche base. |
| `precoNegativoLancaExcecao()` | Garante que instanciar um `Lanche` com preço negativo lança `IllegalArgumentException`. |
| `lancheSemCebolaMantemPrecoEAtualizaDescricao()` | Garante que remover um ingrediente não altera o preço base e reflete `"sem cebola"` na descrição. |
| `lanchePersonalizadoComAdicional()` | Valida a composição completa: personalização de ingredientes combinada com decorator adicional. |

---

## 💻 Como Executar o Projeto

### Pré-requisitos
* **Java JDK** 21 ou superior instalado.
* **Apache Maven** ou uma IDE com suporte a Maven (como IntelliJ IDEA ou Eclipse).

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/MariaLimaBeatriz/sistema-restaurante.git
   ```

2. **Acesse o diretório do projeto:**
   ```bash
   cd sistema-restaurante
   ```

3. **Mude para a branch mais recente (Nível 3):**
   ```bash
   git checkout nivel3
   ```

4. **Compilar e executar:**
   * **Pela IDE:** Abra a pasta no IntelliJ IDEA, aguarde a indexação das dependências do Maven e execute a classe `app.Main`.
   * **Via Linha de Comando (Maven):**
     ```bash
     mvn compile
     mvn exec:java -Dexec.mainClass="app.Main"
     ```

5. **Rodar os testes unitários:**
   ```bash
   mvn test
   ```

---

## --- Tecnologias Utilizadas

* **Linguagem:** Java
* **Gerenciador de Dependências:** Maven
* **Testes:** JUnit 5 (Jupiter 5.10.2)
* **Controle de Versão:** Git / GitHub
* **IDE:** IntelliJ IDEA

---

## 👩‍💻 Autora

Desenvolvido por **Maria Beatriz** ([@MariaLimaBeatriz](https://github.com/MariaLimaBeatriz)).
