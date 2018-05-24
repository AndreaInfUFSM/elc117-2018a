# Trabalho 5: Editor de grafos com JavaFX

## Deadline

Segunda, 4 de junho, 23:59.


## Objetivo

O objetivo principal deste trabalho é exercitar a **programação orientada a objetos**, aplicando e aprofundando o conhecimento sobre os conceitos associados a este paradigma, em um programa com interface gráfica. 

O programa a ser criado é um **editor de grafos** com as funcionalidades descritas abaixo. O programa deve empregar a programação orientada a objetos para favorecer o reuso de código, especialmente nas classes usadas para representar objetos do domínio (grafos), visando seu aproveitamento no [trabalho seguinte](../trabalhos/t6).


## Funcionalidades


A interface do editor de grafos deve conter:

1. Barra de ferramentas: composta por widgets de controle [UI Controls](https://docs.oracle.com/javafx/2/ui_controls/jfxpub-ui_controls.htm) para habilitar o desenho de vértices ou arestas do grafo. A interface deve permitir selecionar pelo menos 2 atributos para os vértices e as arestas (por exemplo, forma, cor ou borda, conforme aplicável).

2. Área de desenho: deve permitir o desenho dos vértices e das arestas, com os atributos selecionados, usando o mouse.

3. Barra de menu: deve oferecer menus com opções para criar novo grafo, salvar grafo em SVG, sair do programa e informar características do grafo corrente. Dentre as características do grafo, devem ser informados: (a) número de vértices, (b) número de arestas e (c) número de arestas sobrepostas.



## Entrega

 1. Seu trabalho será entregue no seu repositório remoto da disciplina no GitHub.
 2. Você deverá ter um repositório local da disciplina, que será um clone do repositório remoto. No seu repositório local, crie uma pasta chamada `t5` (atenção: letra minúscula).
 3. Na pasta do trabalho, adicione o código-fonte e quaisquer outros arquivos necessários para compilar o programa. Se estiver usando um IDE, inclua todos os arquivos do projeto. Não armazene arquivos .class ou bibliotecas de terceiros.
 4. Documente os passos que um desenvolvedor deve seguir para fazer o `build` do programa/projeto (criar o executável a partir dos fontes).
