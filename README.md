
# Trabalho de Pesquisa Operacional

## Problema de designação - Algoritmo Húngaro
#### Alunos:  
Abne Martins 
Ana Cláudia
Luiz Henrique
Pedro Henrique

Seguindo as orientações, o grupo desenvolveu um mecanismo para a resolução de problemas de desiginação, sendo esses problemas para alocação de recursos de 1 para 1.


> O Método Húngaro **é um método de otimização utilizado para resolução de diversos problemas práticos de alocação de tarefas**. Com ele, encontra-se de forma eficiente uma solução ótima para o Problema da Designação (RENDER et al, 2010).

Para a execução do algoritmo foi utilizado o material disponíbilizado em aula, e seguindo os seguintes passos do mesmo.

1. Subtraia o menor número em cada linha de cada um dos números da linha. (Isso é chamado redução de linhas). Introduza os resultados em uma nova tabela 
2.  Subtraia o menor número em cada coluna da nova tabela de cada um dos números da coluna. (Isso é denominado redução de colunas). Introduza os resultados em outra tabela 
3. Teste se é possível fazer uma designação ótima. Isso é feito determinando-se o número mínimo de retas necessárias para cobrir (isto é, cruzar) todos os zeros. Se o número de retas for igual ao número de linhas, é possível termos um conjunto de designações ótimo. Nesse caso, vá para o passo 6. Caso contrário, prossiga no passo 4
4. Se o número de retas for menor que o número de linhas, modifique a tabela da seguinte maneira: 
4.1. Subtraia o menor número descoberto de cada um dos números descobertos da tabela 
4.2. Adicione o menor número descoberto aos números que se encontram nas interseções de retas. Números que foram cruzados, mas não se encontram nas interseções de retas são transferidos sem alteração para a próxima tabela 
7. Repita os passos 3 e 4 até se tomar possível um conjunto ótimo de designações
8. Faça as designações uma de cada vez nas posições contendo elementos zero Comece com linhas ou colunas que tenham apenas um zero Já que cada linha e coluna precisam receber exatamente uma designação, risque tanto a linha quanto a coluna envolvidas após cada designação ter sido feita A seguir, prossiga nas linhas e colunas que ainda não foram riscadas para selecionar a próxima designação, preferencialmente dada àquela linha ou coluna que contenha apenas um zero que não foi riscado Continue até todas as linhas e colunas terem exatamente uma designação e, portanto, terem sido cruzadas



#### Problema:
A empresa de madeira Principau foi contratada para realizar um serviço que envolvia o corte de 5 árvores de um novo loteamento na região. As árvores incluíam um pinheiro, um pé de manga, um coqueiro, um pé de jaca e uma macieira. Como os funcionários da madeireira já estavam ocupados com outros trabalhos, a empresa teve que buscar a ajuda de profissionais autônomos conhecidos. No entanto, cada profissional cobra uma tarifa diferente para cada tipo de árvore, conforme indicado na tabela a seguir. Qual seria o custo mínimo ao cortar as 5 árvores utilizando os serviços de 5 profissionais distintos?

|               | Pinheiro | Pé de manga | Coqueiro | Pé de Jaca | Macieira |
|---------------|----------|-------------|----------|------------|----------|
| Funcionário 0 |  R$ 6,70 |     R$ 5,00 |  R$ 9,80 |    R$ 2,00 |  R$ 3,50 |
| Funcionário 1 |  R$ 3,00 |     R$ 9,00 |  R$ 8,40 |    R$ 7,00 |  R$ 9,70 |
| Funcionário 2 |  R$ 8,00 |     R$ 5,60 |  R$ 4,00 |    R$ 6,00 |  R$ 4,00 |
| Funcionário 3 |  R$ 4,00 |     R$ 2,20 |  R$ 5,60 |    R$ 5,20 |  R$ 6,00 |
| Funcionário 4 |  R$ 7,00 |     R$ 3,00 |  R$ 8,00 |    R$ 4,70 |  R$ 5,20 |

#####Partindo para a resolução:


Seguindo o fluxo do algoritmo:

![image](https://github.com/abnemm/algHungaro/assets/109525805/5e7dfe50-8407-4c5e-87c6-90976e5701f4)
 
![image](https://github.com/abnemm/algHungaro/assets/109525805/c52df7d1-f69f-42ec-abfb-ed06e1c307b3)

![image](https://github.com/abnemm/algHungaro/assets/109525805/a6607657-12ac-4211-9007-00fa53f8f169)

![image](https://github.com/abnemm/algHungaro/assets/109525805/dbc07ae3-7cf6-4dba-81df-1fa0e90d4bad)

![image](https://github.com/abnemm/algHungaro/assets/109525805/ffd2fcba-ef18-482c-97d9-4458edf1f20b)

Dessa forma o algoritmo decide a melhor escolha independente do tamanho da matriz, optando sempre pela solução ótima.


Referencias:
https://doity.com.br/media/doity/submissoes/artigo-4142ba37800025b609e8c80b9eedf2bf9877c1ab-arquivo.docx#:~:text=O%20M%C3%A9todo%20H%C3%BAngaro%20%C3%A9%20um,RENDER%20et%20al%2C%202010).
