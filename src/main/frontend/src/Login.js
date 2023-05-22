import React, {useState} from "react";
import "./Login.css";
import {Link} from "react-router-dom";

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
        e.preventDefault();
        console.log(`Id: ${id}, Password: ${password}`);
        // 여기서는 console.log로만 출력했지만, 이 부분을 실제 로그인 로직으로 대체하면 됩니다.
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
                    <div className="loginInput">
                        <span>아이디 <input className="Id" type="email" value={id} onChange={handleIdChange} /></span>
                        <span>비밀번호 <input type="password" value={password} onChange={handlePasswordChange} /></span>
                    </div>
                    <div className="login">
                        <button className="login-button" onChange={handleSubmit}> 로그인</button>
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

                </div>
            </div>
        </div>
    )

}
