USE future_mob;
go


SET IDENTITY_INSERT "usuarios" ON ;
INSERT INTO "usuarios" ("id_usuario", "nome_completo", "cpf", "rg", "dt_nascimento", "sexo", "telefone_celular", "email", "senha", "admin", "caminho_img_perfil") VALUES
(3, 'Hector Ferreira da Silva', '971.460.900', '97.146.09', '1999-03-19', 'M', '(11) 94577-6737', 'hector.silva5@fatec.sp.gov.br', 'TesteSenha987_', 1, 'recursos/imagens/usuarios/hector.jpg'),
(9, 'Enzo Dionisio Ribeiro da Silva', '320.473.040', '79.073.21', '2002-01-01', 'M', '(11) 94826-9227', 'enzo.silva9@fatec.sp.gov.br', 'Projeto10@', 1, 'recursos/imagens/usuarios/enzo.jpg\n'),
(11, 'Ellen Eufrasio de Oliveira', '986.295.120', '79.073.21', '2004-03-19', 'F', '(11) 95919-2165', 'ellen.oliveira12@fatec.sp.gov.br', 'Ellen.oliveira12', 1, 'recursos/imagens/usuarios/ellen.jpg\n'),
(12, 'Henrique Nery Cordeiro', '085.659.930', '78.645.15', '1999-01-01', 'M', '(11) 96839-7016', 'henrique.cordeiro2@fatec.sp.gov.br', 'Henrique.cordeiro2', 1, 'recursos/imagens/usuarios/henrique.jpg\n'),
(13, 'João Pedro Garcia', '728.777.110', '72.877.71', '1999-01-01', 'M', '(11) 97698-2816', 'joao.garcia27@fatec.sp.gov.br', 'Joao.garcia27', 1, 'recursos/imagens/usuarios/joao.jpg\n'),
(14, 'Diogo Peres Martins', '932.141.230', '93.214.12', '2005-01-01', 'M', '(11) 93249-4538', 'diogo.martins5@fatec.sp.gov.br', 'Diogo.martins5', 1, 'recursos/imagens/usuarios/diogo.jpg\n'),
(15, 'Monquidesia de Cordeiro', '135.647.800', '13.564.78', '2004-01-01', 'F', '(11) 13564-7800', 'monquidesia.cordeiro5@fatec.sp.gov.br', 'Monquidesia.cordeiro5', 0, NULL);
SET IDENTITY_INSERT "usuarios" OFF;


SET IDENTITY_INSERT "cartoes_pagamento" ON ;
INSERT INTO "cartoes_pagamento" ("id_cartao_pagamento", "id_usuario", "numero_cartao", "nome_impresso", "dt_expiracao", "codigo_seguranca", "bandeira", "dt_cadastro", "apelido", "credito", "debito", "principal") VALUES
(3, 3, '9876543210123654', 'HECTOR DA SILVA', '12/2029', 9784, 'MasterCard', GETDATE(), 'Cartão do Hector', 0, 0, 0),
(4, 3, '8974865351320315', 'jhfdfsdsf', '12/2028', 4655, 'MasterCard', GETDATE(), 'Cartão do Hector', 0, 1, 0),
(5, 3, '6849846512649848', 'NUBIA OLIVIA', '08/2027', 5836, 'MasterCard', GETDATE(), 'Cartão da mãe', 1, 0, 0),
(6, 3, '1235648949865615', 'NESTOR JOSE', '12/2034', 4524, 'MasterCard', GETDATE(), 'Cartão do pai', 1, 0, 0),
(7, 3, '5687777777777777', 'TESTE', '12/2036', 653, 'MasterCard', GETDATE(), 'Cartão do Hector', 1, 0, 0),
(8, 3, '1234567894564987', 'HECTOR F DA SILVA', '08/2026', 989, 'MasterCard', GETDATE(), 'Cartão do Hector', 1, 0, 1),
(9, 3, '8789855556451212', 'JOANA F MAE', '12/2026', 446, 'MasterCard', GETDATE(), 'Cartão da Mãe Joana', 1, 0, 0);
SET IDENTITY_INSERT "cartoes_pagamento" OFF;


SET IDENTITY_INSERT "categorias" ON ;
INSERT INTO "categorias" ("id_categoria", "nome", "descricao", "caminho_icone") VALUES
(1, 'Escritório', 'Móveis de qualidade para o seu escritório!', 'recursos/imagens/icones/escritorio.svg'),
(2, 'Quarto', 'Conforto e elegância para o seu quarto!', 'recursos/imagens/icones/quarto.svg'),
(3, 'Cozinha', 'A combinação perfeita entre sofisticação e culinária!', 'recursos/imagens/icones/cozinha.svg'),
(4, 'Sala de Jantar', 'Que tal ter as suas refeições em um ambiente elegante, dentro da sua casa?', 'recursos/imagens/icones/saladejantar.svg'),
(5, 'Área Externa', 'A beleza e as cores presentes em nossas criações combinam perfeitamente com o seu jardim!', 'recursos/imagens/icones/areaexterna.svg'),
(6, 'Sala de Estar', 'A elegância e o aconchego na sua sala de estar!', 'recursos/imagens/icones/saladeestar.svg');
SET IDENTITY_INSERT "categorias" OFF;


