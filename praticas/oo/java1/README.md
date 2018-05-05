# Prática: POO em Java



## Orientações 

Nesta prática você vai exercitar alguns conceitos de orientação a objetos resumidos nos slides sobre [Encapsulamento, classes e objetos em Java](https://docs.google.com/presentation/d/10M7otpa1_Z18zxB2__zvGbCofInx_CZ5lpbX_RvOooA/edit#slide=id.g35f391192_00). 

Para fazer os exercícios, você vai precisar do ambiente de desenvolvimento Java (JDK) disponível em: http://www.oracle.com/technetwork/java/javase/downloads/index.html


## Aquecimento


1. Baixe o programa [OlaMundo.java](OlaMundo.java).

2. Num terminal de comandos, compile o programa:

   ```
   javac OlaMundo.java
   ```
   O comando acima produz um arquivo .class para a classe contida em OlaMundo.java. Um arquivo .class contém um código (bytecode) interpretável por uma máquina virtual Java.

3. Execute o programa, informando o **nome da classe** que contém um método main:

   ```
   java -cp . OlaMundo
   ```
   Obs.: Se algo der errado e você estiver usando Windows, veja esta [página da Oracle](https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html) sobre problemas comuns e suas soluções. 



## Classe Circle

1. Baixe o programa [Circle.java](Circle.java) e observe seu código. Você consegue prever a saída deste programa antes de executá-lo?

2. Compile e execute o programa:
   ```
   javac Circle.java
   java -cp . Circle
   ```
3. Acrescente um método `public void setRadius(double radius)` à classe Circle, para alterar o raio de um círculo.

4. Modifique o método `main` para chamar o método `setRadius` no círculo `c`.

5. Acrescente as seguintes linhas ao final do método `main`:
   ```
   Circle c2;
   c2.setRadius(5.0);
   ```
   Compile o programa. O que acontece?

6. Corrija o programa, criando um objeto da classe Circle que será referenciado por `c2`. Compile novamente o programa.

7. Acrescente um novo construtor à classe `Circle`, que receba valores para `x`, `y` e `r`.

8. Modifique o método `main` para criar outros objetos da classe `Circle`, usando o novo construtor. Mostre a área dos novos objetos.

9. Baixe o programa [TestCircle.java](TestCircle.java) e **coloque-o na mesma pasta** do programa [Circle.java](Circle.java). 

10. No programa [TestCircle.java](TestCircle.java), inclua a seguinte linha de código ao final do método `main`:
    ```
    c1.r = 0.5;
    ```
    Compile o programa. Qual o motivo do erro que acontece? Como corrigi-lo?
   

11. No programa [Circle.java](Circle.java), inclua a seguinte linha de código ao final do método `main`:
    ```
    c.r = 0.5;
    ```
    Compile o programa. Por que não acontece o mesmo erro da questão anterior?
   

12. No programa [Circle.java](Circle.java), acrescente a seguinte linha no construtor `Circle()`:
    ```
    System.out.println("New Circle");
    ```
    Compile e execute os programas [Circle.java](Circle.java) e [TestCircle.java](TestCircle.java), observando as saídas.

13. No programa [TestCircle.java](TestCircle.java), acrescente a seguinte linha ao final do método `main`:
    ```
    Circle[] circs = new Circle[10];
    ```
    Você acha que a saída do programa será modificada?

14. Acrescente as seguintes linhas ao programa [TestCircle.java](TestCircle.java):
    ```java
       for (int i = 0; i < circs.length; i++) {
          circs[i] = new Circle();
       }
    ```
    Qual será a saída do programa agora?



## Classe Point 

1. Crie uma classe denominada ``Point``, que armazene as coordenadas ``(x,y)`` de um ponto num plano. A coordenada default para qualquer ponto deve ser ``(0.0,0.0)``. Além do construtor, esta classe deve conter:

   - um método que desloque as coordenadas de um ponto (x,y) para as coordenadas (x+dx,x+dy), sendo dx e dy argumentos do método

   - um método que calcule a distância entre 2 pontos (x1,y1) e (x2,y2) segundo o teorema de Pitágoras: 
     ```
     dx = x2 - x1
     dy = y2 - y1
     distancia = sqrt(dx*dx + dy*dy)
     ```

     **Dica**: para o cálculo da raiz quadrada, consulte os exemplos da seção [Beyond Basic Arithmetic](http://download.oracle.com/javase/tutorial/java/data/beyondmath.html), na página de [tutoriais Java](http://download.oracle.com/javase/tutorial/) da Oracle. 

2. Crie um programa Java que utilize a classe `Ponto` do exercício anterior.

 
