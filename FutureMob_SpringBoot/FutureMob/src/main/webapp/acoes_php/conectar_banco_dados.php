<?php
    $servidor = "localhost\DESKTOP-FHBAJ3H";  // ou IP + nome da instância, ex: "localhost\SQLEXPRESS"
    $usuario = "FutureMob";
    $senha = "futuro";
    $banco = "future_mob";

    // Parâmetros de conexão
    $connectionInfo = array("Database"=>$banco, "UID"=>$usuario, "PWD"=>$senha);

    // Conecta ao SQL Server
    $conecta_db = sqlsrv_connect($servidor, $connectionInfo);

    if (!$conecta_db) {
        die(print_r(sqlsrv_errors(), true));
    } else {
        echo "Conexão bem-sucedida!";
    }
?>
