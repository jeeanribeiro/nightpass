import { Component, OnInit } from '@angular/core';
import {Produto} from '../../models/Produto';


@Component({
  selector: 'app-list-produtos',
  templateUrl: './list-produtos.component.html',
  styleUrls: ['./list-produtos.component.scss']
})

export class ListProdutosComponent implements OnInit {

  produto: Produto[] = [];

  constructor() {


    const novoProduto = new Produto(
      1542,
      'Coca Cola',
      'Coca Cola 2',
      'Bebida Gaseificada',
      10.0,
      101,
      'Lata'
    );

    for (let i = 0; i <3; i++) {

      this.produto.push(novoProduto);

    }

  }

 ngOnInit() {
   

 }

}
