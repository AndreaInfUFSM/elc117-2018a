-- Eleva um numero ao quadrado (aqui temos um comentario!)
doubleMe :: Int -> Int
doubleMe x = x^2
  
-- Verifica se um numero eh par (usa if/then/else para expressar funcao condicional)
-- mod: retorna resto da divisao inteira
isEven :: Int -> Bool
isEven n = if mod n 2 == 0 then True else False
-- Ou simplesmente:
-- isEven n = mod n 2 == 0

-- Gera um numero a partir de um caracter (usa outra estrutura condicional em Haskell: guardas)
encodeMe :: Char -> Int
encodeMe c 
  | c == 'S'  = 0
  | c == 'N'  = 1
  | otherwise = 2

-- Calcula o quadrado do primeiro elemento da lista
-- Note que '[Int]' designa uma lista de elementos do tipo Int 
doubleFirst :: [Int] -> Int
doubleFirst lis = (head lis)^2

-- Verifica se uma palavra tem mais de 2 caracteres
isLong :: String -> Bool -- isso é o mesmo que: isLong :: [Char] -> Bool
isLong s = length s > 2
