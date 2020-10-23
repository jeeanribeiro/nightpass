import { Component, OnInit } from '@angular/core';
import { ProdutoModel } from '../../models/Produto';
import { ProdutoService } from '../providers/produto.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-produtos',
  templateUrl: './list-produtos.component.html',
  styleUrls: ['./list-produtos.component.scss']
})

export class ListProdutosComponent implements OnInit {

  produtos$: Observable<ProdutoModel[]>

  constructor(private produtoservice: ProdutoService) {}

 ngOnInit() {
   
  this.produtos$ = this.produtoservice.getAll()

}

}
