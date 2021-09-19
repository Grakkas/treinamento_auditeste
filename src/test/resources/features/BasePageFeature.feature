#language: pt
@basePage
Funcionalidade: Testes da página de login

  @basePageCT01
  Cenário: Deve realizar o login com sucesso
    Dado que estou navegando na pagina principal
    E realizar o preenchimento das informacoes de login
      | usuario       | senha        |
      | lock_out_user | secret_sauce |
    Então verifico meu login