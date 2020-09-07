import React from 'react';

import {createAppContainer} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import {createDrawerNavigator} from 'react-navigation-drawer';
import HomeController from '../Home/Controller/HomeController';
import BoasvindasController from '../Home/Controller/BoasvindasController';

const opcoesNav = createStackNavigator(
  {
    Home: HomeController,
    boasVindas: BoasvindasController,
  },
  {
    //oculta a barra de navegação por padrão
    defaultNavigationOptions: {
      headerShown: false,
    },
  },
);

const AppLogged = createDrawerNavigator({
  opcoesNav,
  initialRouteName: 'Places',
});

const AppContainer = createAppContainer(AppLogged);

export default class MainNavigation extends React.Component {
  render = () => {
    return <AppContainer />;
  };
}