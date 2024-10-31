import { Slot } from "expo-router";
import { Text, View } from "react-native";

function Header(){
  return(
    <View>
      <Text>Header</Text>
    </View>
  );
}

function Footer(){
  return(
    <View>
      <Text>Footer</Text>
    </View>
  );
}

export default function Home(){
  return(
    <View>
      <Header></Header>
      <Slot></Slot>
      <Footer></Footer>
    </View>
  )
}