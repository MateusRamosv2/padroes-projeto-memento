# Padrões de Projeto - Memento

---

## Estrutura do Projeto

- **Interface de Estado (O Memento):** `EstadoPedidoSupermercado` → Define o contrato base. Neste modelo arquitetural híbrido, a própria interface de estado atua como o "Memento", representando uma fotografia imutável de um momento específico do ciclo de vida do pedido.
- **Estados Concretos:** `EstadoPedidoRascunho`, `EstadoPedidoSeparacao`, `EstadoPedidoFaturado`, `EstadoPedidoEnviado` e `EstadoPedidoCancelado` → Implementam a interface utilizando o padrão Singleton. Como os estados não possuem variáveis de instância (são apenas comportamentos/nomes lógicos), existir apenas uma instância de cada um em memória otimiza o uso de recursos.
- **Originator e Caretaker:** `PedidoSupermercado` → Concentra dois papéis clássicos do padrão. Ele é o *Originator* (o objeto cujo estado está mudando e sendo salvo) e também atua como *Caretaker* (mantém a lista `memento` com o histórico seguro de estados passados).
- **Testes:** `PedidoSupermercadoTest` → Valida utilizando a biblioteca JUnit a máquina do tempo do pedido. Garante que as mudanças de status (como ir de "Rascunho" até "Cancelado") sejam gravadas sequencialmente e que a funcionalidade de "desfazer/restaurar" (método `restauraEstado`) retorne o pedido para um índice passado de forma segura.

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação. O grande detalhe arquitetural (e o mais importante a se observar) é a dupla conexão entre a classe `PedidoSupermercado` e a interface `EstadoPedidoSupermercado`. Uma linha de associação simples representa o estado vigente (multiplicidade 1), enquanto a linha de agregação representa a lista do histórico temporal (multiplicidade de zero a muitos `*`), permitindo assim a restauração de snapshots passados.

<img width="1182" height="417" alt="Diagrma - Memento" src="https://github.com/user-attachments/assets/7add6300-34bc-4c77-bcc7-81ac49a0e841" />
