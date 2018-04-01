# Prática: Programação lógica em Prolog


## Exercícios


1. Defina um predicado `ao_lado(X, Y, L)` para determinar se X está imediatamente ao lado de Y na lista L. Neste caso, X pode estar imediatamente à esquerda OU à direita de Y. Você pode usar o predicado `nextto`.

2. Defina um predicado `um_entre(X, Y, L)` para determinar se os elementos X e Y da lista L estão separados por exatamente um elemento. Você pode usar o predicado `nextto`. Abaixo estão exemplos de consultas com o predicado `um_entre`:
```prolog
?- um_entre(b,c,[a,b,c,d]).
false.
?- um_entre(b,d,[a,b,c,d]).
true .
?- um_entre(a,d,[a,b,c,d]).
false.
```

3. Veja [aqui](Einstein.md) a descrição de um problema de lógica e sua resolução em Prolog. Estude o código da solução (o código usa os predicados `nextto` e `ao_lado`).

4. Seguindo o exemplo anterior, resolva o problema de lógica descrito em http://rachacuca.com.br/logica/problemas/esquadrilha-de-avioes/. Nesse problema, há uma esquadrilha de 5 aviões em um show aéreo. Cada um deles solta fumaça de uma cor e possui uma anomalia diferente. Além disso, os aviões são comandados por cinco experientes pilotos que praticam um esporte cada um, além de preferirem uma bebida distinta. Sua tarefa é encontrar todas as informações a partir das seguintes dicas:  

    1. O avião do Cel. Milton solta fumaça vermelha.
    2. O rádio transmissor do Ten. Walter está com problemas.
    3. O piloto do avião que solta fumaça verde adora pescar.
    4. O Major Rui joga futebol nos finais de semana.
    5. O avião que solta fumaça verde está imediatamente à direita do avião que solta fumaça branca.
    6. O piloto que bebe leite está com o altímetro desregulado.
    7. O piloto do avião que solta fumaça preta bebe cerveja.
    8. O praticante de natação pilota o avião que solta fumaça vermelha.
    9. O Cap. Farfarelli está na ponta esquerda da formação.
    10. O piloto que bebe café voa ao lado do avião que está com pane no sistema hidráulico.
    11. O piloto que bebe cerveja voa ao lado do piloto que enfrenta problemas na bússola.
    12. O homem que pratica equitação gosta de beber chá.
    13. O Cap. Nascimento bebe somente água.
    14. O Cap. Farfarelli voa ao lado do avião que solta fumaça azul.
    15. Na formação, há um avião entre o que tem problema hidráulico e o com pane no altímetro.
    16. Um dos pilotos joga tênis.
    17. Há um avião com problema de temperatura.
    18. Dica final: use o predicado `um_entre` criado em outro exercício.

5. Abaixo encontram-se 2 definições para um predicado que permite verificar se uma lista contém somente números maiores que zero. Você acha que uma das implementações pode ser mais eficiente que a outra? Dica: busque informações sobre o predicado `time` do SWI-Prolog, que permite verificar a quantidade de inferências realizadas numa dada consulta.

   ```prolog
   positivos1([],[]).
   positivos1([H|T],L) :- H > 0, positivos1(T,Resto), L = [H|Resto].
   positivos1([H|T],L) :- H =< 0, positivos1(T,L).

   positivos2([],[]).
   positivos2([H|T],L) :- H > 0, L = [H|Resto], positivos2(T,Resto).
   positivos2([H|T],L) :- H =< 0, positivos2(T,L).
   ```

6. Abaixo encontram-se 2 definições para um predicado que permite encontrar o maior elemento em uma lista de inteiros. Você acha que uma das implementações pode ser mais eficiente que a outra?

   ```prolog
   largest1([X],X).
   largest1([X|Xs],X) :- largest1(Xs,Y), X>=Y.
   largest1([X|Xs],N) :- largest1(Xs,N), N>X.

   largest2([X|Xs], N) :- aux(Xs, X, N).
   aux([], N, N).
   aux([X|Xs], M, N) :-
      M1 is max(X, M),
      aux(Xs, M1, N).
```
