import React from 'react';
import {View, Text, ImageBackground} from 'react-native';
import styles from './HomeStyle';

const image = '../View/Images/TelaFundo.jpg';

const HomeView = () => {
  return (
    <View style={styles.container}>
      <ImageBackground source={require(image)} style={styles.image} />
    </View>
  );
};
export default HomeView;
