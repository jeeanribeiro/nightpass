const mongoose = require('mongoose');
const ProdutoSchema = new mongoose.Schema({

    prd_codigo: {
        type: Number,
        required: true
    },

    prd_nome:{
        type: String,
        required: true
    },

    prd_marca: {
        type: String,
        required: true
    },

    prd_descricao:{
        type: String,
        required: true
    },
    prd_preco: {
        type: Number,
        required: true
    },
    t_estabeleci_est_codigo:{
        type: Number,
        required: true
    },
    prd_formato:{
        type: String,
        required: true
    }
});
mongoose.model('Produtos', ProdutoSchema);

module.exports = mongoose.model('Produtos');

