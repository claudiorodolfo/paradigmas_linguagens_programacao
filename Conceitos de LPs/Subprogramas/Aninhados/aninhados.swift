func funcaoExterna() {
    print("Esta é a função externa.")

    func funcaoInterna() {
        print("Esta é a função interna.")
    }

    funcaoInterna()  // Chama a função interna
}

funcaoExterna()  // Chama a função externa
