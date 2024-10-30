import axios from "axios";
import { useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

const AA = () => {
    const [data,setData] = useState('초기값');
    const changeData = async() => {
        const res = await axios.get('http://localhost:20005/test/aa');
        setData('변경된 값'+res.data);
    };
    return ( 
    <View style={styles.container}>
        <Text style={styles.text}>AA</Text>
        <Text style={styles.text}>{data}</Text>
        <TouchableOpacity onPress={changeData}>
        <Text style={styles.text}>Press me</Text>
        </TouchableOpacity>
    </View>
    );
};
 
export default AA;

const styles = StyleSheet.create({
    container:{
        backgroundColor: "#fff",
        padding: 20,
        margin: 40,
    },
    text:{
        fontSize: 25,
        fontFamily: "JUA"
    }
})