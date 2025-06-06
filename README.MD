# API PARA RESTAURANTE

Criei esse projeto para colocar em prática os meus conhecimentos com Java Spring Boot,
que estudo.
O projeto é uma API onde pode criar o customer (cliente), restaurant (restaurante), menu (prato do menu) e
order (pedido).

### Spring Security
> Implementado spring security, geração de token JWT, configuração da cadeia de filtros de segurança. Sobrescrita do método
> doFilterInternal da classe OncePerRequestFilter, para capturar o token no cabeçalho da requisição.
> Implementação da classe UserDetails e adição de Roles.

## Operações nos end-points

### Customer
- Criar um cliente
- Encontrar um cliente pelo ID
- Encontrar um cliente pelo número do documento (cpf)
- Atualizar informações do cliente
- E deletar o cliente

### Restaurant
- Criar um restaurante
- Encontrar o restaurante pelo ID

### Menu Item
- Criar um prato para o menu (cardápio) do restaurante

### Order
- Criar um pedido passando o ID do cliente, e o ID do prato presente no cardápio

## Tecnologias
- Java Spring Boot
- H2
- Spring Data JPA

**O projeto conta com mapstruct e também com mapeamento manual na parte do cardápio, conta com records para DTO e também utilizar 
lombok para mapear entidades e DTO, dessa forma entendendo qual se encaixa melhor dependendo do contexto como uma forma de estudo**