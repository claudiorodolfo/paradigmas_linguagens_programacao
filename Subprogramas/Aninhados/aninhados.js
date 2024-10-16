//JavaScript
function funcaoExterna() {
    console.log("Esta é a função externa.");

    function funcaoInterna() {
        console.log("Esta é a função interna.");
    }

    funcaoInterna();  // Chama a função interna
}

funcaoExterna();  // Chama a função externa
