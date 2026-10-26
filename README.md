# JogoDoCurso

Projeto prático do curso **Aprenda a criar jogos de plataforma 2D em Java**. O objetivo é construir, do zero, uma engine 2D capaz de sustentar jogos de plataforma e servir de base para os seus próprios games.

## Sobre o curso

O curso é composto por aulas focadas no desenvolvimento de jogos em Java, passo a passo, direto no seu computador. Você monta a engine peça a peça — gráficos, loop de jogo, entidades e mecânicas de plataforma — até ter condições de dar o pontapé inicial nos seus primeiros jogos 2D.

## Requisitos

- [JDK](https://www.oracle.com/java/technologies/downloads/) (Java com suporte a módulos)
- [Cursor](https://cursor.com/) com a extensão **Extension Pack for Java**

## Estrutura do projeto

```
JogoDoCurso/
├── src/
│   ├── module-info.java          # Módulo Java (requer java.desktop)
│   ├── main/Game.java            # Janela, loop e ponto de entrada
│   ├── Entidades/                # Player e entidades
│   ├── Mundo/                    # Mapa, tiles e câmera
│   ├── graficos/Spritesheet.java # Recorte da folha de sprites
│   └── res/                      # Imagens usadas pelo jogo
│       ├── level1.png            # Mapa (um pixel = um tile de 16×16)
│       ├── spriteSheet-course.png
│       └── fundo.jpg
└── bin/                          # Classes compiladas (gerado ao executar)
```

As imagens ficam em `src/res`. O jogo abre esses arquivos pelo caminho do disco (`src/res/...`), com a pasta do projeto como diretório de trabalho. Editar `level1.png` e rodar de novo já carrega o mapa novo.

## Como executar

1. Abra a pasta do projeto no Cursor.
2. Execute a classe `main.Game` (botão **Run** acima do `main`).

A janela abre em **240×160** com escala **4×** (960×640). O movimento do player usa **W A S D**.

## Estado atual

- Loop do jogo a 60 ticks por segundo, com render em buffer.
- Player com animação de caminhada para a direita e para a esquerda.
- Mapa montado a partir das cores de `src/res/level1.png` (chão, chão com grama e vazio).
- Câmera acompanha o desenho do mundo e das entidades.
- Sprites de chão e de tile vazio vêm da spritesheet.

## Licença

Material de estudo pessoal vinculado ao curso. Consulte os termos do curso para uso e distribuição.
