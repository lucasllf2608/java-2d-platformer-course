# JogoDoCurso

Projeto prático do curso **Aprenda a criar jogos de plataforma 2D em Java**, desenvolvido no **Eclipse IDE**. O objetivo é construir, do zero, uma engine 2D capaz de sustentar jogos de plataforma e servir de base para os seus próprios games.

## Sobre o curso

O curso é composto por aulas focadas no desenvolvimento de jogos em Java, passo a passo, direto no seu computador. Você monta a engine peça a peça — gráficos, loop de jogo, entidades e mecânicas de plataforma — até ter condições de dar o pontapé inicial nos seus primeiros jogos 2D.

## Requisitos

- [JDK](https://www.oracle.com/java/technologies/downloads/) (Java com suporte a módulos)
- [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/) (recomendado pelo curso)

## Estrutura do projeto

```
JogoDoCurso/
├── src/
│   ├── module-info.java    # Módulo Java (requer java.desktop)
│   └── graficos/
│       └── Game.java       # Janela principal e ponto de entrada
└── bin/                    # Classes compiladas (gerado ao compilar)
```

## Como executar

1. **File → Open Projects from File System…** e selecione a pasta do projeto.
2. Execute a classe `graficos.Game` (**Run As → Java Application**).

## Estado atual

A janela do jogo (`JFrame` + `Canvas`) já está configurada com resolução base **160×160** e escala **3×**. O loop principal (`Runnable`) será implementado ao longo das aulas.

## Licença

Material de estudo pessoal vinculado ao curso. Consulte os termos do curso para uso e distribuição.
