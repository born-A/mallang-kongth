import React, {useState} from "react";
import "./Login.css";
import {Link} from "react-router-dom";
import axios from "axios";

export default function Login() {

    const [id, setId] = useState('');
    const [password, setPassword] = useState('');

    const handleIdChange = (e) => {
        setId(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleSubmit = (e) => {
        if(id==''){
            e.preventDefault();
            alert("아이디를 입력해주세요!");
        }
        else if (password==''){
            e.preventDefault();
            alert("비밀번호를 입력해주세요");
        }
        else{
            e.preventDefault();
            // 입력된 아이디와 패스워드를 백엔드로 전달하는 axios 요청
            axios.post('/api/login', { id, password })
                .then((response) => {
                    // 성공적으로 요청을 처리한 경우의 로직
                    console.log('로그인 성공:', response.data);
                })
                .catch((error) => {
                    // 요청 처리 중에 에러가 발생한 경우의 로직
                    console.error('로그인 실패:', error);
                });
        }

    };

    const handleKakaoLogin = () => {
        // 로그인 처리 로직 작성
        // ...
    };

    // 네이버로 로그인
    const handleNaverLogin = () => {
        // 로그인 처리 로직 작성
        // ...
    };

    // 구글로 로그인
    const handleGoogleLogin = () => {
        // 로그인 처리 로직 작성
        // ...
    };



    return(
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                </div>

                <div className="box2">

                    {/* 인사말*/}
                    <div className="welcome">
                        <span>만나서 반가워요!</span>
                    </div>

                    {/* 로그인하기 */}
                    <form onSubmit={handleSubmit}>
                    <div className="loginInput">
                        <span>아이디 <input className="Id" type="email" value={id} onChange={handleIdChange} /></span>
                        <span>비밀번호 <input type="password" value={password} onChange={handlePasswordChange} /></span>
                    </div>
                    <div className="login">
                        <button className="login-button"> 로그인</button>
                    </div>

                    <div className="Integration-login">
                        <span>다른 아이디로 로그인하기</span>
                    </div>

                    <div className="logo">
                        <button className="kakao" onClick={handleKakaoLogin}>
                            카카오톡으로 로그인하기
                        </button>
                        <button className="naver" onClick={handleNaverLogin}>
                            네이버로 로그인하기
                        </button>
                        <button className="google" onClick={handleGoogleLogin}>
                            구글로 로그인하기
                        </button>
                    </div>

                    <div className="go-signup">
                        <span>아직 계정이 없으신가요?</span>
                        <Link to ="/Signup">회원가입</Link>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    )

}
