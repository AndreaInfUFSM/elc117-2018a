# Prática: Programação lógica em Prolog



## Controlando a execução 

Em Prolog, o operador **!** (leia-se: **cut**) é usado para impedir o retrocesso (backtracking) na avaliação de um predicado. Por exemplo, na avaliação de uma regra, se uma variável X recebe um valor 1 e depois é feito um **cut**, o processo de inferência Prolog vai considerar que o valor 1 é a única instância possível para X, mesmo que existam outras possibilidades na base de dados. 

## Primeira parte

1. Copie o código Prolog abaixo para um arquivo .pl. 

   ```prolog
   b(2).
   b(3).
   c(4).
   c(5).
   regra1(X, Y) :- b(X), c(Y).
   regra2(X, Y) :- b(X), !, c(Y).
   ```

2. Considerando o programa acima, qual será o resultado da seguinte consulta? 

   ```
   ?- regra1(X,Y).
   ```
    Execute a consulta e verifique se sua resposta está correta. Obs: use **;** para buscar todas as respostas possíveis. 

3. Ainda considerando o mesmo programa, qual será o resultado da seguinte consulta? 
   ```
   ?- regra2(X,Y).
   ```
    Execute a consulta para verificar se sua resposta está correta, lembrando de usar **;** para buscar todas as respostas possíveis. 

4. Ative o modo de rastreamento (**trace**) e re-execute as consultas acima. Observe a ocorrência de backtracking (Redo) nos 2 casos. 

## Segunda parte

1. Baixe o programa [fatoriais.pl](fatoriais.pl) e carregue-o no SWI-Prolog. 

2. Execute a consulta abaixo e use **;** para verificar se há outras respostas possíveis. 
   ```
   ?- fatv1(3,N).
   ```

3. A consulta acima deve ter gerado um erro depois que for digitado **;**. Você consegue identificar o motivo deste erro? 

4. Para melhor entender o erro acima, ative o modo **trace** e re-execute a consulta: 
   ```
   ?- trace.
   true.
   [trace]  ?- fatv1(3,N).
   ```
   Dica: quando você cansar de rastrear a execução passo-a-passo, digite a (abort) no lugar de Enter. 

5. Analise o código em [fatoriais.pl](fatoriais.pl), comparando os predicados ``fatv2`` e ``fatv3`` com o predicado ``fatv1``. 

6. Execute as consultas abaixo, digitando **;** após cada resposta. Compare os resultados com os da consulta anterior (``fatv1``). 
   ```
   ?- fatv2(3,N).
   ?- fatv3(3,N).
   ```

7. Ative o modo **trace** e re-execute as consultas acima, acompanhando suas execuções. 

8. Você consegue identificar alguma vantagem de ``fatv2`` sobre ``fatv3``? 

