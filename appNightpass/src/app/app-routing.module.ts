import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListProdutosComponent} from './list-produtos/list-produtos.component';

const routes: Routes = [

  {path: '', component: ListProdutosComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