SET IDENTITY_INSERT "enderecos" ON ;
INSERT INTO "enderecos" ("id_endereco", "id_usuario", "nome_endereco", "cep", "logradouro", "numero", "complemento", "bairro", "cidade", "uf", "dt_cadastro", "principal") VALUES
(1, 3, 'Casa do Hector', '02036-02', 'Rua Duarte de Azevedo', '2984', 'Apto. 4987', 'Santana', 'São Paulo', 'SP', GETDATE(), 1),
(2, 3, 'Casa do Pai', '01027001', 'Rua Paula Sousa', '105', 'Apto. 42', 'Centro', 'São Paulo', 'SP', GETDATE(), 0),
(3, 3, 'Casa da Esther', '01027001', 'Rua Paula Sousa', '105', 'Apto. 9897', 'Centro', 'São Paulo', 'SP', GETDATE(), 0);
SET IDENTITY_INSERT "enderecos" OFF;


SET IDENTITY_INSERT "produtos" ON ;
INSERT INTO "produtos" ("id_produto", "nome", "descricao", "preco_anterior", "preco_atual", "altura", "largura", "profundidade", "peso", "destaque", "oferta_relampago", "id_categoria", "caminho_imagem", "ativo", "dt_cadastro") VALUES
(39, 'Luminária Rosa', 'Luminária Rosa, com detalhes em Ouro Rosa', '1999.00', '1299.00', '40.00', '40.00', '40.00', '3.00', 0, 0, 2, 'recursos/imagens/produtos/escritorio-luminaria_rosa.jpg', 1, GETDATE()),
(40, 'Mesa para sala de Reuniões ', 'Mesa para sala de Reuniões Suspensa com tampo de vidro.', '2999.00', '1999.00', '75.00', '173.00', '300.00', '60.00', 0, 0, 1, 'recursos/imagens/produtos/escritorio-mesa_reuniao_tampo_vidro.jpg', 1, GETDATE()),
(41, 'Sofá Moderno - Verde Musgo', 'Sofá de design inovador com assentos flutuantes e apoio de braço integrado.', '5000.00', '3500.00', '85.00', '200.00', '90.00', '75.00', 1, 0, 6, 'recursos/imagens/produtos/sofa_flutuante.jpg', 1, GETDATE()),
(42, 'Mesa de Jantar Lunar', 'Mesa de jantar com tampo de vidro curvo e base em metal polido.', '4500.00', '3000.00', '75.00', '200.00', '120.00', '50.00', 1, 1, 3, 'recursos/imagens/produtos/mesa_jantar_lunar.jpg', 1, GETDATE()),
(43, 'Cadeira Vortex', 'Cadeira ergonômica com design futurista e material respirável.', '1200.00', '800.00', '100.00', '60.00', '70.00', '15.00', 0, 0, 1, 'recursos/imagens/produtos/cadeira_vortex.jpg', 1, GETDATE()),
(44, 'Estante Modular', 'Estante com módulos ajustáveis e iluminação LED embutida.', '3000.00', '2200.00', '180.00', '100.00', '40.00', '40.00', 1, 0, 6, 'recursos/imagens/produtos/estante_modular.jpg', 1, GETDATE()),
(45, 'Luminária Galaxy', 'Luminária de mesa com design galáctico e controle touch.', '1500.00', '950.00', '40.00', '30.00', '30.00', '5.00', 0, 1, 1, 'recursos/imagens/produtos/luminaria_orion.jpg', 1, GETDATE()),
(46, 'Sofá Inteligente', 'Sofá com tecnologia de massagem integrada e ajuste de posição.', '7000.00', '5000.00', '90.00', '220.00', '100.00', '80.00', 1, 0, 6, 'recursos/imagens/produtos/sofa_inteligente.jpg', 1, GETDATE()),
(47, 'Mesa Gamer Galáctica', 'Mesa com design fluido e iluminação RGB ajustável.', '6000.00', '4000.00', '75.00', '250.00', '120.00', '60.00', 1, 1, 4, 'recursos/imagens/produtos/mesa_jantar_galactica.jpg', 1, GETDATE()),
(48, 'Cadeira Ergonômica 3D', 'Cadeira com suporte lombar ajustável e materiais respiráveis.', '1800.00', '1200.00', '100.00', '65.00', '70.00', '18.00', 0, 0, 1, 'recursos/imagens/produtos/cadeira_ergonomica_3d.jpg', 1, GETDATE()),
(49, 'Estante Suspensa', 'Estante com prateleiras flutuantes e sistema de iluminação embutido.', '3500.00', '2500.00', '180.00', '80.00', '30.00', '30.00', 1, 0, 6, 'recursos/imagens/produtos/estante_suspensa.jpg', 1, GETDATE()),
(50, 'Luminária Solar', 'Luminária de piso com painel solar e controle remoto.', '2000.00', '1300.00', '150.00', '40.00', '40.00', '10.00', 0, 1, 5, 'recursos/imagens/produtos/luminaria_solar.jpg', 1, GETDATE());
SET IDENTITY_INSERT "produtos" OFF;


