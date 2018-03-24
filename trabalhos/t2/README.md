# Trabalho 2: Mais programação funcional em Haskell

## Deadline

Segunda, 2 de abril, 23:59.

## Entrega

1. Seu trabalho será entregue no seu **repositório** remoto da disciplina no GitHub. 

2. Você deverá ter um repositório local da disciplina, que será um clone do repositório remoto. No seu repositório local, crie uma pasta chamada `t2` (atenção: letra minúscula).

3. Coloque todos os arquivos solicitados dentro desta pasta. Você deverá fazer mais de um `commit` com alterações em cada arquivo do trabalho (com exceção da parte 1, caso tenha terminado em aula).

 
## Parte 1

Entregue os exercícios da [Aula Prática 4 de Haskell](../../praticas/funcional/haskell04), em um arquivo nomeado `t2parte1.hs`.


## Parte 2

Entregue esta parte em um arquivo nomeado `t2parte2.hs`.


1. Escreva uma função **recursiva** `isBin :: String -> Bool` para verificar se uma dada String representa um número binário, ou seja, contém apenas caracteres `'0'` ou `'1'`. As únicas funções pré-definidas autorizadas aqui são `head` e `tail`. Exemplos de uso de `isBin`:

   ```
   > isBin "101010"
   True
   > isBin "1212"
   False
   > isBin ""
   False
   ```

2. Reescreva a função acima de forma não-recursiva. Dê outro nome para ela, por exemplo `isBin'`. Aqui você pode usar quaisquer funções auxiliares pré-definidas em Haskell. 

3. Encontra-se abaixo a definição parcial da função `bin2dec :: [Int] -> Int`, que converte uma lista de 0's e 1's (representando um número binário), em seu equivalente em decimal. 
   ```
   bin2dec :: [Int] -> Int
   bin2dec [] = undefined
   bin2dec bits = auxBin2Dec bits ((length bits)-1)
   ```
   Observe que:
   1. Usou-se `undefined` para o caso em que a função não tem resultado definido.
   2. Usou-se uma função auxiliar (`auxBin2Dec`) que recebe, como segundo argumento, o expoente que deverá multiplicar o primeiro elemento da lista.
   
   Implemente a função `auxBin2Dec` de forma **recursiva**, para que `bin2dec` funcione corretamente, conforme os exemplos abaixo:
   ```
   > bin2dec [0]
   0
   > bin2dec [1]
   1
   > bin2dec [0,1]
   1
   > bin2dec [1,0,1]
   5
   ```
   
   
4. Reescreva a função do exercício anterior de forma **não-recursiva**, usando funções pré-definidas em Haskell. Dê outro nome para a função (por exemplo, `bin2dec'`).

5. Crie uma função **recursiva** `dec2bin :: Int -> [Int]` que receba um número inteiro positivo e retorne sua representação em binário, sob forma de uma lista de 0's e 1's. As funções auxiliares autorizadas aqui são `mod`, `div` e `reverse`.
   Exemplos de uso da função: 
   ```
   > dec2bin 0
   [0]
   > dec2bin 1
   [1]
   > dec2bin 11
   [1,0,1,1]
   > dec2bin 4
   [1,0,0]
   ```
   
6. Implemente uma dessas funções: `isHex :: String -> Bool` ou `hex2dec :: String -> Int` ou `dec2hex :: Int -> String`, que são semelhantes às dos exercícios anteriores, porém com números hexadecimais no lugar de números binários. Aqui está tudo liberado: você pode escolher qual das funções irá implementar, sem restrições sobre como deve fazer isso.



## Parte 3

A codificação [EAN-13](https://pt.wikipedia.org/wiki/EAN-13) é um padrão de código de barras usado em vários tipos de produtos. O número codificado em barras tem 13 dígitos (0-9), sendo o último um dígito verificador (exemplo: 5901234123457, dígito verificador 7). O cálculo do dígito verificador obedece a algumas regras simples
disponíveis em: https://www.gs1.org/services/how-calculate-check-digit-manually

Você deverá implementar uma função `isEanOk :: String -> Bool`, que verifique se uma dada string representa um número EAN-13 com dígito verificador válido.

Entregue esta parte em um arquivo nomeado `t2parte3.hs`.


## Parte 4


Nesta parte do trabalho, vamos trabalhar com uma forma simples de codificar mensagens secretas :-)
Para isso, você vai precisar baixar o programa [t2parte4.hs](t2parte4.hs) e completá-lo com as funções abaixo.


