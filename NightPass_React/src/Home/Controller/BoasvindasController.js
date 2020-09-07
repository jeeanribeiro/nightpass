import React from 'react';
import BoasvindasView from '../View/BoasvindasView';

class BoasvindasController extends React.Component {
  constructor() {
    super();
  }

  goTo() {
    this.props.navigation.navigate('xxxxx');
  }

  render = () => {
    return <BoasvindasView />;
  };

}

export default BoasvindasController;
