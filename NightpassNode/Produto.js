class Produto{

    constructor(
        PRD_CODIGO,
        PRD_NOME,
        PRD_MARCA,
        PRD_DESCRICAO,
        PRD_PRECO,
        T_ESTABELECI_EST_CODIGO,
        PRD_FORMATO
    ){

        this.PRD_CODIGO = PRD_CODIGO
        this.PRD_NOME = PRD_NOME
        this.PRD_MARCA = PRD_MARCA
        this.PRD_DESCRICAO = PRD_DESCRICAO
        this.PRD_PRECO = PRD_PRECO
        this.T_ESTABELECI_EST_CODIGO = T_ESTABELECI_EST_CODIGO
        this.PRD_FORMATO = PRD_FORMATO

    }

}

const produtos = [
    new Produto(108, 'Cerveja Skol', 'Skol', 'Cerveja Skol', 6.02, 101, 'Lata 360 ml'),
    new Produto(109, 'PORÇÃO DE BATA FRITA', 'PRÓPRIA', 'PORÇÃO DE BATA FRITA', 29.72, 101, 'PORÇÃO'),
    new Produto(115, 'Combo Balde com 5 un Cerveja Stella', 'Stella', 'Balde com 5 garrafas de Cerveja Long Neck Stella', 69.43, 101, 'Garrafa 330 ml')
];

function getAll() {
    return produtos;
}

function create ( PRD_CODIGO,
    PRD_NOME,
    PRD_MARCA,
    PRD_DESCRICAO,
    PRD_PRECO,
    T_ESTABELECI_EST_CODIGO,
    PRD_FORMATO,
    PRD_IMGPATH ) {

        produtos.push(
            new Produto(PRD_CODIGO,PRD_NOME,PRD_MARCA,PRD_DESCRICAO,
                PRD_PRECO,T_ESTABELECI_EST_CODIGO,PRD_FORMATO,PRD_IMGPATH)
        )

    }

function getbyid (idproduto) {

    return produtos[idproduto];
        
}
    
    function update(PRD_CODIGO,
        PRD_NOME,
        PRD_MARCA,
        PRD_DESCRICAO,
        PRD_PRECO,
        T_ESTABELECI_EST_CODIGO,
        PRD_FORMATO,
        PRD_IMGPATH,
        idproduto) {

            if (produtos[idproduto] != null){

                produtos[idproduto].PRD_CODIGO = PRD_CODIGO;
                produtos[idproduto].PRD_NOME = PRD_NOME;
                produtos[idproduto].PRD_MARCA = PRD_MARCA;
                produtos[idproduto].PRD_DESCRICAO = PRD_DESCRICAO;
                produtos[idproduto].PRD_PRECO = PRD_PRECO;
                produtos[idproduto].T_ESTABELECI_EST_CODIGO = T_ESTABELECI_EST_CODIGO;
                produtos[idproduto].PRD_FORMATO = PRD_FORMATO;
                produtos[idproduto].PRD_IMGPATH = PRD_IMGPATH;
            }

        }

    function deleteProduto (idproduto) {

        produtos.splice(idproduto,1);

    }

module.exports.produtos = produtos;
module.exports.create = create;
module.exports.getAll = getAll;
module.exports.deleteProduto = deleteProduto
module.exports.getbyid = getbyid;
module.exports.update = update;

