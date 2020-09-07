import React, {useState} from 'react';
import {View, Text, Image, TouchableOpacity, Alert} from 'react-native';
import styles from './HomeStyle';

const HomeView = (props) => {

  const imgFachada = '../View/Images/the-blue-pub-fachada-nv.jpg';
  const imgLogo = '../View/Images/LogoBluePub.jpg';

  return (
    <View style={styles.container}>
      <View style={styles.boxhead}>
        <Text style={styles.tituloPrincipal}>NightPass</Text>
        <TouchableOpacity style={styles.btnPrincipal} onPress={props.onClick}>
          <Text style={styles.btnFormat}>login</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.boxMsg1}>
        <Text style={styles.fmtTextoNormal}>Olá Alexandre, você está no:</Text>
      </View>

      <View style={styles.boxEst}>
        <Image source={require(imgLogo)} style={styles.fmtFotoLogo} />
        <Text style={styles.fmtNomeEst}>The Blue Pub</Text>
        <Image source={require(imgFachada)} style={styles.fmtFotoFachada} />
      </View>

      <View style={styles.boxMsg1}>
        <Text style={styles.fmtTextoNormal}>
          Vamos lá, faça o check-in aqui:
        </Text>
      </View>

      <View style={styles.barraBotao1}>
        <TouchableOpacity style={styles.btnBarra1} onPress={props.goToBoasvindas}>
          <Text style={styles.btnfmtBarra1}>Sim estou aqui {props.value} </Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={styles.btnBarra1}
          onPress={() => alert('alerta1')}>
          <Text style={styles.btnfmtBarra1}>Agora não </Text>
        </TouchableOpacity>
      </View>
      <View style={styles.boxbody} />
    </View>
  );
};
export default HomeView;
