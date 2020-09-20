import React from 'react';
import CardapioInicialView from '../View/CardapioInicialView';

class CardapioInicialController extends React.Component {
  constructor() {
    super();
  }

  goToBebidas() {
    this.props.navigation.navigate('CardapioSecundario');
  }

  render = () => {
    return <CardapioInicialView goToBebidas={() => this.goToBebidas()} />;
  };
}

export default CardapioInicialController;
