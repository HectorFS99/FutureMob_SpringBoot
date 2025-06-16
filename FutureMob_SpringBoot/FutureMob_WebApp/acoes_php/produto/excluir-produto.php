<?php
    if (isset($_GET['apagar'])) {
        $id = $_GET['apagar'];
        $url = "http://localhost:8080/produtos/$id"; // ajuste se necessário

        $ch = curl_init($url);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

        $response = curl_exec($ch);
        $httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        curl_close($ch);

        if ($httpcode == 200 || $httpcode == 204) {
            echo "
                <script>
                    alert('Produto excluído com sucesso!');
                    window.location.href = '../../adm_produtos.php';
                </script>
            ";
        } else {
            echo "
                <script>
                    alert('Ocorreu um erro ao excluir o produto. Código HTTP: $httpcode');
                    window.location.href = '../../adm_produtos.php';
                </script>
            ";
        }
    } else {
        echo "
            <script>
                alert('Ocorreu um erro, tente novamente');
                window.location.href = '../../adm_categorias.php';
            </script>
        ";
    }
?>