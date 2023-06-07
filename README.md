# 🌱 Acervinho Rest Assured

Opa!! 😄 <br/>
Por alguns meses, esse repo foi utilizado para facilitar uma mentoria de Rest Assured básico, mas, achei que seria legal aproveitar e deixar também algumas leituras, cursos sobre o assunto que me ajudaram nos estudos... <br/>
O que vou armazenando aqui, são materiais que montei com minha pouca experiência no assunto - sendo dev 🤣, então o projeto fica 100% aberto p/ correções e pull requests de contribuição!
<br/>
<br/>

## 🔍 Resumão simples dos temas abordados durante a mentoria:


O que é Rest Assured?
- Biblioteca que nos permite fazer requisições HTTP para APIS nos testes e validar seus retornos, cabeçalhos, status codes com ajuda de libs de validação… 

O que é JUnit?
- No contexto desse projeto, biblioteca que utilizamos para rodar os testes, com a anotação @Test, e realizar algumas validações.

O que é Hamcrest?
- Mais uma biblioteca que nos permite também realizar validações nos retornos das requisições dos testes.
https://hamcrest.org/JavaHamcrest/javadoc/2.1/
Uma boa parte dos métodos do Hamcrest foram incorporados no JUnit, então não precisamos colocar a dependência dele de fato nos projetos a maioria das vezes, a não ser que precisemos de métodos menos "conhecidos" da lib.


O que é o @DisplayName?
- Anotação que utilizamos em cima dos testes, para descrições mais detalhadas do que está sendo validado. Normalmente, é mais aplicada quando o propósito do teste é muito longo e fica difícil de se ler em camelCase. 
- Exemplo: @DisplayName(“Explicação do teste em forma de frase”)


O que é serialização?
- Transformar um objeto, em algo que possa ser passado no corpo de uma requisição (JSON, XML…).

O que é deserialização?
- Transformar algo que possa ser passado no corpo de uma requisição (JSON, XML…), em um objeto java.

Para os dois processos acima, usamos bibliotecas como **GSON, Jackson ou XMLUnit.**



## 📘 Cursos e leituras interessantes:

- Canal no Youtube Julio de Lima
https://www.youtube.com/watch?v=kWdAhtcyxw8&ab_channel=JuliodeLima

- Curso Udemy (muuuuito bom e de entendimento simples)
https://www.udemy.com/share/101FqW3@QosnzIF4sfIkgfRN9AZMskQnmAxF7-CgB8tM3uufI7jyieBYWtzauNQZDaU_98kFNg==/

