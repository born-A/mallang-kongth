import React from "react";
import "../../css/eatAmount.css";
import { useState } from "react";
import {Link} from "react-router-dom";

export default function EatingAmount() {
    const [currentEatingAmount, setAmount] = useState('');
    const handleEatingAmount = (e) => {
        setAmount(e.target.value);
    };


    const [inputValue, setInputValue] = useState('');

    const openPopup = () => {
        const width = 350; // 작은 창의 가로 크기
        const height = 180; // 작은 창의 세로 크기
        const left = window.innerWidth / 2 - width / 2; // 가로 가운데 위치 계산
        const top = window.innerHeight / 2 - height / 2; // 세로 가운데 위치 계산

        const closePopup = () => {
            // 팝업창 닫기 동작
            window.close();
            closePopup.saveInputValue = saveInputValue;
        };

        const popup = window.open('', '_blank', `width=${width}, height=${height}, left=${left}, top=${top}`);
        const content = `
        <div style="text-align: center;">
            <h2>추가하기</h2>
            <input type="number" className="addMount" value="${inputValue}" onChange="{(event) => handleInputChange(event.target.value)}" 
         
            <p><button onclick=window.opener.saveInputValue('${inputValue}')>추가하기</button></p>
        </div>
        `;
                popup.document.open();
                popup.document.write(content);
                popup.document.close();
                popup.saveInputValue = saveInputValue;
            };

    const handleInputChange = (value) => {
        setInputValue(value);
    };

    const saveInputValue = (value) => {
        // 입력된 값 활용
        console.log('입력된 값:', value);
    };

    return (
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                    <Link to ="/mainPage"><span className="home">home</span></Link>
                </div>

                {/*<div className="boardName">
          <span className="missing">잔여량 확인</span>
        </div>*/}


                <div className="box-1">
                    {/* 급식기 */}
                    <div className="box-product">
                        <div className="box-productType">
                            <p>제품 유형 : 급식기</p>
                            <p>제품 번호 : FE55D7Q12</p>
                            <p>2023.04.22 ~ 2023.07.22</p>
                        </div>
                        <div className="box-productContent">
                            <p>식빵이(10살)</p>
                            <p>현재 잔여량</p>
                            <span onChange={handleEatingAmount}>[24g]</span>
                            <p><a href={window.location.href}>⟳ 데이터 불러오기</a></p>
                            <button onClick={openPopup} className="plus">추가 급여하기</button>
                            <button className="schedule">예약하기</button>
                        </div>
                    </div>

                    {/* 급수기 */}
                    <div className="box-product">
                        <div className="box-productType">
                            <p>제품 유형 : 급수기</p>
                            <p>제품 번호 : WC19S833</p>
                            <p>2023.04.22 ~ 2023.07.22</p>
                        </div>
                        <div className="box-productContent">
                            <p>마루(12살)</p>
                            <p>현재 잔여량</p>
                            <p><span onChange={handleEatingAmount}>[123ml]</span></p>
                            <p><a href={window.location.href}>⟳ 데이터 불러오기</a></p>
                            <button onClick={openPopup} className="plus">추가 급여하기</button>
                            <button className="schedule">예약하기</button>
                        </div>
                    </div>
                </div>
                <div className="empty">
                    <div></div>
                </div>





            </div>
        </div>
    );
}