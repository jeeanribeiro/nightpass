import {StyleSheet} from 'react-native';
export default StyleSheet.create({
  container: {
    flexDirection: 'column',
    flex: 1,
    backgroundColor: '#DDDDDD',
  },

  boxhead: {
    flex: 1.4,
    flexDirection: 'row',
    backgroundColor: 'black',
    alignItems: 'center',
    alignContent: 'center',
    margin: 'auto',
  },

  btnPrincipal: {
    position: 'absolute',
    right: 15,
    backgroundColor: '#051a01',
    borderRadius: 5,
    paddingLeft: 12,
    paddingRight: 12,
  },

  btnFormat: {
    color: '#FF00BF',
    fontSize: 18,
    fontFamily: 'FiraSans-SemiBold',
  },

  boxMsg1: {
    marginTop: 10,
    marginBottom: 5,
    marginLeft: 10,
    marginRight: 10,
    flex: 0.9,
    flexDirection: 'column',
    backgroundColor: 'white',
    alignItems: 'center',
    alignContent: 'center',
    justifyContent: 'center',
    margin: 'auto',
  },

  boxEst: {
    marginTop: 5,
    marginBottom: 0,
    flex: 10,
    flexDirection: 'column',
    backgroundColor: 'rgba(115,202,255,1)',
    borderRadius: 10,
    alignItems: 'center',
    alignContent: 'center',
    margin: 'auto',
    alignSelf: 'center',
    width: '90%',
    maxHeight: 280,
  },

  fmtFotoFachada: {
    width: '95%',
    height: '82%',
    borderRadius: 15,
    resizeMode: 'center',
  },

  fmtFotoLogo: {
    width: 70,
    height: 70,
    position: 'absolute',
    left: 0,
    top: 0,
    zIndex: 5,
    borderColor: 'rgba(115,202,255,1)',
    borderWidth: 5,
    borderRadius: 8,
  },

  //Estilos dos botões de corpo

  barraBotao1: {
    marginTop: 5,
    marginBottom: 5,
    flex: 1.3,
    flexDirection: 'row',
    backgroundColor: 'transparent',
    alignItems: 'center',
    justifyContent: 'space-evenly',
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
  },

  btnfmtBarra1: {
    color: 'white',
    fontSize: 16,
    fontFamily: 'FiraSans-Regular',
    textAlign: 'center',
  },

  boxbody: {
    flex: 6,
  },

  textInfo: {
    fontSize: 30,
    color: 'blue',
    textAlign: 'center',
    fontFamily: 'MuseoModerno-Bold',
  },

  //Formatos de texto

  fmtTextoNormal: {
    color: 'black',
    fontSize: 16,
    fontFamily: 'FiraSans-Medium',
    marginLeft: 10,
  },

  fmtNomeEst: {
    color: '#1728FF',
    fontSize: 26,
    fontFamily: 'FiraSans-Medium',
    marginLeft: 10,
  },

  tituloPrincipal: {
    color: '#FF00BF',
    fontSize: 20,
    fontFamily: 'MuseoModerno-Bold',
    marginLeft: 10,
  },
});
