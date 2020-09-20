import {StyleSheet} from 'react-native';

export default StyleSheet.create({
  BackgroundConteiner: {
    flexDirection: 'column',
    flex: 1,
    justifyContent: 'flex-start',
    backgroundColor: 'black',
  },

  //Barra inicial Logo e Nome do Estabelecimento

  barraEst: {
    flex: 1.5,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
  },

  fmtFotoLogo: {
    width: 60,
    height: 60,
    left: 20,
    top: 0,
    borderColor: 'rgba(115,202,255,1)',
    borderWidth: 2,
    borderRadius: 8,
  },

  fmtbaseNome: {
    width: '70%',
    backgroundColor: 'rgba(115,202,255,1)',
    borderRadius: 8,
    justifyContent: 'center',
  },

  fmtNomeEst: {
    color: '#1728FF',
    fontSize: 26,
    fontFamily: 'FiraSans-Medium',
    marginLeft: 10,
    textAlign: 'center',
  },

  barraGarcom: {
    marginLeft: 10,
    marginRight: 10,
    marginTop: 10,
    flex: 2.1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#DDDDDD',
  },

  fmtFotoGarcom: {
    padding: 10,
    height: '90%',
    width: '96%',
    resizeMode: 'contain',
    backgroundColor: 'transparent',
  },

  boxGarcom: {
    height: '94%',
    width: '35%',
    backgroundColor: 'black',
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 10,
  },

  boxmsgGarcom: {
    height: '94%',
    width: '35%',
    backgroundColor: 'transparent',
    marginLeft: 30,
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 10,
  },

  boxtransparent: {
    flex: 3.9,
    backgroundColor: 'transparent',
  },

  boxvazio: {
    flex: 0,
    backgroundColor: 'black',
  },

  textInfo: {
    fontSize: 30,
    color: 'blue',
    textAlign: 'center',
    fontFamily: 'MuseoModerno',
  },

  //Estilo Botões

  barraBotao1: {
    marginTop: 5,
    marginBottom: 5,
    flex: 1.5,
    flexDirection: 'row',
    backgroundColor: 'transparent',
    alignItems: 'center',
    justifyContent: 'center',
  },

  btnBarra1: {
    backgroundColor: '#000000',
    borderRadius: 10,
    padding: 1,
    paddingLeft: 10,
    paddingRight: 10,
    borderColor: '#FF00BF',
    borderWidth: 2,
    justifyContent: 'center',
    minWidth: 150,
    width: '30%',
  },

  btnfmtBarra1: {
    color: 'white',
    fontSize: 18,
    fontFamily: 'FiraSans-Regular',
    textAlign: 'center',
  },

  //Botões Padrão

  barraBotao2: {
    marginTop: 5,
    marginBottom: 5,
    flex: 0.5,
    flexDirection: 'row',
    backgroundColor: 'transparent',
    alignItems: 'center',
    justifyContent: 'center',
  },

  btnBarra2: {
    backgroundColor: '#000000',
    borderRadius: 10,
    padding: 1,
    paddingLeft: 10,
    paddingRight: 10,
    marginLeft: 10,
    borderColor: '#FF00BF',
    borderWidth: 2,
    justifyContent: 'center',
  },

  boxMsgFooter: {
    marginTop: 10,
    marginBottom: 5,
    marginLeft: 10,
    marginRight: 10,
    flex: 1,
    maxHeight: 30,
    flexDirection: 'column',
    backgroundColor: 'white',
    alignItems: 'flex-end',
    alignContent: 'flex-end',
    justifyContent: 'center',
    paddingRight: 10,
  },

  image: {
    position: 'absolute',
    width: '100%',
    resizeMode: 'cover',
    opacity: 1,
    zIndex: -7,
  },

  imageBack: {
    top: 0,
    left: 0,
    position: 'absolute',
    width: '100%',
    height: '100%',
    backgroundColor: 'white',
    zIndex: -6,
    opacity: 0.4,
  },

  boxbody: {
    flex: 24.6,
  },
});
