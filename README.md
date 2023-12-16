# Projeto API Rest - Casa Do Viralata - Testes E2E 

Projeto final do Módulo Testes Automatizados I da Trilha Java da Ada Tech, em parceria com o BTG Pactual &lt;womandev> #btgfaztech.

### Respositórios:
API_CasaDoViralata_testes: [https://github.com/beatrizberto/API_CasaDoViralata_testes]

API_CasaDoViralata_testesEndToEnd: [[https://github.com/beatrizberto/API_CasaDoViralata_testesEndToEnd]

### Alunas:
- Beatriz Moreira Berto ([https://github.com/beatrizberto])
- Bruna Torres ([https://github.com/torresbc])
  
## Descrição do Projeto

Implementação de testes testes End-to-End de caixa preta, utilizando RestAssure, Cucumber e Gherkin, para o sistema de cadastro de usuários e animais da ONG Casa do Viralata. 

Este repositósio é complementado pelo repositório da aplicação, onde foram implementados os testes unitários e de integração.
Link do repositório da aplicação: [https://github.com/beatrizberto/API_CasaDoViralata_testes]

## Estrutura de testes

### Testes E2E
Feature: User register
- Scenario 1: Registro de novo User com sucesso (201)
- Scenario 2: Tentativa de registrar novo User sem o atributo email resulta em fracasso (404) e retorna mensagem "O campo email não pode estar vazio"
