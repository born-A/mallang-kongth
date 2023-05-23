import "./Signup.css";
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Signup() {
    const [inputs, setInputs] = useState({
        userId: '',
        userPW: '',
        re_password: ''
    });

    const navigate = useNavigate();

    const onChange = (e) => {
        const { name, value } = e.target;
        const nextInputs = { ...inputs, [name]: value };
        setInputs(nextInputs);
    };

    function CheckPass(str) {
        let reg1 = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@$!%*#?&]{6,}$/;
        return reg1.test(str);
    }

    function letsJoin() {
        if (inputs.userId === "") {
            alert("아이디를 입력해주세요!");
            return;
        } else if (inputs.userPW === "") {
            alert("비밀번호를 입력해주세요!");
            return;
        } else if (inputs.re_password === "") {
            alert("비밀번호 중복 확인을 입력해주세요!");
            return;
        } else if (CheckPass(inputs.userPW) === false) {
            alert("비밀번호는 영문+숫자 6자를 조합하여 입력해주세요!");
            return;
        } else if (inputs.re_password !== inputs.userPW) {
            alert("비밀번호가 동일하지 않습니다!");
            return;
        } else {
            fetch("/register", {
                method: 'post',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify({
                    userId: inputs.userId,
                    userPW: inputs.userPW,
                })
            }).then(res => res.json())
                .then(response => {
                    if (response === true) {
                        navigate("/login");
                    } else {
                        alert("다시 시도해주세요");
                    }
                });
        }
    }

    return (
        <div className="userJoinOuter">
            <div className="form-box login-register-form-element" id="userJoinInner">
                <div className="background">
                    <div className="box">
                        <div className="header">
                            <h1>말랑콩떡</h1>
                        </div>
                        <form className="form" id="registerFrm" name="register-page">
                            <h2 className="form-box-title">계정 만들기</h2>

                            <div className="form-row">
                                <div className="form-item">
                                    <div className="form-input">
                                        <input type="text" id="userId" name="userId" onChange={onChange} placeholder="아이디" />
                                    </div>
                                </div>
                            </div>

                            <div className="form-row">
                                <div className="form-item">
                                    <div className="form-input">
                                        <input type="password" id="userPW" name="userPW" onChange={onChange} placeholder="비밀번호" />
                                    </div>
                                </div>
                            </div>

                            <div className="form-row">
                                <div className="form-item">
                                    <div className="form-input">
                                        <input type="password" id="re_password" name="re_password" onChange={onChange} placeholder="비밀번호 확인" />
                                    </div>
                                </div>
                            </div>

                            <div className="form-row">
                                <div className="form-item">
                                    <input type="button" className="button medium primary" onClick={letsJoin} id="joinBtn" value="가입하기" />
                                </div>
                            </div>

                            <div className="form-row">
                                <div className="form-item">
                                    <button className="button-link" onClick={() => navigate("/login")}>로그인하러가기</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Signup;
