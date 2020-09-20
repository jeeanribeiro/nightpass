import React from 'react';
import {
  View,
  Text,
  ImageBackground,
  TouchableOpacity,
  Image,
} from 'react-native';
import stylesBoas from './BoasvindasStyle';
import stylesHome from './HomeStyle';
import stylesCardInic from './CardapioIncialStyle';

const image = '../View/Images/TelaFundo.jpg';
const imgLogo = '../View/Images/LogoBluePub.jpg';
const imgGarcom = '../View/Images/rosto-garçom.png';

const CardapioInicialView = (props) => {
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

        <View style={stylesBoas.barraEst}>
          <View style={stylesBoas.fmtbaseNome}>
            <Text style={stylesBoas.fmtNomeEst}>The Blue Pub</Text>
          </View>
          <Image source={require(imgLogo)} style={stylesBoas.fmtFotoLogo} />
        </View>

        <View style={stylesHome.boxMsg1}>
          <Text style={stylesHome.fmtTextoNormal}>
            Fique a vontade em sua escolha!
          </Text>
        </View>

        <View style={stylesCardInic.boxbtnCardapio}>
          <TouchableOpacity
            style={stylesCardInic.btnBarraCardapio}
            onPress={props.goToBebidas}>
            <Text style={stylesCardInic.btnfmtCardapio}>Bebidas</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesCardInic.btnBarraCardapio}
            onPress={''}>
            <Text style={stylesCardInic.btnfmtCardapio}>Porções</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesCardInic.btnBarraCardapio}
            onPress={''}>
            <Text style={stylesCardInic.btnfmtCardapio}>Sanduíches</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesCardInic.btnBarraCardapio}
            onPress={''}>
            <Text style={stylesCardInic.btnfmtCardapio}>Saldados</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesCardInic.btnBarraCardapio}
            onPress={''}>
            <Text style={stylesCardInic.btnfmtCardapio}>Refeições</Text>
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
        </View>

        <View style={stylesBoas.boxMsgFooter}>
          <Text style={stylesHome.fmtTextoNormal}>Comanda: 110</Text>
        </View>

        <View style={stylesBoas.boxvazio} />
      </View>
    </View>
  );
};

export default CardapioInicialView;
