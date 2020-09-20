/* eslint-disable no-alert */
import React from 'react';
import { View } from 'react-native';
import CardapioSecundarioView from '../View/CardapioSecundarioView';

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
      id: 'Sake',
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

    arrayMenuSec.push({
      id: 'Conhaque',
      Sel: false,
    });

    arrayMenuSec.push({
      id: 'Licor',
      Sel: false,
    });


    this.state = {
      aMenuSec: arrayMenuSec,
    };
  }

  testealert(btnid) {
    alert(btnid);
  }

  goTo() {
    this.props.navigation.navigate('xxxxx');
  }

  render = () => {
    return (
      <CardapioSecundarioView
        arrayMenuSec={this.state.aMenuSec}
        geraMenu={this.geraMenu}
        testealert={this.testealert}
      />
    );
  };
}

export default CardapioSecundarioController;
