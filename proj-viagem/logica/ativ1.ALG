Algoritmo "semnome"
// Professor   : Flavio Mota
// Autor(a)    : Maori Amorim
// Data atual  : 6/29/2022
Var
   // Seção de Declarações das variáveis
   nome: vetor[1..2] de caracter
   email:vetor[1..2] de caracter
   local:vetor[1..2] de caracter
   data:vetor[1..2] de inteiro
   i:inteiro
   ops:caracter
   o:inteiro
   pesquisa:caractere
Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc.
   //mantem o loop de perguntas
   escreval("tecle c para finalizar o programa")
   escreval("outra tecla pra continuar")
   enquanto ops <>"c" faca
      leia(ops)
      //para sair do programa
      se (ops = "c") entao
Fimalgoritmo
fimse
//menu
i <- 1
o <- 1
escreval("1 - Cadastro cliente")
escreval("2 - Cadastro de destino")
escreval("3 - Pesquisa de cliente")
escreval("4 - Pesquisa de local")
leia (ops)
//cadastro cliente
se (ops = "1") entao
   escreval("Cadastre seu nome")
   leia (nome[i])
   escreval("Agora seu email")
   leia (email[i])
   i <- i + 1
fimse
//cadastro local
se (ops = "2") entao
   escreval("cadastre o local")
   leia (local[o])
   escreval("marque a data")
   escreval("apenas os numeros(160052002)")
   leia (data[o])
fimse
//pesquisa de cliente
se (ops = "3") entao
   escreval("o nome")
   leia (pesquisa)
   //andar o vetor
   para i de 1 ate 2 faca
      se (nome[i] = pesquisa) entao
         //se a pesquisa estiver no vetor
         //"retorna" nome e email associado
         escreval(nome[i])
         escreval(email[i])
         interrompa
      senao
         escreval("esse nome nao foi cadastrado")
      fimse
   fimpara
fimse
//pesquisa destinos
se (ops = "4") entao
   escreval("o local")
   leia (pesquisa)
   //andar o vetor
   para i de 1 ate 2 faca
      se (local[i] = pesquisa) entao
         //se a pesquisa estiver no vetor
         //"retorna" local e data associada
         escreval(local[i])
         escreval(data[i])
interrompa
      senao
         escreval("esse local nao foi cadastrado")

      fimse
   fimpara
fimse


fimenquanto
Fimalgoritmo
