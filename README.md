# puzzle8
Atividade do problema do puzzle 8

Algoritmos de busca

Greedy Search
É um algoritmo que faz escolhas gananciosas em cada etapa para garantir que a função objetivo seja otimizada.
Ele tem apenas uma chance de calcular a solução ideal para que nunca volte e reverta a decisão.

A* Search
Tense uma célula alvo para se possível alcançar a partir da célula inicial o mais rápido possível. 
O A * Search escolhe o nó de acordo com um valor - ' f ', que é um parâmetro igual à soma de dois outros parâmetros - ' g ' e ' h '. 
Em cada etapa, ele seleciona o nó com o menor ' f ' e processa esse nó.
Definição de ' g ' e ' h '.
g = o custo de movimento para se deslocar do ponto de partida para um determinado ponto, seguindo o caminho gerado para chegar lá.
h = o custo estimado de movimento para mover-se daquele ponto especificado na grade para o destino final.
 
Graph Search
A busca em profundidade é um algoritmo utilizado para percorrer ou buscar itens dentro das estruturas de dados grafos ou árvores. 
Sua característica básica é percorrer todos os nós filhos ao nó raiz o mais profundo possível para somente depois retroceder, ou seja,
quanto menor o número, antes ele é visitado na busca. 
