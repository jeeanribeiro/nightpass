import { Component, OnInit } from '@angular/core';
import {Produto} from '../../models/Produto';
import {ProdutoService} from '../providers/produto.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-list-produtos',
  templateUrl: './list-produtos.component.html',
  styleUrls: ['./list-produtos.component.scss']
})

export class ListProdutosComponent implements OnInit {

  produto = {} as Produto;

  produtos: Produto[];

  constructor(private produtoService: ProdutoService) {}

 ngOnInit() {

    this.getProdutos();
    
  }

  getProdutos(){

    this.produtoService.getProduto().subscribe((produtos: Produto[]) => {

      this.produtos = produtos;
    
    });
  }

}
