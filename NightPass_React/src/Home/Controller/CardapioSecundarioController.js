/* eslint-disable no-alert */
import React, {useCallback} from 'react';
import {View} from 'react-native';
import CardapioSecundarioView from '../View/CardapioSecundarioView';

let tempPedido = new Array();

let arrayMenuPorcao = new Array();

class CardapioSecundarioController extends React.Component {
  constructor() {
    super();

    let arrayMenuSec = new Array();

    arrayMenuSec.push({
      id: 'Cerveja',
      sel: true,
    });

    arrayMenuSec.push({
      id: 'Vodka',
      sel: false,
    });

    arrayMenuSec.push({
      id: 'Saquê',
      sel: false,
    });

    arrayMenuSec.push({
      id: 'Tequila',
      sel: false,
    });

    arrayMenuSec.push({
      id: 'Whisk',
      sel: false,
    });

    arrayMenuSec.push({
      id: 'Caipirinha',
      Sel: false,
    });

    //No state devem ser declaradas as váriaveis para uso no app.
    this.state = {
      aMenuSec: arrayMenuSec,
      aSubItem: new Array(),
      aPedido: new Array(),
    };
  }

  //No state devem ser declaradas as váriaveis para uso no app.

  atualizaItem(prd_codigo, aumento = Boolean) {
    let aSubItemN = this.state.aSubItem;
    console.log(aumento);

    let nVar;

    if (aumento === true) {
      aSubItemN.find((x) => x.prd_codigo === prd_codigo).prd_quant++;
    } else {
      aSubItemN.find((x) => x.prd_codigo === prd_codigo).prd_quant--;
    }

    this.setState({aSubItem: aSubItemN});
  }

  //Armazena no Array temporário os items para montar o pedido efetivo
  atualizaPedido(prd_codigo, prd_quant, prd_nome) {
    tempPedido.push({
      prd_codigo: prd_codigo,
      prd_quant: prd_quant,
      prd_nome: prd_nome,
    });
  }

  verPedido() {
    let msgPedido = '';

    //alert(tempPedido.length);

    for (let i = 0; i < tempPedido.length; i++) {
      msgPedido =
        msgPedido +
        ' ' +
        tempPedido[i].prd_nome +
        ' - Quant: ' +
        tempPedido[i].prd_quant +
        String.fromCharCode(10);
    }

    alert(msgPedido);
  }

  criaSubMenu() {
    let {aSubItem} = this.state;

    aSubItem.length = 0;

    aSubItem.push({
      prd_codigo: 10800,
      prd_nome: 'Cerveja Skol',
      prd_formato: 'Lata 360 ml',
      prd_preco: '6,02',
      prd_image:
        'https://firebasestorage.googleapis.com/v0/b/nightpass-2020.appspot.com/o/Cerveja-Skol-Lata.jpg?alt=media&token=1889d45d-0c6a-457d-b1df-ce12d7d906e9',
      prd_quant: 0,
    });

    aSubItem.push({
      prd_codigo: 1150,
      prd_nome: 'Combo Balde com 5 un Cerveja Stella',
      prd_formato: 'Garrafa 330 ml',
      prd_preco: '69,43',
      prd_image:
        'https://firebasestorage.googleapis.com/v0/b/nightpass-2020.appspot.com/o/balde-de-gelo-stella-artois-para.webp?alt=media&token=b0e73354-3bff-4e8f-8e70-8e8a1e063367',
      prd_quant: 0,
    });

    aSubItem.push({
      prd_codigo: 1151,
      prd_nome: 'Cerveja Stella Long Neck',
      prd_formato: 'Garrafa 330 ml',
      prd_preco: '8,50',
      prd_image:
        'https://firebasestorage.googleapis.com/v0/b/nightpass-2020.appspot.com/o/Stella%20Long%20Neck.jpg?alt=media&token=7b1e26f2-2db6-4f77-983a-75945bb7a4a1',
      prd_quant: 0,
    });

    aSubItem.push({
      prd_codigo: 1152,
      prd_nome: 'Cerveja Eisenbahn Long Neck',
      prd_formato: 'Garrafa 330 ml',
      prd_preco: '9,00',
      prd_image:
        'https://firebasestorage.googleapis.com/v0/b/nightpass-2020.appspot.com/o/Eisenbahn.jpg?alt=media&token=388eea21-df14-44c4-b803-d9639a30ea46',
      prd_quant: 0,
    });

    aSubItem.push({
      prd_codigo: 1153,
      prd_nome: 'Cerveja Heineken Long Neck',
      prd_formato: 'Garrafa 330 ml',
      prd_preco: '7,20',
      prd_image:
        'https://firebasestorage.googleapis.com/v0/b/nightpass-2020.appspot.com/o/Cerveja_Heineken_Long_Neck.jpg?alt=media&token=b236eb0e-43f6-4457-9e30-a94b977b22a3',
      prd_quant: 0,
    });

    //Atualiza o State para rendenizar a tela e exibir alterações.
    this.setState({aSubItem: aSubItem});
  }

  testealert(btnid) {
    alert(btnid);
    console.log(this.props.navigation.getParam('item', 'pad'));
  }

  goToVoltar() {
    this.props.navigation.navigate('CardapioInicial');
  }

  render = () => {
    return (
      <CardapioSecundarioView
        arrayMenuSec={this.state.aMenuSec}
        geraMenu={this.geraMenu}
        testealert={this.testealert}
        goToVoltar={() => this.goToVoltar()}
        criaSubMenu={() => this.criaSubMenu()}
        atualizaItem={(prd_codigo, aumento) =>
          this.atualizaItem(prd_codigo, aumento)
        }
        atualizaPedido={(prd_codigo, prd_quant, prd_nome) =>
          this.atualizaPedido(prd_codigo, prd_quant, prd_nome)
        }
        aSubItem={this.state.aSubItem}
        verPedido={() => this.verPedido()}
      />
    );
  };
}

export default CardapioSecundarioController;
