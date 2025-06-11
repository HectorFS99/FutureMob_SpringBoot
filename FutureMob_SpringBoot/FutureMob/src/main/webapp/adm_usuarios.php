<?php
//     include '../conexao.php';

//     $sql_usuarios = mysql_query(
//         "SELECT 
//             `id_usuario`
//             , `nome_completo`
//             , `cpf`
//             , `rg`
//             , `dt_nascimento`
//             , `sexo`
//             , `telefone_celular`
//             , `email`
//             , `senha`
//             , `admin` 
//         FROM
//             `usuarios`");
// ?>
<html lang="pt-br">
    <head>
        <?php include '/componentes/adm_head.php'; ?>
        <title>Usuários</title>
    </head>
    <body>
        <?php include '/componentes/adm_header.php'; ?>
        <main class="conteudo-principal">
            <div class="titulo-opcoes">
                <h3 class="titulo">
                    <a href="adm_index.php" class="btn-voltar"><i class="fa-solid fa-arrow-left"></i></a>
                    Usuários
                </h3>
                <button onclick="window.location.href='../cadastro.php'" class="botao btn-adicionar">
                    <i class="fa-solid fa-square-plus"></i> Adicionar
                </button>
            </div>
            <div class="table-responsive">
                <table id="tabela-usuarios" class="table table-striped">
                    <!-- Cabeçalho da tabela -->
                    <thead>
                        <tr class="tabela-linha">
                            <th>ID</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>RG</th>
                            <th>Dt. Nasc.</th>
                            <th>Sexo</th>
                            <th>Tel. Celular</th>
                            <th>E-mail</th>
                            <th>É admin.?</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <!-- Corpo da tabela -->
                    <tbody id="usuarios-tbody">
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

    function renderizarUsuarios(usuarios) {
        const tbody = document.getElementById('usuarios-tbody');
        tbody.innerHTML = '';
        usuarios.forEach(linha => {
            tbody.innerHTML += `
                    <tr class="tabela-linha">
                <td>${linha.idUsuario}</td>
                <td>${limitarNome(linha.nomeCompleto)}</td>
                <td>${linha.cpf}</td>
                <td>${linha.rg}</td>
                <td>${linha.dataNascimento}</td>
                <td>${linha.sexo}</td>
                <td>${linha.telefoneCelular}</td>
                <td>${linha.email}</td>
                <td>${linha.admin}</td>
                <td>${linha.caminhoImgPerfil}</td>
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
        fetch('http://localhost:8080/Usuarios/todos')
            .then(response => response.json())
            .then(data => renderizarUsuarios(data))
            .catch(error => {
                console.log(error)
                document.getElementById('usuarios-tbody').innerHTML = '<tr><td colspan="9">Erro ao carregar usuarios.</td></tr>';
            });

        transformarTabela('#tabela-usuarios');
    }); 

    </script>
</html>