INSERT INTO "favoritos" ("id_usuario", "id_produto", "dt_inclusao") VALUES
(3, 39, GETDATE()),
(3, 40, GETDATE());


SET IDENTITY_INSERT "formas_pagamento" ON ;
INSERT INTO "formas_pagamento" ("id_forma_pagamento", "nome") VALUES
(1, 'Pix'),
(2, 'Cartão de Crédito'),
(3, 'Cartão de Débito');
SET IDENTITY_INSERT "formas_pagamento" OFF;


SET IDENTITY_INSERT "lojas" ON ;
INSERT INTO "lojas" ("id_loja", "nome", "endereco_completo") VALUES
(1, 'FutureMob - Shopping Iguatemi Alphaville', 'Al. Rio Negro, 111 - Alphaville Industrial, Barueri - SP, 06455-030'),
(2, 'FutureMob - Jardim América', 'Alameda Gabriel Monteiro da Silva, 949 - Jardim America, São Paulo - SP, 01441-002'),
(3, 'FutureMob - Jardim Europa', 'Av. Europa, 158 - Jardim Europa, São Paulo - SP, 01449-000');
SET IDENTITY_INSERT "lojas" OFF;


SET IDENTITY_INSERT "pagamentos" ON ;
INSERT INTO "pagamentos" ("id_pagamento", "id_forma_pagamento", "id_cartao_pagamento", "parcelas") VALUES
(15, 1, NULL, NULL),
(16, 1, NULL, NULL),
(17, 3, 6, 7),
(18, 1, NULL, NULL),
(19, 2, 8, 10),
(20, 1, NULL, NULL),
(21, 2, 8, 6);
SET IDENTITY_INSERT "pagamentos" OFF;


SET IDENTITY_INSERT "status" ON ;
INSERT INTO "status" ("id_status", "nome", "descricao") VALUES
(1, 'Pedido Realizado', 'O pedido foi realizado com sucesso e está aguardando confirmação.'),
(2, 'Aguardando Pagamento', 'O pedido foi registrado e está aguardando o pagamento.'),
(3, 'Pagamento Confirmado', 'O pagamento foi confirmado e o pedido está em processamento.'),
(4, 'Em Separação', 'O pedido está em processo de separação e preparo para envio.'),
(5, 'Enviado', 'O pedido foi enviado e está a caminho do cliente.'),
(6, 'Entregue', 'O pedido foi entregue ao cliente.'),
(7, 'Cancelado', 'O pedido foi cancelado, e não será processado.'),
(8, 'Devolvido', 'O pedido foi devolvido pelo cliente após a entrega.');
SET IDENTITY_INSERT "status" OFF;


SET IDENTITY_INSERT "pedidos" ON ;
INSERT INTO "pedidos" ("id_pedido", "dt_pedido", "subtotal", "frete", "descontos", "total", "id_pagamento", "id_endereco", "id_loja", "id_status", "dt_entrega", "id_usuario") VALUES
(34, GETDATE(), '1299.00', '9.99', '0.00', '1308.99', 15, 1, NULL, 6, NULL, 3),
(35, GETDATE(), '1999.00', '9.99', '0.00', '2008.99', 16, 3, NULL, 5, NULL, 3),
(36, GETDATE(), '6500.00', '9.99', '0.00', '6509.99', 17, NULL, 1, 1, NULL, 3),
(37, GETDATE(), '3000.00', '9.99', '0.00', '3009.99', 18, 1, NULL, 1, NULL, 3),
(38, GETDATE(), '11000.00', '9.99', '0.00', '11009.99', 19, 3, NULL, 1, NULL, 3),
(39, GETDATE(), '9798.00', '9.99', '0.00', '9807.99', 20, NULL, 2, 1, NULL, 3),
(40, GETDATE(), '6950.00', '9.99', '0.00', '6959.99', 21, NULL, 2, 1, NULL, 3);
SET IDENTITY_INSERT "pedidos" OFF;


INSERT INTO "pedidos_produtos" ("id_pedido", "id_produto", "quantidade") VALUES
(34, 39, 1),
(35, 40, 1),
(36, 41, 1),
(36, 42, 1), 
(37, 43, 1),
(37, 44, 1),
(38, 41, 1),
(38, 46, 1),
(38, 48, 1),
(38, 50, 1),
(39, 41, 1),
(39, 42, 1),
(39, 40, 1),
(39, 39, 5),
(40, 41, 1),
(40, 45, 1),
(40, 49, 1);