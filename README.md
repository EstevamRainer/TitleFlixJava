<div align="center">
  <h1>🎬 Title Flix 🎬</h1>
  <h2>🏠 Bem vindo(a) ao repositório do Back-End do Title Flix 🏠</h2>
</div>

Title Flix é um site com foco em ```criação de listas de filmes```. Por exemplo, você pode criar uma lista de de filmes para assistir com amigos, outra pra assistir sozinho ou até com sua namorada e/ou esposa! Porém para tudo isso funcionar é necessário um Back-End, e é pra isso que o Title Flix Java existe!

![image](https://github.com/EstevamRainer/TitleFlixJava/assets/122125357/e7db8465-fb3d-49b9-a96e-e46873ee747d)

<h2>🗺 Sumário</h2>

* [Situação do Projeto](#situacao)
* [Funções do TitleFlixJava](#FuncoesTitleFlix)
* [Técnologias e conceitos aplicados no projeto](#Tecnologias)
* [Como executar o projeto](#ComoExecutar)
* [Como funciona cada classe](#Explicacao)
  * [ApiOmdb](#ApiOmdb)
  * [Pacote Json Exit](#Pacote-Json-Exit)
  * [Pacote Methods](#Pacote-Methods)
    * [ComputerClock](#ComputerClock)
    * [CreateTitle](#CreateTitle)
    * [ErrorVerifier](#ErrorVerifier)
    * [NumberConverter](#NumberConverter)
    * [VerifyTitle](#VerifyTitle)
  * [Pacote TitleModels](#Pacote-TitleModels)
    * [Title](#Title)
    * [Movie/Series](#Movie/Series)
    * [TitleOMDb e RatingAndSeasons](#TitleOMDb-e-RatingAndSeasons)
    * [TitleNotFound](#TitleNotFound)
  * [TitleSearcher](#TitleSearcher)
  * [TitleRequest](#TitleRequest)
* [Final](#final)

<h2 id="situacao">☑ Situação do projeto:</h2>
<div align=center>
<img src="https://img.shields.io/badge/Em%20Desenvolvimento-%2364E9EE?style=flat&color=%2364E9EE" heigh=150 width=150/>
</div>

<h2 id="FuncoesTitleFlix">❓ Quais são as funções do TitleFlixJava? ❓</h2>

TitleFlix foi desenvolvido com o intuíto de facilitar as suas noites de filmes, apresentando uma imensa gama de filmes dos quais você pode assistir assim que possível. É possível fazer diversas listas importantes como: ```"Ver em Família"```, ```"Para rir"```, ```"Quando eu estiver pra baixo"```, etc.

<h2 id="Tecnologias">💻 Técnologias e conceitos aplicados no projeto 🤔</h2>

- Pacote Java: java.util.Scanner
- Pacote Java: java.time.LocalDateTime
- Pacote Java: java.io.FileWriter
- API do Google: GSON API
- Conceitos Design Patterns aplicados:
  - Chain of Responsibility
  - Command
  - Adapter
  - Facade
- OMDb API
- Criação de Json através de ArrayList

<h2 id="ComoExecutar"> ⚙ Como executar o projeto? ⚙ </h2>

Tenha em seu computador uma ```IDE``` como ```Eclipse``` ou ```ItelliJ```.
Após isso tenha em mente que para o projeto ser executado é necessário adicionar o jar do GSON manualmente.
Nesse repositório explico melhor como fazer isso. Link do repositório: https://github.com/EstevamRainer/Cep_Search

<h2 id="Explicacao">👨‍🏫 Explicação das Classes 👨‍🏫</h2>
Cada classe nesse projeto têm seu trabalho e propósito. Estarei listando a seguir com detalhes seus propósitos:

<h3 id="ApiOmdb">ApiOmdb</h3>

Essa Classe têm um papel fundamental no projeto, que é o de adquirir o **JSON** do titulo requisitado utilizando o ```HTTPClient``` e retorna-lo para a Classe da qual utilizou o método _getJson_ dessa classe. 

<h3 id="Pacote-Json-Exit">Pacote Json Exit</h3>

Esse pacote têm como objetivo principal ser a saída dos arquivos .Json após a execução do TitleFlix

<h3 id="Pacote-Methods">Pacote Methods</h3>

<h4 id="ComputerClock">ComputerClock</h4>

ComputerClock é uma classe bem símples que têm como funcionalidade retornar a data/hora em que foi feito o request da API para ser adicionada no JSON criado.

<h4 id="CreateTitle">CreateTitle</h4>

CreateTitle é uma das classes mais importantes do projeto. Ela têm como principal funcionalidade criar um objeto com base no que foi informado pela classe VerifyTitle e assim com as informações corretas criar a classe "Filme", "Série" ou caso não seja encontrado uma título, "TitleNotFound".

<h4 id="ErrorVerifier">ErrorVerifier</h4>

Essa classe verifica informações fornecidas pela API e se a informação não for adquirida de uma forma esperada, essa classe já a corrige para o programa conseguir identifica-la sem maiores problemas.

<h4 id="NumberConverter">NumberConverter</h4>

Essa é uma classe com uma implementação inteligente que corrige dados numéricos incorretos ou inválidos enviados pela API transformando-os em dados válidos que poderão ser lidos pelo programa sem maiores problemas assim evitando exceptions.

<h4 id="VerifyTitle">VerifyTitle</h4>

Essa classe pode ser facilmente confundida com a CreateTitle, porém ela desempenha um papel diferente na aplicação. Ela analiza do que se trata o título requisitado e envia para o CreateTitle um comando sobre o que deve ser criado, se é um Filme, Série ou um se é um Título Inválido.

<h3 id="Pacote-TitleModels">Pacote TitleModels</h3>

Nesse pacote se encontra as Classes que modelam o objeto que será criado.

<h4 id="Title">Title</h4>

Essa é uma Classe abstrata que contém todas as informações que tanto uma série quanto um filme devem ter, como por exemplo: nome, se o titulo em questão já foi lançado e duração.

<h4 id="Movie/Series">Movie e Series</h4>

Ambas as classes herdam Title, ou seja têm suas mesmas informações porém com um acréscimo, por exemplo: Movie têm nome, ano de lançamento e duração, porém também contém o ano de lançamento do filme. Já a séries contém o roteirista e a quantidade total de temporadas. Ambas essas Classes contém um construtor que adquire informações da classe ```TitleOMDb```.

<h4 id="TitleOMDb-e-RatingAndSeasons" >TitleOMDb e RatingAndSeasons</h4>

Essas são as duas classes record do projeto que guardam as informações do Título. TitleOMDb guarda as seguintes informações sobre o Título: Nome, Ano de Lançamento, Duração, Se é uma Série ou Filme, se será ou ja foi lançado, Gênero, Diretor, Sinópse, Link do Pôster, Roteirista e se a requisição ocorreu corretamente. 
<br>
<br>
Já a Classe RatingAndSeasons guarda apenas informações sobre a nota e quantidade de temporadas da Série, pois ao usar o Gson houve um bug que essas informações não eram adquiridas como as outras, por isso tive que criar uma classe record com apenas essas informações com o propósito de elas serem adquiridas corretamente.

<h4 id="TitleNotFound">TitleNotFound</h4>

O propósito dessa classe é ser criada ao não ser encontrado o título específicado pelo Usuário.

<h3 id="TitleSearcher">TitleSearcher</h3>

Essa classe utiliza do padrão Facade para facilitar a hora do uso da aplicação, resumindo-a em apenas dois métodos que são muito intuítivos e fáceis de serem utilizados pelo Usuário.

<h3 id="TitleRequest">TitleRequest</h3>

Essa é a classe principal do projeto, da qual se têm o método Main para a utilização do projeto sem maiores problemas.

<div align="Center">
<h2 id="final">😁👍 Obrigado pela Atenção 😁👍</h2>
</div>

