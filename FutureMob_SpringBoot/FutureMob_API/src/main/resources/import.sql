-- Verifica se o banco de dados existe antes de criar
IF DB_ID('future_mob') IS NULL
BEGIN
    CREATE DATABASE future_mob
    COLLATE Latin1_General_CI_AS;
END
GO

USE future_mob;
GO

CREATE TABLE categorias (
  id_categoria INT NOT NULL IDENTITY(1,1),
  nome NVARCHAR(50) NOT NULL,
  descricao NVARCHAR(500) NOT NULL,
  caminho_icone NVARCHAR(100) NULL,
  PRIMARY KEY (id_categoria)
);
GO

CREATE TABLE produtos (
  id_produto INT NOT NULL IDENTITY(1,1),
  nome NVARCHAR(150) NOT NULL,
  descricao NVARCHAR(500) NOT NULL,
  preco_anterior DECIMAL(10,2) NOT NULL,
  preco_atual DECIMAL(10,2) NOT NULL,
  altura DECIMAL(5,2) NOT NULL,
  largura DECIMAL(5,2) NOT NULL,
  profundidade DECIMAL(5,2) NOT NULL,
  peso DECIMAL(6,2) NOT NULL,
  destaque BIT NOT NULL,
  oferta_relampago BIT NOT NULL,
  id_categoria INT NOT NULL,
  caminho_imagem NVARCHAR(255) NULL,
  ativo BIT NOT NULL DEFAULT 1,
  dt_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
  PRIMARY KEY (id_produto)
);
ALTER TABLE produtos ADD CONSTRAINT FK_Produto_Categoria FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria);
GO

CREATE TABLE usuarios (
  id_usuario INT NOT NULL IDENTITY(1,1),
  nome_completo NVARCHAR(80) NOT NULL,
  cpf CHAR(11) NOT NULL,
  rg CHAR(9) NOT NULL,
  dt_nascimento DATE NOT NULL,
  sexo CHAR(1) NOT NULL,
  telefone_celular CHAR(15) NOT NULL,
  email NVARCHAR(80) NOT NULL,
  senha NVARCHAR(255) NOT NULL,
  admin BIT NOT NULL,
  caminho_img_perfil NVARCHAR(200) NULL,
  PRIMARY KEY (id_usuario),
  CONSTRAINT UQ_CPF UNIQUE (cpf),
  CONSTRAINT UQ_email UNIQUE (email)
);

CREATE TABLE avaliacoes (
  id_avaliacao INT NOT NULL IDENTITY(1,1),
  id_usuario INT NOT NULL,
  id_produto INT NOT NULL,
  avaliacao DECIMAL(2,1) NOT NULL,
  dt_avaliacao DATE NOT NULL,
  titulo NVARCHAR(50) NOT NULL,
  descricao NVARCHAR(1000) NULL,
  imagem NVARCHAR(255) NULL,
  verificado BIT NOT NULL,
  PRIMARY KEY (id_avaliacao)
);
ALTER TABLE avaliacoes ADD CONSTRAINT FK_Produto_Avaliacao FOREIGN KEY (id_produto) REFERENCES produtos(id_produto);
ALTER TABLE avaliacoes ADD CONSTRAINT FK_Usuario_Avaliacao FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
GO

CREATE TABLE avaliacoes_curtidas (
  id_usuario INT NOT NULL,
  id_avaliacao INT NOT NULL,
  curtiu BIT NOT NULL,
  descurtiu BIT NOT NULL,
  dt_interacao DATETIME NOT NULL DEFAULT GETDATE()
);
ALTER TABLE avaliacoes_curtidas ADD CONSTRAINT FK_Usuario_AvaliacaoCurtida FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
ALTER TABLE avaliacoes_curtidas ADD CONSTRAINT FK_AvaliacaoCurtida_Usuario FOREIGN KEY (id_avaliacao) REFERENCES avaliacoes(id_avaliacao);
GO

CREATE TABLE carrinho (
  id_usuario INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL
);
ALTER TABLE carrinho ADD CONSTRAINT FK_Produto_Carrinho FOREIGN KEY (id_produto) REFERENCES produtos(id_produto);
ALTER TABLE carrinho ADD CONSTRAINT FK_Usuario_Carrinho FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
GO

CREATE TABLE formas_pagamento (
  id_forma_pagamento TINYINT NOT NULL IDENTITY(1,1),
  nome NVARCHAR(20) NOT NULL,
  PRIMARY KEY (id_forma_pagamento)
);
GO

CREATE TABLE cartoes_pagamento (
  id_cartao_pagamento INT NOT NULL IDENTITY(1,1),
  id_usuario INT NOT NULL,
  numero_cartao CHAR(16) NOT NULL,
  nome_impresso NVARCHAR(20) NOT NULL,
  dt_expiracao CHAR(7) NOT NULL,
  codigo_seguranca INT NOT NULL,
  bandeira NVARCHAR(20) NOT NULL,
  dt_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
  apelido NVARCHAR(30) NULL,
  credito BIT NOT NULL DEFAULT 0,
  debito BIT NOT NULL DEFAULT 0,
  principal BIT NOT NULL,
  PRIMARY KEY (id_cartao_pagamento)
);
ALTER TABLE cartoes_pagamento ADD CONSTRAINT FK_Cartoes_Pagamento_Usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
GO

