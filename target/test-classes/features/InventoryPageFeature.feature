#language: pt
@inventoryPage
Funcionalidade: Testes da página de inventário

  @inventoryPageCT01
  Cenário: Deve adicionar um produto ao carrinho com sucesso
    Dado que sou cliente da sauce demo
      | usuario       | senha        |
      | standard_user | secret_sauce |
    Entao adicionar um produto no meu carrinho
      | nomeProduto         |
      | Sauce Labs Backpack |

  @inventoryPageCT02
  Cenário: Deve adicionar multiplos produtos ao carrinho com sucesso
    Dado que sou cliente da sauce demo
      | usuario       | senha        |
      | standard_user | secret_sauce |
    Entao adicionar um produto no meu carrinho
      | nomeProduto                       |
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Fleece Jacket          |

  @inventoryPageCT03
  Cenário: Deve adicionar e remover um produto ao carrinho com sucesso
    Dado que sou cliente da sauce demo
      | usuario       | senha        |
      | standard_user | secret_sauce |
    Entao adicionar um produto no meu carrinho
      | nomeProduto         |
      | Sauce Labs Backpack |
    E removo um produto no meu Carrinho
      | nomeProduto         |
      | Sauce Labs Backpack |

  @inventoryPageCT04
  Cenário: Deve adicionar e remover multiplos produtos ao carrinho com sucesso
    Dado que sou cliente da sauce demo
      | usuario       | senha        |
      | standard_user | secret_sauce |
    Entao adicionar um produto no meu carrinho
      | nomeProduto                       |
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Fleece Jacket          |
    E removo um produto no meu Carrinho
      | nomeProduto                       |
      | Sauce Labs Backpack               |
      | Test.allTheThings() T-Shirt (Red) |