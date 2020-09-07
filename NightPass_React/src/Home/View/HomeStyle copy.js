import {StyleSheet} from 'react-native';
export default StyleSheet.create({
  container: {
    flexDirection: 'column',
    flex: 1,
    justifyContent: 'center',
  },
  textInfo: {
    fontSize: 30,
    color: 'blue',
    textAlign: 'center',
    fontFamily: 'MuseoModerno',
  },

  image: {
    flex: 1,
    resizeMode: 'cover',
    opacity: 0.8,
    justifyContent: 'center',
    },
});
