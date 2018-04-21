# Trabalho 4: Resolvendo problemas da OBI em Prolog

## Deadline

Segunda, 30 de abril, 23:59.

## Sobre a OBI

A **Olimpíada Brasileira de Informática** é uma competição voltada para alunos do ensino fundamental e médio, que ocorre anualmente em várias cidades no Brasil. Numa das modalidades da competição, denominada **"Iniciação"**, os alunos resolvem problemas de lógica e problemas de computação, sem o uso de computador. Todos os problemas das competições passadas estão disponíveis no [site oficial da OBI](http://olimpiada.ic.unicamp.br/passadas).
 
 
## Trabalho

Neste trabalho, você deverá criar programas em Prolog para resolver 2 problemas disponíveis no site da OBI:

1. O problema intitulado "CD Independente", proposto na [OBI2017 (Fase 1, Nível 2, Modalidade Iniciação)](https://olimpiada.ic.unicamp.br/passadas/OBI2017/fase1/iniciacao/).

2. Um problema à sua escolha, da modalidade **Iniciação**, de qualquer uma das OBIs passadas.


Para ambos os problemas, os programas devem implementar:


1. Os requisitos lógicos do problema, sob forma de fatos e regras.
2. Consultas que respondam a pelo menos uma das questões sobre o problema. Por exemplo, o problema "CD Independente" compreende 5 questões, numeradas de 11 a 15, portanto seu programa poderá responder qualquer uma dessas questões, à sua escolha. 

Observações:
- O enunciado do problema, da questão e as alternativas devem ser expressas em forma de comentários nos códigos.
- As consultas também devem ser expressas em forma de comentários. 
- Na resolução dos problemas, você pode utilizar predicados pré-definidos em Prolog. 

## Dicas

- Muitos problemas da OBI podem ser resolvidos em Prolog usando **listas** para representar as possíveis soluções. Isso é exemplificado no programa [obi-estacionamento.pl](obi-estacionamento.pl), que apresenta a solução do problema "Vagas de Estacionamento" (OBI2009-F2N1). Neste programa, usa-se uma regra para gerar todas as permutações com 5 carros em 5 vagas, e depois aplicam-se regras com restrições, que reduzem o número de soluções possíveis.

- No geral, a descrição inicial dos problemas poderia levar a diversas soluções, mas cada questão impõe condições adicionais, de forma que somente uma resposta (A, B, C, D ou E) pode ser verdadeira.

- Para responder a uma questão, você pode fazer 5 consultas, uma para cada opção (A, B, C, D e E). Cada consulta deverá retornar true para a opção correta e false para as demais opções (ou o contrário, dependendo do enunciado da questão).


## Entrega

 1. Seu trabalho será entregue no seu repositório remoto da disciplina no GitHub.
 2. Você deverá ter um repositório local da disciplina, que será um clone do repositório remoto. No seu repositório local, crie uma pasta chamada `t4` (atenção: letra minúscula).
 3. Resolva cada problema em um arquivo .pl separado: `t4a.pl` para o problema "CD Independente" e `t4b.pl` para o problema à sua escolha.
  
