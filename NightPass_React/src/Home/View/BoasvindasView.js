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

const image = '../View/Images/TelaFundo.jpg';
const imgLogo = '../View/Images/LogoBluePub.jpg';
const imgGarcom = '../View/Images/rosto-garçom.png';

const BoasvindasView = (props) => {
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
            Olá Alexandre seja bem vindo
          </Text>
        </View>

        <View style={stylesBoas.barraGarcom}>
          <View style={stylesBoas.boxGarcom}>
            <Image
              source={require(imgGarcom)}
              style={stylesBoas.fmtFotoGarcom}
            />
          </View>
          <View style={stylesBoas.boxmsgGarcom}>
            <Text style={[stylesHome.fmtTextoNormal, {textAlign: 'center'}]}>
              Você será atendido pelo Ronaldo
            </Text>
          </View>
        </View>

        <View style={stylesBoas.barraBotao1}>
          <TouchableOpacity
            style={stylesBoas.btnBarra1}
            onPress={props.goToCardapioInicial}>
            <Text style={stylesBoas.btnfmtBarra1}>
              Veja nosso cardápio aqui
            </Text>
          </TouchableOpacity>
        </View>

        <View style={stylesBoas.boxtransparent} />

        <View style={stylesBoas.barraBotao2}>
          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={() => alert('em implementação')}>
            <Text style={stylesHome.btnfmtBarra1}>Ver Pedido</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={() => alert('em implementação')}>
            <Text style={stylesHome.btnfmtBarra1}>Ver Conta</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={props.goToHome}>
            <Text style={stylesHome.btnfmtBarra1}>Voltar</Text>
          </TouchableOpacity>

        </View>

        <View style={stylesBoas.boxMsgFooter}>
          <Text style={stylesHome.fmtTextoNormal}>
            Comanda: 110
          </Text>
        </View>

        <View style={stylesBoas.boxvazio} />
      </View>
    </View>
  );
};

export default BoasvindasView;
