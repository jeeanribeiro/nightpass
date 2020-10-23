import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoModel } from '../../models/Produto';
import { catchError, map } from 'rxjs/operators';
import { from, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProdutoService {

  url: string = 'http://localhost:8091/produtos';

  constructor(private http: HttpClient) { }

  getAll(): Observable<ProdutoModel[]> {

   console.log('inicio');

  return this.http.get<ProdutoModel[]>(this.url)
    .pipe(map(data =>
      data.map((produto) => new ProdutoModel(
        produto.prd_codigo,
        produto.prd_nome,
        produto.prd_marca,
        produto.prd_descricao,
        produto.prd_preco,
        produto.t_estabeleci_est_codigo,
        produto.prd_formato,
        produto.prd_imgpath,
      ))
    )
   );
  }

}


