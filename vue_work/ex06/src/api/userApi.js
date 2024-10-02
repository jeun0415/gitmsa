import axios from 'axios';
import { GLOBAL_URL } from './util';

const URL = `${GLOBAL_URL}/user`;

// await 사용하려면 async(비동기 함수? 시간이 걸리는 상황이 있다는 것을 알려줌) 같이 적어줘야 함
export const getUsers = async () => {
  try {
    // await 시간이 끝나고 나서 진행한다는 의미
    const res = await axios.get(`${URL}/select`);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

export const saveUser = async (item) => {
  try{
  const res = await axios.put(`${URL}/update`,item);
  return res;
  }catch(e){
    console.log(e);
    return e;
  }
};

export const deleteUser = async(idx) => {
  try{
    const res = await axios.delete(`${URL}/delete/${idx}`);
    return res;
  }catch(e){
    console.log(e);
    return e;
  }
};
