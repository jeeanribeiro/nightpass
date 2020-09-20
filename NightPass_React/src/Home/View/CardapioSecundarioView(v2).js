import React from 'react';
import {View, Text, TouchableOpacity, Image} from 'react-native';
import stylesBoas from './BoasvindasStyle';
import stylesHome from './HomeStyle';
import stylesCardSec from './CardapioSecundarioStyle';
import {FlatList} from 'react-native-gesture-handler';

const image = '../View/Images/TelaFundo.jpg';
const imgLogo = '../View/Images/LogoBluePub.jpg';
const imgGarcom = '../View/Images/rosto-garçom.png';

const CardapioSecundarioView = (props) => {
  return (
    <View style={stylesBoas.BackgroundConteiner}>
      <View style={stylesBoas.imageBack} />

      <Image source={require(image)} style={stylesBoas.image} />

      <View style={stylesHome.boxhead}>
        <Text style={stylesHome.tituloPrincipal}>NightPass</Text>
        <TouchableOpacity
          style={stylesHome.btnPrincipal}
          onPress={props.onClick}>
          <Text style={stylesHome.btnFormat}>login</Text>
        </TouchableOpacity>
      </View>

      <View style={stylesHome.boxbody}>
        {/* Conteúdo do corpo */}

        <View style={stylesHome.boxMsg1}>
          <Text style={stylesHome.fmtTextoNormal}>
            Fique a vontade em sua escolha!
          </Text>
        </View>

        <View style={stylesCardSec.boxMenu}>
          <TouchableOpacity
            style={{props.arrayMenuSec[0].exibe}}
            onPress={props.goToBoasvindas}>
            <Text style={stylesCardSec.btnfmtCardSec}>
            {props.arrayMenuSec[0].id}
            </Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={stylesCardSec.btnCardSecNS}
            onPress={props.goToBoasvindas}>
            <Text style={stylesCardSec.btnfmtCardSecNS}>Whisk</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={stylesCardSec.btnCardSecNS}
            onPress={props.goToBoasvindas}>
            <Text style={stylesCardSec.btnfmtCardSecNS}>Tequila</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={stylesCardSec.btnCardSecNS}
            onPress={props.goToBoasvindas}>
            <Text style={stylesCardSec.btnfmtCardSecNS}>Caipirinha</Text>
          </TouchableOpacity>
        </View>

        <View style={stylesBoas.boxtransparent} />

        <View style={stylesBoas.barraBotao2}>
          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={props.goToBoasvindas}>
            <Text style={stylesHome.btnfmtBarra1}>Ver Pedido</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={props.goToBoasvindas}>
            <Text style={stylesHome.btnfmtBarra1}>Ver Conta</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={props.goToBoasvindas}>
            <Text style={stylesHome.btnfmtBarra1}>Voltar</Text>
          </TouchableOpacity>
        </View>

        <View style={stylesBoas.boxMsgFooter}>
          <Text style={stylesHome.fmtTextoNormal}>Comanda: 110</Text>
        </View>

        <View style={stylesBoas.boxvazio} />
      </View>
    </View>
  );
};

export default CardapioSecundarioView;
