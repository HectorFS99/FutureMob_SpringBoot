<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <?php include '/componentes/adm_head.php'; ?>
        <link rel="stylesheet" href="recursos/css/adm_categorias.css" />
        <title>Adicionar Categoria</title>
    </head>
    <body>
        <?php include '/componentes/adm_header.php'; ?>
        <main class="conteudo-principal">
            <div class="titulo-opcoes">
                <h3 class="titulo">
                    <a href="adm_categorias.php" class="btn-voltar"><i class="fa-solid fa-arrow-left"></i></a>
                    Nova Categoria
                </h3>
            </div>
            <form method="POST" id="form_cad_categoria" name="form_cad_categoria" class="formulario w-100" onsubmit="adicionarRegistro(event, 'form_cad_categoria', 'http://localhost:8080/categorias/criar', '/adm_categorias.php');">
                <!-- Nome, Descrição e Ícone -->
                <div class="formulario-grupo">
                    <div class="form-floating">
                        <input name="nome" type="text" required class="form-control" placeholder="Nome completo">
                        <label for="nome">Nome:</label>
                    </div>
                    <div class="form-floating">
                        <input name="caminhoIcone" type="text" required class="form-control" placeholder="Nome completo">
                        <label for="caminhoIcone">Ícone da Categoria:</label>
                    </div>
                </div>
                <div class="form-floating">
                    <textarea name="descricao" required class="form-control" rows="6" placeholder="Nome completo"></textarea>
                    <label for="descricao">Descrição:</label>
                </div>
                <div class="form-botoes">
                    <button onclick="window.location.href='adm_categorias.php'" class="botao form-btn btn-cancelar">Cancelar</button>
                    <button onclick="document.form_cad_categoria.action='acoes_php/categoria/adicionar-categoria.php'" type="submit" value="Cadastrar" class="botao form-btn btn-confirmar">Confirmar</button>
                </div>
            </form>
        </main>
    </body>
</html>