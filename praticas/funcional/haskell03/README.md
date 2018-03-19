# Prática: Programação funcional em Haskell

Para fazer estes exercícios, consulte os slides sobre [geração de listas em Haskell](https://docs.google.com/presentation/d/1JVFCTYwsn0iDCTbmG4SkkpE81A-xsDqH7kn4wmiiQoA/export/pdf).


1. Escreva uma função `addSuffix :: String -> [String] -> [String]` usando *list comprehension*, para adicionar um dado sufixo às strings contidas numa lista. Exemplo: 

   ```
   > addSuffix "@inf.ufsm.br" ["fulano","beltrano"]
   ["fulano@inf.ufsm.br","beltrano@inf.ufsm.br]
   ```

2. Escreva uma função `countShorts :: [String] -> Int`, que receba uma lista de palavras e retorne a quantidade de palavras dessa lista que possuem menos de 5 caracteres. Use *list comprehension*.


3. Qual será o resultado de cada expressão abaixo?

   - a) `[ (x,y) | x <- [1..5], even x, y <- [(x + 1)..6], odd y ]`
   - b) `[ a ++ b | a <- ["lazy","big"], b <- ["frog", "dog"]]`
   - c) `concat [ [a,'-'] | a <- "paralelepipedo", not (elem a "aeiou")]`

4. Nesta questão você também deverá usar *list comprehension*. Suponha   que   um   retângulo   seja   representado   por   uma   [tupla](http://learnyouahaskell.com/starting-out#tuples) `(Float,Float,Float,Float)`, contendo respectivamente as coordenadas x e y do ponto no seu canto superior esquerdo, seguidas das suas medidas de largura e altura. Sabendo que o eixo x cresce de cima para baixo e o eixo y   da   esquerda   para   direita,   crie   uma   função `genRects :: Int -> (Int,Int) -> [(Float,Float,Float,Float)]` que receba um número N   e   um   ponto   (x,y)   e   gere   uma   sequência   de   N   retângulos   não sobrepostos.  Os retângulos devem ser alinhados pelos seus topos, a partir do ponto dado, com largura e altura constantes. Por exemplo, usando largura e altura iguais a 5.5: 

   ```
   > genRects 3 (0,0) 
   [(0.0,0.0,5.5,5.5),(5.5,0.0,5.5,5.5),(11.0,0.0,5.5,5.5)]
   ```

   Obs.: Use conversão explícita de tipos quando misturar Int e Float.
   
