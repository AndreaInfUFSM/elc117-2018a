# Prática: Programação funcional em Haskell

Para fazer estes exercícios, consulte os slides sobre [recursividade em Haskell](https://docs.google.com/presentation/d/1SCBQmwFbHvp4Bme74kRvkV3fyCUeg9Bw_D4eI7fUUt4/export/pdf).


1. Usando recursão, escreva uma função `geraTabela :: Int -> [(Int,Int)]` que produza uma lista com `n` tuplas, cada tupla com números de `n` a `1` e seus respectivos quadrados. Exemplo: 

   ```
   > geraTabela 5
   [(5,25),(4,16),(3,9),(2,4),(1,1)]
   > geraTabela 0
   []
   ```

2. Defina uma função recursiva que verifique se um dado caracter está contido numa string, conforme os exemplos abaixo:

   ```
   > contido 'e' "andrea"
   True
   > contido 'x' "andrea"
   False
   > contido 'a' ""
   False
   ```

3. Defina uma função recursiva que receba uma lista de coordenadas de pontos 2D e desloque esses pontos em 2 unidades, conforme o exemplo abaixo:

   ```
   > translate [(0.1,0.2),(1.1,6.0),(2.0,3.1)]
   [(2.1,2.2),(2.1,8.0),(4.0,5.1)]
   ```

4. Defina uma função que receba um número n e retorne uma lista de `n` tuplas, cada tupla com números de `1` a `n` e seus respectivos quadrados. Dica: defina uma função auxiliar recursiva com 2 argumentos, sendo um deles que se mantém inalterado na chamada recursiva. Exemplo:

   ```
   > geraTabela' 5
   [(1,1),(2,4),(3,9),(4,16),(5,25)]

