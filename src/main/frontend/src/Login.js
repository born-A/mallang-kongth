import React from 'react';
import { useState } from 'react';
import { Link, Route, Routes } from 'react-router-dom';
import './Login.css';
import Signup from "./Signup";

function Login() {
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

    return (
        <div className="login-container">
            <form onSubmit={handleSubmit}>
                <h1>말 랑 콩 떡</h1>
                <h2>만나서 반가워요 !</h2>
                <label>ID</label>
                <input type="text" value={id} onChange={handleIdChange} />
                <label>Password</label>
                <input type="password" value={password} onChange={handlePasswordChange} />
                <button type="submit" className="login">로그인</button>
                <div>
                    <h3>↓다른 아이디로 로그인하기↓</h3>
                </div>
                <div className="container">
                    <div className="row">
                        <div className="col-12">
                            <div>
                                <button type="button" className="kakao">카카오톡</button>
                                <button type="button" className="naver">네이버</button>
                                <button type="button" className="google">구글</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <p><Link to="/Signup">아직 계정이 없으신가요?</Link></p>

        </div>
    );
}

export default Login;
