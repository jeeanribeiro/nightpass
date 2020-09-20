import React from 'react';
import BoasvindasView from '../View/BoasvindasView';

class BoasvindasController extends React.Component {
  constructor() {
    super();
  }

  goToCardapioInicial() {
    this.props.navigation.navigate('CardapioInicial');
  }

  render = () => {
    return (
      <BoasvindasView goToCardapioInicial={() => this.goToCardapioInicial()} />
    );
  };
}

export default BoasvindasController;