CREATE TABLE pagamentos (
  id_pagamento INT NOT NULL IDENTITY(1,1),
  id_forma_pagamento TINYINT NOT NULL,
  id_cartao_pagamento INT NULL,
  parcelas TINYINT NULL,
  PRIMARY KEY (id_pagamento)
);
ALTER TABLE pagamentos ADD CONSTRAINT FK_Forma_Pagamento_Pagamento FOREIGN KEY (id_forma_pagamento) REFERENCES formas_pagamento(id_forma_pagamento);
ALTER TABLE pagamentos ADD CONSTRAINT FK_Cartao_Pagamento_Pagamento FOREIGN KEY (id_cartao_pagamento) REFERENCES cartoes_pagamento(id_cartao_pagamento);
GO

CREATE TABLE enderecos (
  id_endereco INT NOT NULL IDENTITY(1,1),
  id_usuario INT NOT NULL,
  nome_endereco NVARCHAR(30) COLLATE Latin1_General_CI_AS NOT NULL,
  cep CHAR(8) NOT NULL,
  logradouro NVARCHAR(50) NOT NULL,
  numero NVARCHAR(7) NOT NULL,
  complemento NVARCHAR(30) NULL,
  bairro NVARCHAR(30) NOT NULL,
  cidade NVARCHAR(60) NOT NULL,
  uf CHAR(2) NOT NULL,
  dt_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
  principal BIT NOT NULL,
  PRIMARY KEY (id_endereco)
);
ALTER TABLE enderecos ADD CONSTRAINT FK_Usuario_Endereco FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
GO

CREATE TABLE favoritos (
  id_usuario INT NOT NULL,
  id_produto INT NOT NULL,
  dt_inclusao DATETIME NOT NULL DEFAULT GETDATE()
);
ALTER TABLE favoritos ADD CONSTRAINT FK_Usuario_ProdutoFavorito FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
ALTER TABLE favoritos ADD CONSTRAINT FK_ProdutoFavorito FOREIGN KEY (id_produto) REFERENCES produtos(id_produto);
GO

CREATE TABLE lojas (
  id_loja SMALLINT NOT NULL IDENTITY(1,1),
  nome NVARCHAR(50) NOT NULL,
  endereco_completo NVARCHAR(100) NOT NULL,
  PRIMARY KEY (id_loja)
);
GO

CREATE TABLE status (
  id_status TINYINT NOT NULL IDENTITY(1,1),
  nome NVARCHAR(25) NOT NULL,
  descricao NVARCHAR(100) NULL,
  PRIMARY KEY (id_status)
);
GO

CREATE TABLE pedidos (
  id_pedido INT NOT NULL IDENTITY(1,1),
  dt_pedido DATETIME NOT NULL DEFAULT GETDATE(),
  subtotal DECIMAL(10,2) NOT NULL,
  frete DECIMAL(5,2) NOT NULL,
  descontos DECIMAL(8,2) NOT NULL,
  total DECIMAL(10,2) NOT NULL,
  id_pagamento INT NULL,
  id_endereco INT NULL,
  id_loja SMALLINT NULL,
  id_status TINYINT NOT NULL,
  dt_entrega DATE NULL,
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_pedido)
);
ALTER TABLE pedidos ADD CONSTRAINT FK_Pagamento_Pedido FOREIGN KEY (id_pagamento) REFERENCES pagamentos(id_pagamento);
ALTER TABLE pedidos ADD CONSTRAINT FK_Endereco_Pedido FOREIGN KEY (id_endereco) REFERENCES enderecos(id_endereco);
ALTER TABLE pedidos ADD CONSTRAINT FK_Loja_Pedido FOREIGN KEY (id_loja) REFERENCES lojas(id_loja);
ALTER TABLE pedidos ADD CONSTRAINT FK_Status_Pedido FOREIGN KEY (id_status) REFERENCES status(id_status);
ALTER TABLE pedidos ADD CONSTRAINT FK_Usuario_Pedido FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);
GO

CREATE TABLE pedidos_produtos (
  id_pedido INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL
);
ALTER TABLE pedidos_produtos ADD CONSTRAINT FK_Pedido_Produto FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido);
ALTER TABLE pedidos_produtos ADD CONSTRAINT FK_Produto_Pedido FOREIGN KEY (id_produto) REFERENCES produtos(id_produto);
GO

CREATE INDEX idx_avaliacoes_usuario ON avaliacoes (id_usuario);
CREATE INDEX idx_avaliacoes_produto ON avaliacoes (id_produto);

CREATE INDEX idx_curtidas_usuario ON avaliacoes_curtidas (id_usuario);
CREATE INDEX idx_curtidas_avaliacao ON avaliacoes_curtidas (id_avaliacao);

CREATE INDEX idx_carrinho_usuario ON carrinho (id_usuario);
CREATE INDEX idx_carrinho_produto ON carrinho (id_produto);

CREATE INDEX idx_favoritos_usuario ON favoritos (id_usuario);
CREATE INDEX idx_favoritos_produto ON favoritos (id_produto);