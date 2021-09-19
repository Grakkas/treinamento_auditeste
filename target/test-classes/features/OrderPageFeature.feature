#language: pt
  @orderPage
  Funcionalidade: Suite de testes contemplando a finalização de pedidos.

    @orderPageCT01
    Cenario: Deve finalizar carrinho com um produto com sucesso
      Dado que sou cliente da sauce demo
        | usuario       | senha        |
        | standard_user | secret_sauce |
      Quando adicionar um produto no meu carrinho
        | nomeProduto         |
        | Sauce Labs Backpack |
      E seguir para o checkout
      Quando preencher o formulario com as informacoes do cliente
      |nome   |sobrenome|   cep   |
      |Gabriel| Silva   | 01518020|
      E finalizar a compra
      Entao vejo a tela de confirmacao do pedido