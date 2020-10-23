export class ProdutoModel{

    constructor(
        public prd_codigo: Number,
        public prd_nome: String,
        public prd_marca: String,
        public prd_descricao: String,
        public prd_preco: Number,
        public t_estabeleci_est_codigo: Number,
        public prd_formato: String,
        public prd_imgpath: String,
    ) {}

}