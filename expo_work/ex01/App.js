import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Pressable, TouchableOpacity, Alert } from 'react-native';

export default function App() {

  const doPress1 = () => {
    Alert.alert('doPress1');
    console.log("test111");
  };
  const doPress2 = () => {
    Alert.alert('doPress2');
    console.log("test222");
  };

  return (
    // div
    <View style={styles.container}>
      <Text style={styles.text}>Open up App.js to start working on your app!</Text>
      <Text style={styles.text}>This is a simple React Native app.</Text>
      <Text style={styles.text}>To run this app, follow these steps:</Text>
      <TouchableOpacity style={styles.button} onPress={doPress1}>
        <Text style={styles.text}>누르는 버튼</Text>
      </TouchableOpacity>
      <Pressable style={styles.button} onPress={doPress2}>
        <Text style={styles.text}>누르는 버튼</Text>
      </Pressable>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#999',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 24,
    color: 'white',
  },
  button: {
    backgroundColor: 'orange',
    padding: 10,
    borderRadius: 5,
    color: 'white',
    marginTop: 10,
  }
});
