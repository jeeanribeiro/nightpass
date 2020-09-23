import React from 'react';
import BoasvindasView from '../View/BoasvindasView';

class BoasvindasController extends React.Component {
  constructor() {
    super();
  }

  goToCardapioInicial() {
    this.props.navigation.navigate('CardapioInicial');
  }

  goToHome() {
    this.props.navigation.navigate('Home');
  }

  render = () => {
    return (
      <BoasvindasView
        goToCardapioInicial={() => this.goToCardapioInicial()}
        goToHome={() => this.goToHome()}
      />
    );
  };
}

export default BoasvindasController;
