package Enumerations

enum EstadoEquipamentoEnum {

    ALOCADO ('Alocado', 1),
    STOCK_NOVO ('Novo em stock', 2),
    STOCK_BOM ('Bom em stock', 3),
    STOCK_AVARIADO ('Avariado em stock', 4),
    PATRIMONIO_BOM ('Bom em patrimonio', 5),
    PATRIMONIO_AVARIADO ('Avariado em patrimonio', 6),
    REPARACAO ('Reparacao', 7);

    String nome;
    Integer codigo;

    EstadoEquipamentoEnum(String nome, Integer codigo ) {
        this.nome = nome
        this.codigo = codigo
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    Integer getCodigo() {
        return codigo
    }

    void setCodigo(Integer codigo) {
        this.codigo = codigo
    }
}