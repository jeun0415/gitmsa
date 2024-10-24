import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
	// 변수 적는 곳
	state: () => ({
		loginCheck: false,
		nickName: '',
		thumbnail: '',
		profileImage: '',
		email: '',
		userId: '',
	}),
	// 함수 적는 곳
	actions: {
		login(data) {
			// login 성공
			this.loginCheck = true;
			this.userId = data.userId;
			this.nickName = data.nickname;
			this.thumbnail = data.thumbnail_image;
			this.profileImage = data.profile_image;
			this.email = data.email;
		},
		logout() {
			this.loginCheck = false;
			this.userId = '';
			this.nickName = '';
			this.thumbnail = '';
			this.profileImage = '';
			this.email = '';
		},
	},
});
