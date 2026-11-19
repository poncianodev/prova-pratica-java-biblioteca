# Respostas — Sistema de Emprestimo da Biblioteca

Nome completo: Lucas Barbosa Ponciano RA: 3111392523024

> Preencha **todos** os campos. Campo vazio é campo não avaliado.
> Não apague os títulos nem os rótulos em negrito: a correção procura por eles.

---

# Etapa 1 — Diagnóstico

## Problema 1 — a conversão do acervo central

**Em que consiste o problema, e o que acontece quando o sistema cresce:**

O problema consiste na conversão da matriz de string que vem do sistema legado está duplicada em duas classes diferentes. Conforme o sistema cresce e novas telas precisam ler o acervo, essa lógica vai gerar bug de incosistência.

**Princípio SOLID violado:**

Foi violado o Princípio da Responsabilidade Única (SRP)

**Classes afetadas (pelo nome):**

CatalogoExemplares e RelatorioColecao

**Que outra dependência indevida essas classes têm em relação ao
acervo central, e por que ela é um problema:**

As duas classes estão ligadas à classe AcervoLegadoWS, o que acaba engessando o código. Pois se no futuro o acervo mudar de banco de dados ou outra API, será necessário alterar as regras de negócio.

## Problema 2 — o ciclo de vida de Emprestimo

**Em que consiste o problema, e o que acontece quando o sistema cresce:**

O controle de estado do empréstimo está todo baseado em if/else. Se o sistema crescer e precisar de outro estado, será necessário alterar todos os métodos da classe Emprestimo.

**Princípio SOLID violado:**

Princípio de Aberto/Fechado (OCP)

**Classes afetadas (pelo nome):**

Emprestimo

---

# Etapa 4 — Justificativa

## Padrão aplicado ao Problema 1

**O problema que ele resolve (descreva antes de nomear o padrão):**

Ele resolve o conflito de formatos que o serviço legado entrega, e o que o nosso sistema precisa manipular.

**Nome do padrão:**

Adapter

**Alternativa descartada e por que ela não resolveria por completo:**

A alternativa sera alterar a propria classe AcervoLegadoWS, pois essa classe simula um serviço externo em que não posso mexer.

## Padrão aplicado ao Problema 2

**O problema que ele resolve (descreva antes de nomear o padrão):**

Ele tira a cadeia de if/else de dentro da classe principal, e divide cada fase do ciclo em uma classe própria.

**Nome do padrão:**

State

**Alternativa descartada e por que ela não resolveria por completo:**

A alternativa sera trocar a String situacao por um enum. Isso até evitaria o erro de digitação, mas não retiraria os if/else e switch de dentro do método Emprestimo, com isso a lógica continuaria espalhada.
