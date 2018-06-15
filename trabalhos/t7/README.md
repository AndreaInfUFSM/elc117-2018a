# Trabalho 7: Dashboard para monitoramento de frota de ônibus urbanos

## Deadline

Domingo, 1º de julho, 23:59.


## Objetivo

O objetivo principal deste trabalho é exercitar a **programação orientada a objetos**, aplicando e aprofundando o conhecimento sobre os conceitos associados a este paradigma, em um programa com interface gráfica. 

O programa a ser criado é um [dashboard](https://www.google.com/search?tbm=isch&q=dashboard&oq=dashboard) para visualização de dados sobre a [frota de ônibus da cidade do Rio de Janeiro](https://pcrj.maps.arcgis.com/home/item.html?id=c47f8bb36e2e4760a761111ac58f5ec0). Estes dados foram escolhidos por serem atualizados em tempo real e estarem disponíveis via uma API web, que dispobiliza os dados em um formato de fácil manipulação (JSON).

## Dados 

Conforme a [documentação](http://dadosabertos.rio.rj.gov.br/apitransporte/apresentacao/pdf/documentacao_gps_brt.pdf), os dados retornados informam, para cada veículo:

| Campo | Descrição |
| DataHora | Data e hora da coleta do dado |
| Ordem | Identificação alfanumérica do veículo |
| Linha | Linha de transporte |
| Latitude | Latitude do ônibus na coleta (GPS) |
| Longitude | Longitude do ônibus na coleta (GPS) |
| Velocidade | Velocidade do ônibus na hora do coleta do dado |

A tabela a seguir ilustra exemplos de URLs que podem ser usadas para obter dados do servidor:
| http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterTodasPosicoes |
| http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterPosicoesDaLinha/100 |
| http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterPosicoesDoOnibus/B10033 |



## Requisitos

O programa deve, no mínimo:

1. Permitir que o usuário obtenha os dados diretamente do servidor. Isso deve ser implementado usando a API web, tomando como exemplo [este programa](../../praticas/oo/java6/src/tableview/TableViewExampleJoke.java).

2. Mostrar o número de veículos obtido na última leitura do servidor.

3. Mostrar os dados numa TableView.

4. Mostrar as seguintes datas-horas: (a) última leitura de dados do servidor, (b) data-hora mais recente lida do servidor e (c) data-hora menos recente lida do servidor. 

5. Mostrar um [gráfico de pizza](https://docs.oracle.com/javafx/2/charts/pie-chart.htm) (ou torta, para quem prefere doces :-)) identificando o percentual de veículos parados (velocidade 0) e em movimento (velocidade >0).

6. Mostrar um [gráfico de barras](https://docs.oracle.com/javafx/2/charts/bar-chart.htm#CIHJFHDE) com o número de veículos em movimento por linha.

7. Para fins de teste offline, permitir também que os dados sejam lidos de um arquivo.

Todas as informações devem ser agrupadas em um painel e formatadas para facilitar a visualização, como nos vários exemplos de [dashboards](https://www.google.com/search?tbm=isch&q=dashboard&oq=dashboard).

A organização do seu código deve inspirar-se no modelo MVC (Model-View-Controller). As classes e objetos que se referem aos dados (Model) não devem saber como serão visualizadas (isto é, não devem ter referências ou usar classes específicas da View em JavaFX). O Model deve poder ser reusado se mudar a View (por exemplo, se no lugar do dashboard quisermos ter um resumo textual dos dados).

## Extras

Você pode incrementar este trabalho e obter pontuação extra, proporcional à complexidade de implementação. Alguns exemplos:

1. Permitir que o usuário filtre os dados mostrados na tabela, por exemplo para mostrar somente ônibus de uma linha.

2. Mostrar a localização de um ônibus selecionado no mapa da cidade. Uma forma simples de se fazer isso é inserindo uma WebView na GUI para mostrar um mapa estático gerado pela [Maps Static API da Google](https://developers.google.com/maps/documentation/maps-static/intro).

3. Mostrar visualizações a partir de séries de dados para um mesmo ônibus, ou seja, visualizações que necessitem de mais de uma leitura de dados. Por exemplo: dados da velocidade ou posição do ônibus ao longo do tempo.

4. Você pode procurar outros serviços web que forneçam dados semelhantes e criar outro programa para visualização e exploração de dados. Por exemplo, o portal [DataPoa](http://datapoa.com.br) reúne dados da cidade de Porto Alegre, incluindo dados sobre [modais de transporte público](http://datapoa.com.br/dataset/poatransporte) (sem dados atualizados em tempo real).


## Entrega

 1. Seu trabalho será entregue no seu repositório remoto da disciplina no GitHub. 
 2. Você deverá ter um repositório local da disciplina, que será um clone do repositório remoto. No seu repositório local, crie uma pasta chamada `t7` (atenção: letra minúscula).
 3. Na pasta do trabalho, adicione o código-fonte e quaisquer outros arquivos necessários para compilar o programa. Se estiver usando um IDE, inclua todos os arquivos do projeto. Não armazene arquivos .class ou bibliotecas de terceiros.
 4. Documente os passos que um desenvolvedor deve seguir para fazer o `build` do programa/projeto (criar o executável a partir dos fontes).
 5. Se implementar extras, você pode mantê-los na mesma pasta `t7`, mas deve sinalizar a entrega no formulário de entrega de extras.

