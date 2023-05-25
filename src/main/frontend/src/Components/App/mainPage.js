import React from "react";
import "../../css/mainPage.css";
import {Link} from "react-router-dom";

export default function MainPage(){
    //const { name, birth } = props.location.state;


    return(
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                    <Link to ="/mainPage"><span className="home">home</span></Link>
                </div>

                {/* 반려동물 등록 전 메인화면 */}
                <div className="before-mainpage">
                    {/* 인삿말 */}
                    <div className="greeting">
                        <span><h2>환영합니다. __님!</h2></span>
                        <span>소중한 가족을 등록해주세요 :)</span>
                        <Link to ={"/petRegister"}><button className="registering">등록하기</button></Link>
                    </div>

                    {/* 게시판 */}
                    <div className="mainpage-board">
                        <div className="board-header">
                            실종 게시판
                        </div>
                        <div className="board-list">
                            <div className="board-image1"></div>
                            <div className="board-image1"></div>
                            <div className="board-image1"></div>
                        </div>
                    </div>
                    <div><Link to ={"/boardList"}><button className="go-board">전체 게시판 보러가기</button></Link></div>

                    {/* 게시판 */}
                    <div className="mainpage-purchase">
                        <div className="purchase-header">
                            급수기/급식기
                        </div>
                        <div className="board-purchase">
                            <div className="board-image2">
                                <Link to="/eatAmount"><button className="current-remaining-amount">현재 잔여량 확인하기</button></Link>
                            </div>
                            <div className="board-image2">
                                <button className="go-apply">급수기/급식기 신청하기</button>
                            </div>


                        </div>

                    </div>



                </div>
            </div>
        </div>

    )
}


