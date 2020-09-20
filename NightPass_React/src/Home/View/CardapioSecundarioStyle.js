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

  fmtMenuBar:{
    backgroundColor: 'transparent',
    alignItems: 'center',
    justifyContent: 'center',
    alignContent: 'center',
  },

  boxtransparent: {
    flex: 8.6,
    backgroundColor: 'transparent',
  },

  boxvazio: {
    flex: 0,
    backgroundColor: 'black',
  },
});
