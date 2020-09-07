import React from 'react';
import HomeView from '../View/HomeView';
import HomeModel from '../Model/HomeModel';

//const {navigate} = this.props.navigation;

class HomeController extends React.Component {
  constructor() {
    super();
    let homeModel = new HomeModel();
    console.log(homeModel.returnText());
  }

  state = {
    value: 1,
  };

  handleClick() {
    this.setState({value: this.state.value + 1});
  }

  goToBoasvindas() {
    this.props.navigation.navigate('boasVindas');
  }

  render = () => {
    return (
      <HomeView
        goToBoasvindas={() => this.goToBoasvindas()}
        value={this.state.value}
      />
    );
  };
}

export default HomeController;
