const express = require('express');
const app = express();
const mongoose = require('mongoose');
const cors = require('cors');

//Importação do Shema Produto
const Produto = require('./models/Produtomodel');
const { produtos } = require('./Produto');


//Database Mongo

mongoose.Promise = global.Promise;

/*Conexão com base local

mongoose.connect('mongodb://localhost:27017/nightpass', {
    useNewUrlParser: true,
    useUnifiedTopology: true
})

*/

mongoose.connect('mongodb+srv://nightpassusr:Grupofiap2020@nightpassclt.nyxh4.mongodb.net/test', 
{
    useNewUrlParser: true,
    useUnifiedTopology: true
})

.then(() => console.log("MongoDB conectado"))
.catch((err) => console.error("Erro ao conectar com o MongoDB "+err))


//Midlewares

app.use(express.json())
app.use(express.urlencoded({extended: true}))

// POST Produto (cria um novo produto)
app.post('/produto', function (req, res) {
    
    const data = req.body;
    if (!data) {
        console.log('inclusão erro');
        res.sendStatus(400);
    }

    console.log('inclusão ok');

    new Produto(data).save()
        .then(() => res.sendStatus(201))
        .catch(() => res.sendStatus(400))
});

// Retorna todos os produtos na base
app.get('/produtos', cors(),  function( req, res){

    Produto.find()
        .then((produtos) => res.send(produtos))
        .catch(() => res.sendStatus(400));

})

//retorna o produto por ID
app.get('/produto/:id', function(req, res) {

    const produtoId = req.params.id;
    Produto.findById(produtoId)
        .then((produto) => res.send(produto))
        .catch(() => res.sendStatus(400));

});

//atualiza os dados de um produto

app.put('/produto/:id', function(req, res) {

    const data = req.body;
    const produtoId = req.params.id;

    if (!data || !produtoId) {
        res.sendStatus(400)
    }

        Produto.findByIdAndUpdate(produtoId, data).setOptions({new:false})
        .then(() => res.sendStatus(200))
        .catch(() => res.sendStatus(400))

});

//Deleta um produto pelo ID
app.delete('/produto/:id', function(req, res){

    const produtoId = req.params.id;

    Produto.findByIdAndRemove(produtoId)
        .then(() => res.sendStatus(200))
        .catch(() => res.sendStatus(400))
});


app.listen(8091, () => {
    console.log('Servidor rodando em http://localhost:8091, local');
    console.log('Ou na núvem pelo mongo Atlas conforme configuração');
})










