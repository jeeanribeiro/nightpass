import {StyleSheet} from 'react-native';

export default StyleSheet.create({
  boxMenu: {
    marginTop: 5,
    marginBottom: 5,
    marginLeft: 10,
    marginRight: 10,
    flex: 0.4,
    flexDirection: 'row',
    backgroundColor: 'white',
    alignItems: 'center',
    alignContent: 'center',
    justifyContent: 'center',
  },

  btnCardSec: {
    borderRadius: 10,
    marginLeft: 5,
    marginTop: 5,
    marginBottom: 5,
    padding: 0,
    paddingLeft: 10,
    paddingRight: 10,
    backgroundColor: 'rgb(136, 0, 255)',
    borderColor: 'black',
    borderWidth: 2,
    justifyContent: 'center',
  },

  btnfmtCardSec: {
    color: 'rgb(255, 247, 0)',
    fontSize: 16,
    fontFamily: 'FiraSans-Medium',
    textAlign: 'center',
  },

  btnCardSecNS: {
    borderRadius: 10,
    marginLeft: 5,
    padding: 0,
    paddingLeft: 10,
    paddingRight: 10,
    backgroundColor: 'rgb(235, 212, 255)',
    borderColor: 'rgb(64, 57, 62)',
    borderWidth: 2,
    justifyContent: 'center',
  },

  btnfmtCardSecNS: {
    color: 'black',
    fontSize: 16,
    fontFamily: 'FiraSans-Medium',
    textAlign: 'center',
  },

  boxMenu2: {
    marginTop: 5,
    marginBottom: 5,
    marginLeft: 10,
    marginRight: 10,
    backgroundColor: 'gray',
    maxHeight: 40,
  },

  fmtMenuBar: {
    backgroundColor: 'transparent',
    alignItems: 'center',
    justifyContent: 'center',
    alignContent: 'center',
  },

  boxtransparent: {
    flex: 1.6,
    backgroundColor: 'transparent',
  },

  boxvazio: {
    flex: 0,
    backgroundColor: 'black',
  },

  boxBody: {
    flex: 16.4,
    flexDirection: 'column',
    justifyContent: 'flex-start',
  },

  boxFooter: {
    flex: 3,
    backgroundColor: 'transparent',
  },

  //Estilos do menu de subitens

  boxSubMenu: {
    backgroundColor: 'transparent',
    marginLeft: 10,
    marginRight: 10,
    maxHeight: '80%',
  },

  boxSubItem: {
    height: 100,
    width: '100%',
    backgroundColor: 'rgba(255,255,255,0.9)',
    alignSelf: 'center',
    marginBottom: 8,
    borderWidth: 2,
    borderColor: '#FF00BF',
    justifyContent: 'center',
    flexDirection: 'row',
  },

  boxImgItem: {
    height: '98%',
    flex: 0.9,
    //borderWidth: 1,
    //borderColor: 'black',
  },

  boxDescItem: {
    height: '98%',
    flex: 1.4,
    justifyContent: 'center',
    //borderWidth: 1,
    //borderColor: 'black',
  },

  fmtTextoNormal: {
    color: 'black',
    fontSize: 14,
    fontFamily: 'FiraSans-Medium',
    marginLeft: 10,
    textAlign: 'left',
  },

  boxPedidoItem: {
    height: '98%',
    flex: 0.7,
    flexDirection: 'column',
    justifyContent: 'center',
    //borderWidth: 1,
    //borderColor: 'black',
  },

  boxfmtImgItem: {
    height: '96%',
    width: '96%',
    resizeMode: 'contain',
  },

  //Estilo botão quantidade e adicionar

  btnQuant: {
    backgroundColor: 'transparent',
    flexDirection: 'row',
    borderRadius: 10,
    padding: 1,
    paddingLeft: 5,
    paddingRight: 5,
    borderColor: '#FF00BF',
    borderWidth: 2,
    justifyContent: 'space-between',
    alignContent: 'center',
    alignItems: 'center',
    width: '90%',
    height: '35%',
    alignSelf: 'center',
  },

  fmtMaisMenos: {
    color: 'red',
    fontSize: 22,
    fontFamily: 'MuseoModerno-Bold',
    textAlign: 'center',
  },

  fmtQuant: {
    color: 'black',
    fontSize: 18,
    fontFamily: 'FiraSans-Medium',
    textAlign: 'center',
  },

  btnAdicionar: {
    backgroundColor: 'black',
    borderRadius: 10,
    padding: 1,
    paddingLeft: 5,
    paddingRight: 5,
    borderColor: '#FF00BF',
    borderWidth: 2,
    alignContent: 'center',
    alignItems: 'center',
    alignSelf: 'center',
    marginTop: 8,
  },

  fmtAdicionar: {
    color: 'white',
    fontSize: 13,
    fontFamily: 'FiraSans-Regular',
    textAlign: 'center',
  },

});
