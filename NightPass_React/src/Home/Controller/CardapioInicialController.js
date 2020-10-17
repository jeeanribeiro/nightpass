import React from 'react';
import CardapioInicialView from '../View/CardapioInicialView';

class CardapioInicialController extends React.Component {

  constructor() {
    super();
  }

  goToBebidas() {
    this.props.navigation.navigate('CardapioSecundario', {item: 'Bebidas'});
  }

  goToPorcoes() {
    this.props.navigation.navigate('CardapioSecundario', {item: 'Porcoes'});
  }

  goToBoasVindas() {
    this.props.navigation.navigate('boasVindas');
  }

  render = () => {
    return (
      <CardapioInicialView
        goToBebidas={() => this.goToBebidas()}
        goToPorcoes={() => this.goToPorcoes()}
        goToBoasVindas={() => this.goToBoasVindas()}
      />
    );
  };
}

export default CardapioInicialController;