1. Usando `encodeChar` e `decodeChar`, defina uma função `shiftChar :: Char -> Int -> Char`. Essa função, ao receber um caracter de `'a'` a `'z'`, aplicará um deslocamento de `'n'` unidades sobre ele, produzindo outro caracter no intervalo `['a'..'z']`. Por exemplo:
   ```
   > shiftChar 'a' 3
   'd'
   > shiftChar 'a' 0
   'a'
   > shiftChar 'A' 3
   'A'
   > shiftChar ' ' 1
   ' '
   > shiftChar 'z' 3
   'c'
   > shiftChar 'z' 1
   'a'
   ```
   Note, pelos exemplos acima, que caracteres fora do intervalo não devem sofrer deslocamento. Além disso, o deslocamento deve ser aplicado de forma circular sobre o intervalo.

2. Usando `shiftChar`, defina uma função `encodeStr :: String -> Int -> String` que codifique uma string usando um dado deslocamento. Por exemplo: 
   ```
   > encodeStr "abracadabra" 3
   "deudfdgdeud"
   > encodeStr "paradigmas de programacao" 3
   "sdudgljpdv gh surjudpdfdr"
   ```

3. Defina uma função `countValids :: String -> Int`, que receba uma string e retorne a quantidade de seus caracteres contidos no intervalo `['a'..'z']`. Exemplo:
   ```
   > countValids "paradigmas de programacao"
   23
   ```

4. Defina uma função `countChar :: Char -> String -> Int`, que retorne a quantidade de um dado caracter em uma string. Exemplo:
   ```
   > countChar 'a' "paradigmas de programacao"
   6
   ```

5. Usando `countValids`, `countChar` e `percent`, defina uma função `freqs :: String -> [Float]` que retorne as frequências dos caracteres `['a'..'z']` numa dada string. Use **list comprehension**. A frequência de um caracter é dada pelo percentual deste caracter entre os caracteres válidos da string. Por exemplo:
   ```
   > freqs "abc" 
   [33.333336,33.333336,33.333336,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0]
   > freqs ['a'..'z']
   [3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154]
   > sum $ freqs ['a'..'z']
   99.99999
   > freqs "abc def ghi jkl mno pqr stu vwx yz"
   [3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154,3.846154]
   > freqs "aaa"
   [100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0]
   > freqs "a"
   [100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0]
   > freqs "b"
   [0.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0]
   > freqs "c"
   [0.0,0.0,100.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0]
   ```

6. Defina uma função `positions :: Float -> [Float] -> [Int]`, que retorne uma lista de posições de um dado número em uma lista. Considere que as posições comecem em zero. Use a função `zip` como auxiliar no seu código. Exemplos de uso da função:
   ```
   > positions 1.5 [0,7.5,8,1.5]
   [3]
   > positions 1.5 [1.5,7.5,8,1.5]
   [0,3]
   > positions 9 [1.5,7.5,8,1.5]
   []
   ```


## Extras

Decifre os códigos abaixo para descobrir ideias de extras! :-)


1. Phvtxlvh vreuh d ixqfdr gh dowd rughp irog, wdpehp fkdpdgd gh uhgxfh, h vxdv yduldfrhv irogu, irogo, irogu1, irogo1. Fruqhfd xpd qryd yhuvdr gh dojxpd ixqfdr gd sduwh txdwur, xvdqgr dojxpd yduldfdr gh irog.

2. 41 6c 67 75 6d 61 73 20 66 72 61 73 65 73 20 66 61 6d 6f 73 61 73 20 64 6f 20 41 6c 61 6e 20 4a 2e 20 50 65 72 6c 69 73 20 70 61 72 61 20 65 73 70 69 63 68 61 72 20 61 20 6d 65 6e 73 61 67 65 6d 3a a 46 6f 6e 74 65 3a 20 68 74 74 70 3a 2f 2f 77 77 77 2e 63 73 2e 79 61 6c 65 2e 65 64 75 2f 68 6f 6d 65 73 2f 70 65 72 6c 69 73 2d 61 6c 61 6e 2f 71 75 6f 74 65 73 2e 68 74 6d 6c a 38 2e 20 41 20 70 72 6f 67 72 61 6d 6d 69 6e 67 20 6c 61 6e 67 75 61 67 65 20 69 73 20 6c 6f 77 20 6c 65 76 65 6c 20 77 68 65 6e 20 69 74 73 20 70 72 6f 67 72 61 6d 73 20 72 65 71 75 69 72 65 20 61 74 74 65 6e 74 69 6f 6e 20 74 6f 20 74 68 65 20 69 72 72 65 6c 65 76 61 6e 74 2e a 39 2e 20 49 74 20 69 73 20 62 65 74 74 65 72 20 74 6f 20 68 61 76 65 20 31 30 30 20 66 75 6e 63 74 69 6f 6e 73 20 6f 70 65 72 61 74 65 20 6f 6e 20 6f 6e 65 20 64 61 74 61 20 73 74 72 75 63 74 75 72 65 20 74 68 61 6e 20 31 30 20 66 75 6e 63 74 69 6f 6e 73 20 6f 6e 20 31 30 20 64 61 74 61 20 73 74 72 75 63 74 75 72 65 73 2e 20 a 31 39 2e 20 41 20 6c 61 6e 67 75 61 67 65 20 74 68 61 74 20 64 6f 65 73 6e 27 74 20 61 66 66 65 63 74 20 74 68 65 20 77 61 79 20 79 6f 75 20 74 68 69 6e 6b 20 61 62 6f 75 74 20 70 72 6f 67 72 61 6d 6d 69 6e 67 2c 20 69 73 20 6e 6f 74 20 77 6f 72 74 68 20 6b 6e 6f 77 69 6e 67 2e a 41 67 6f 72 61 20 73 69 6d 2c 20 61 20 55 52 4c 20 69 6d 70 6f 72 74 61 6e 74 65 20 70 61 72 61 20 65 73 74 65 20 74 72 61 62 61 6c 68 6f 3a a 68 74 74 70 3a 2f 2f 62 69 74 2e 6c 79 2f 64 65 73 61 66 69 6f 2d 70 61 72 61 64 69 67 6d 61 73 a 41 63 65 73 73 65 20 70 61 72 61 20 73 61 62 65 72 20 6d 61 69 73 21


