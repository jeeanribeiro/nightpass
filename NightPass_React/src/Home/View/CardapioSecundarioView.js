/* eslint-disable react-native/no-inline-styles */
import React from 'react';
import {View, Text, TouchableOpacity, Image, Button} from 'react-native';
import stylesBoas from './BoasvindasStyle';
import stylesHome from './HomeStyle';
import stylesCardSec from './CardapioSecundarioStyle';
import {
  FlatList,
  ScrollView,
  TouchableWithoutFeedback,
} from 'react-native-gesture-handler';

const image = '../View/Images/TelaFundo.jpg';
const imgLogo = '../View/Images/LogoBluePub.jpg';
const imgGarcom = '../View/Images/rosto-garçom.png';

const CardapioSecundarioView = (props) => {
  // Conteudo para geração do array de botões

  const RenderMenu = ({item}) => (
    <TouchableOpacity
      style={stylesCardSec.btnCardSec}
      onPress={() => props.criaSubMenu()}>
      <Text style={stylesCardSec.btnfmtCardSec}>{item.id}</Text>
    </TouchableOpacity>
  );

  const renderSubMenu = ({item}) => (
    <View style={stylesCardSec.boxSubItem}>
      <View style={stylesCardSec.boxImgItem}>
        <Image
          source={{uri: item.prd_image}}
          style={stylesCardSec.boxfmtImgItem}
        />
      </View>
      <View style={stylesCardSec.boxDescItem}>
        <Text style={stylesCardSec.fmtTextoNormal}>{item.prd_nome}</Text>
        <Text
          style={[stylesCardSec.fmtTextoNormal, {fontFamily: 'FiraSans-Bold'}]}>
          R$ {item.prd_preco}
        </Text>
      </View>
      <View style={stylesCardSec.boxPedidoItem}>
        <View style={stylesCardSec.btnQuant}>
          <TouchableOpacity
            onPress={() => props.atualizaItem(item.prd_codigo, false)}>
            <Text style={stylesCardSec.fmtMaisMenos}>-</Text>
          </TouchableOpacity>
          <Text style={stylesCardSec.fmtQuant}>{item.prd_quant}</Text>
          <TouchableOpacity
            onPress={() => props.atualizaItem(item.prd_codigo, true)}>
            <Text style={stylesCardSec.fmtMaisMenos}>+</Text>
          </TouchableOpacity>
        </View>
        <TouchableOpacity
          style={stylesCardSec.btnAdicionar}
          onPress={() =>
            props.atualizaPedido(item.prd_codigo, item.prd_quant, item.prd_nome)
          }>
          <Text style={stylesCardSec.fmtAdicionar}>adicionar</Text>
        </TouchableOpacity>
      </View>
    </View>
  );

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

      <View style={stylesCardSec.boxBody}>
        {/* Conteúdo do corpo */}
        <View style={stylesHome.boxMsg1}>
          <Text style={stylesHome.fmtTextoNormal}>
            Fique a vontade em sua escolha!
          </Text>
        </View>

        <FlatList
          style={stylesCardSec.boxMenu2}
          horizontal={true}
          data={props.arrayMenuSec}
          renderItem={RenderMenu}
          keyExtractor={(item) => item.id}
        />

        <FlatList
          style={stylesCardSec.boxSubMenu}
          data={props.aSubItem}
          renderItem={renderSubMenu}
          keyExtractor={(item) => item.prd_codigo + item.prd_nome}
        />
      </View>

      {/*Footrer */}
      <View style={stylesCardSec.boxFooter}>
        <View style={stylesBoas.barraBotao2}>
          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={props.verPedido}>
            <Text style={stylesHome.btnfmtBarra1}>Ver Pedido</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={() => alert('em implementação')}>
            <Text style={stylesHome.btnfmtBarra1}>Ver Conta</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={stylesBoas.btnBarra2}
            onPress={props.goToVoltar}>
            <Text style={stylesHome.btnfmtBarra1}>Voltar</Text>
          </TouchableOpacity>
        </View>
        <View style={stylesBoas.boxMsgFooter}>
          <Text style={stylesHome.fmtTextoNormal}>Comanda: 110</Text>
        </View>
      </View>
    </View>
  );
};

export default CardapioSecundarioView;
