<?php
   	header('Content-Type: text/html; charset=utf-8');
   // include '../conexao.php';

    // $sql_categoria = mysql_query(
//         "SELECT 
//             `id_categoria`,
//             `nome`,
//             `descricao`,
//             `caminho_icone`
//         FROM 
//             `categorias`;");
// ?>
<html lang="pt-br">
    <head>
        <?php include '/componentes/adm_head.php'; ?>
        <title>Categorias</title>
    </head>
    <body>
        <?php include '/componentes/adm_header.php'; ?>
        <main class="conteudo-principal">
            <div class="titulo-opcoes">
                <h3 class="titulo">
                    <a href="adm_index.php" class="btn-voltar"><i class="fa-solid fa-arrow-left"></i></a>
                    Categorias
                </h3>
                <button onclick="window.location.href= 'cadastro-categoria.php'" class="botao btn-adicionar">
                    <i class="fa-solid fa-square-plus"></i> Adicionar
                </button>
            </div>
            <div class="table-responsive">
                <table id="tabela-categoria" class="table table-striped">
                    <!-- Cabeçalho da tabela -->
                    <thead>
                        <tr class="tabela-linha">
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Ícone</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <!-- Corpo da tabela -->
                    <tbody id="categorias-tbody">
                    <!-- Conteúdo será preenchido via JS -->
                    </tbody>
                </table>               
            </div>
        </main>
    </body>
    <script>

        // Função para limitar o nome a 30 caracteres
    function limitarNome(nome) {
        return nome.length > 30 ? nome.substring(0, 30) + "..." : nome;
    }

    function renderizarCategorias(categorias) {
        const tbody = document.getElementById('categorias-tbody');
        tbody.innerHTML = '';
        categorias.forEach(linha => {
            tbody.innerHTML += `
                    <tr class="tabela-linha">
                <td>${linha.idCategoria}</td>
                <td>${limitarNome(linha.nome)}</td>
                <td>${linha.descricao}</td>
                <td>${linha.caminhoIcone}</td>
                <td>
                    <div class="d-flex align-items-center justify-content-between">
                        <a class="btn-tabela btn-excluir" href="acoes_php/produto/excluir-produto.php?apagar=${linha.idProduto}">
                            <i class="fa-solid fa-trash-can"></i>
                        </a>
                        <a class="btn-tabela btn-editar" href="edicao-produto.php?id_produto=${linha.idProduto}">
                            <i class="fa-solid fa-pen"></i>
                        </a>
                            </div>
                        </td>
                    </tr>
                `;
        });
    }

    document.addEventListener('DOMContentLoaded', function () {
        fetch('http://localhost:8080/categorias/todos')
            .then(response => response.json())
            .then(data => renderizarCategorias(data))
            .catch(error => {
                document.getElementById('categorias-tbody').innerHTML = '<tr><td colspan="9">Erro ao carregar categorias.</td></tr>';
            });

        transformarTabela('#tabela-categoria');
    }); 

    </script>
</html>