3. Ne tevxi xviw, ew vikvew hi gepgyps hs hmkmxs zivmjmgehsv iwxes mpywxvehew iq yq ibiqtps jsvqexehs gsqs yqe xefipe lxqp. Cvmi yqe jyrges uyi tvshyde s gshmks lxqp hi yqe xefipe wiqiplerxi, teve yq hehs ryqivs ier hi xvidi hmkmxsw.


4. 41 6c 67 75 6d 61 73 20 66 72 61 73 65 73 20 66 61 6d 6f 73 61 73 20 64 6f 20 41 6c 61 6e 20 4a 2e 20 50 65 72 6c 69 73 20 70 61 72 61 20 65 73 70 69 63 68 61 72 20 61 20 6d 65 6e 73 61 67 65 6d 3a a 46 6f 6e 74 65 3a 20 68 74 74 70 3a 2f 2f 77 77 77 2e 63 73 2e 79 61 6c 65 2e 65 64 75 2f 68 6f 6d 65 73 2f 70 65 72 6c 69 73 2d 61 6c 61 6e 2f 71 75 6f 74 65 73 2e 68 74 6d 6c a 38 2e 20 41 20 70 72 6f 67 72 61 6d 6d 69 6e 67 20 6c 61 6e 67 75 61 67 65 20 69 73 20 6c 6f 77 20 6c 65 76 65 6c 20 77 68 65 6e 20 69 74 73 20 70 72 6f 67 72 61 6d 73 20 72 65 71 75 69 72 65 20 61 74 74 65 6e 74 69 6f 6e 20 74 6f 20 74 68 65 20 69 72 72 65 6c 65 76 61 6e 74 2e a 39 2e 20 49 74 20 69 73 20 62 65 74 74 65 72 20 74 6f 20 68 61 76 65 20 31 30 30 20 66 75 6e 63 74 69 6f 6e 73 20 6f 70 65 72 61 74 65 20 6f 6e 20 6f 6e 65 20 64 61 74 61 20 73 74 72 75 63 74 75 72 65 20 74 68 61 6e 20 31 30 20 66 75 6e 63 74 69 6f 6e 73 20 6f 6e 20 31 30 20 64 61 74 61 20 73 74 72 75 63 74 75 72 65 73 2e 20 a 31 39 2e 20 41 20 6c 61 6e 67 75 61 67 65 20 74 68 61 74 20 64 6f 65 73 6e 27 74 20 61 66 66 65 63 74 20 74 68 65 20 77 61 79 20 79 6f 75 20 74 68 69 6e 6b 20 61 62 6f 75 74 20 70 72 6f 67 72 61 6d 6d 69 6e 67 2c 20 69 73 20 6e 6f 74 20 77 6f 72 74 68 20 6b 6e 6f 77 69 6e 67 2e a 41 67 6f 72 61 20 73 69 6d 2c 20 61 20 55 52 4c 20 69 6d 70 6f 72 74 61 6e 74 65 20 70 61 72 61 20 65 73 74 65 20 74 72 61 62 61 6c 68 6f 3a a 68 74 74 70 3a 2f 2f 62 69 74 2e 6c 79 2f 64 65 73 61 66 69 6f 2d 70 61 72 61 64 69 67 6d 61 73 a 41 63 65 73 73 65 20 70 61 72 61 20 73 61 62 65 72 20 6d 61 69 73 21





