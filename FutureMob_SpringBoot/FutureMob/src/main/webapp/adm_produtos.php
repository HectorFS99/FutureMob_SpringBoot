<?php
// include '../conexao.php';

// $sql_produtos = mysql_query(
//     "SELECT 
//         `id_produto`,
//         `nome`,
//         `descricao`,
//         `preco_anterior`,
//         `preco_atual`,
//         `altura`,
//         `largura`,
//         `profundidade`,
//         `peso`,
//         `destaque`,
//         `oferta_relampago`,
//         `id_categoria`,
//         `caminho_imagem`,
//         `ativo`
//     FROM 
//         `produtos`;");
?>
<html lang="pt-br">

<head>
    <?php include '/componentes/adm_head.php'; ?>
    <title>Produtos</title>
</head>

<body>
    <?php include '/componentes/adm_header.php'; ?>
    <main class="conteudo-principal">
        <div class="titulo-opcoes">
            <h3 class="titulo">
                <a href="adm_index.php" class="btn-voltar"><i class="fa-solid fa-arrow-left"></i></a>
                Produtos
            </h3>
            <button onclick="window.location.href='cadastro-produto.php'" class="botao btn-adicionar">
                <i class="fa-solid fa-square-plus"></i> Adicionar
            </button>
        </div>
        <div class="table-responsive">
            <table id="tabela-produtos" class="table table-striped">
                <thead>
                    <tr class="tabela-linha">
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Preço anterior</th>
                        <th>Preço atual</th>
                        <th>Destaque?</th>
                        <th>Oferta?</th>
                        <th>Categoria ID</th>
                        <th>Ativo?</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody id="produtos-tbody">
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

    function renderizarProdutos(produtos) {
        const tbody = document.getElementById('produtos-tbody');
        tbody.innerHTML = '';
        produtos.forEach(linha => {
            tbody.innerHTML += `
                    <tr class="tabela-linha">
                <td>${linha.idProduto}</td>
                <td>${limitarNome(linha.nome)}</td>
                <td>R$ ${linha.precoAnterior}</td>
                <td>R$ ${linha.precoAtual}</td>
                <td>${linha.destaque ? 'Sim' : 'Não'}</td>
                <td>${linha.ofertaRelampago ? 'Sim' : 'Não'}</td>
                <td>${linha.categoria ? linha.categoria.idCategoria : ''}</td>
                <td>${linha.ativo ? 'Sim' : 'Não'}</td>
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
        fetch('http://localhost:8080/produtos/todos')
            .then(response => response.json())
            .then(data => renderizarProdutos(data))
            .catch(error => {
                document.getElementById('produtos-tbody').innerHTML = '<tr><td colspan="9">Erro ao carregar produtos.</td></tr>';
            });

        transformarTabela('#tabela-produtos');
    });
</script>

</html>